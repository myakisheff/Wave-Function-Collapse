package com.wavecollapse.business

import com.wavecollapse.kLogger
import java.util.UUID

class Image(
    val id : UUID,
    val tag : String,
    val tiles : MutableList<Tile>,
    val height : Int,
    val width : Int,
) {
    private val connections: MutableMap<UUID, MutableMap<Side, MutableList<UUID>>> = mutableMapOf()
    private val createdImage : MutableList<MutableList<ImageCell>> = mutableListOf()
    private val usedCells : MutableList<UsedCells> = mutableListOf()
    var blankTileId : UUID? = null

    private fun initEmptyImage(){
        createdImage.clear()

        for(i in 0..<height)
        {
            createdImage.add(mutableListOf()) // add a row

            for(j in 0..<width)
            {
                createdImage[i].add(ImageCell()) // add a cell in a row
            }
        }

        // add all tiles to available tiles for all cells
        createdImage.forEach { line ->
            line.forEach { cell ->
                tiles.forEach {
                    cell.availableTilesIds.add(it.id)
                }
            }
        }
    }

    fun getImage() = createdImage

    fun createImage() {
        if(!correct().first)
            return

        // set random position for the first tile
        val widthPos = (0..<width).random()
        val heightPos = (0..<height).random()

        kLogger.info { "Starts generating from $heightPos, $widthPos" }

        initEmptyImage()
        setTiles(widthPos, heightPos)

        var lineInt = 0
        var colInt = 0
        // check for not filled tiles
        createdImage.forEach { line ->
            line.forEach { cell ->
                if (cell.tileID == null) {
                    kLogger.warn { "Tile ${lineInt}, ${colInt++} not filled" }
                }
            }
            lineInt++
            colInt = 0
        }
    }

    private tailrec fun setTiles(widthPos: Int, heightPos: Int){
        var isPass = true

        if(widthPos < 0 || widthPos >= width || heightPos < 0 || heightPos >= height)
            isPass = false

        if(isPass && createdImage[heightPos][widthPos].tileID != null)
            isPass = false

        if(!isPass)
        {
            if(usedCells.size > 0) {
                val deletedCell = usedCells.removeAt(0)
                setTiles(deletedCell.widthPos, deletedCell.heightPos)
            }
            return
        }

        // set a random tile
        createdImage[heightPos][widthPos].tileID =
            try{
                createdImage[heightPos][widthPos].availableTilesIds.random()
            } catch (e: NoSuchElementException)
            {
                kLogger.info { "No suitable tile for $heightPos, $widthPos" }
                blankTileId ?: return
            }

        val idsToRemove = mutableSetOf<UUID>()

        // reduce entropy of near cells
        for(i in (0..3))
        {
            var h = 0
            var w = 0
            var side = Side.BOTTOM
            when(i)
            {
                0 -> {h = 1; w = 0; side = Side.BOTTOM}
                1 -> {h = -1; w = 0; side = Side.TOP}
                2 -> {h = 0; w = 1; side = Side.RIGHT}
                3 -> {h = 0; w = -1; side = Side.LEFT}
            }
            try {
                createdImage[heightPos + h][widthPos + w].availableTilesIds.forEach {
                    if (connections[createdImage[heightPos][widthPos].tileID]?.get(side)?.contains(it) == false) {
                        idsToRemove.add(it)
                    }
                }
                createdImage[heightPos + h][widthPos + w].availableTilesIds.removeAll(idsToRemove)
                idsToRemove.clear()
                usedCells.add(UsedCells(widthPos + w,heightPos + h,
                    createdImage[heightPos + h][widthPos + w].availableTilesIds.size))
            } catch (_: IndexOutOfBoundsException){}
        }

        // go to cell with the lowest count of possible tiles
        usedCells.sortedBy { it.count }
        val deletedCell = usedCells.removeAt(0)
        setTiles(deletedCell.widthPos, deletedCell.heightPos)
    }

    fun correct(): Message {
        if(!correctConnectionsCount())
            return Pair(false, "Not enough connections of image $id")
        if(!correctSize())
            return Pair(false, "Bad size of image $id")
        if(!correctConnections())
            return Pair(false, "Bad connections of image $id")

        return Pair(true,"Image $id created")
    }
    private fun correctConnectionsCount() : Boolean {
        tiles.forEach { if(!connections.containsKey(it.id)) return false }

        return true
    }
    private fun correctSize(): Boolean = height > 0 && width > 0
    private fun correctConnections() : Boolean {
        return true
    }
    fun addConnection(ownTileID: UUID, attachedTileIDs: List<UUID>, side: Side){
        // tiles.first { it.id == ownTileID }.addConnection(side, attachedTileIDs) // if every tile have connections

        attachedTileIDs.forEach {
            if(connections.containsKey(ownTileID))
                if(connections[ownTileID]?.containsKey(side) == true)
                    connections[ownTileID]?.get(side)?.add(it)
                else connections[ownTileID]?.set(side, mutableListOf(it))
            else connections[ownTileID] = mutableMapOf(Pair(side, mutableListOf(it)))
        }
    }
}
typealias Message = Pair<Boolean, String>