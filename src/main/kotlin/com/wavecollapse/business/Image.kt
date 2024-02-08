package com.wavecollapse.business

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

    init {
        for(i in 0..<height)
        {
            createdImage.add(mutableListOf())

            for(j in 0..<width)
            {
                createdImage[i].add(ImageCell())
            }
        }

        createdImage.forEach { line ->
            line.forEach { cell ->
                tiles.forEach {
                    cell.availableTilesIds.add(it.id)
                    cell.availableTilesIds.remove(UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341"))
                }
            }
        }
    }

    fun getImage() = createdImage

    fun createImage() {
        if(!correct().first)
            return

        val widthPos = (0..<width).random()
        val heightPos = (0..<height).random()

        setTilesRecursive(widthPos, heightPos)

        createdImage.forEach { line ->
            line.forEach { cell ->
                if (cell.tileID == null) return
            }
        }
    }
    private fun setTilesRecursive(widthPos: Int, heightPos: Int){
        if(widthPos < 0 || widthPos >= width || heightPos < 0 || heightPos >= height)
            return

        if(createdImage[heightPos][widthPos].tileID != null)
            return

        createdImage[heightPos][widthPos].tileID =
            try{
                createdImage[heightPos][widthPos].availableTilesIds.random()
            } catch (e: NoSuchElementException)
            {
                UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341")
            }

        // remove not available ids for near cells
        val idsToRemove = mutableListOf<UUID>()

        if(heightPos + 1 < height) {
            createdImage[heightPos + 1][widthPos].availableTilesIds.forEach {
                if (connections[createdImage[heightPos][widthPos].tileID]?.get(Side.BOTTOM)?.contains(it) == false) {
                    idsToRemove.add(it)
                }
            }
            createdImage[heightPos + 1][widthPos].availableTilesIds.removeAll(idsToRemove.toSet())
            idsToRemove.clear()
        }

        if(widthPos + 1 < width){
            createdImage[heightPos][widthPos + 1].availableTilesIds.forEach {
                if (connections[createdImage[heightPos][widthPos].tileID]?.get(Side.RIGHT)?.contains(it) == false) {
                    idsToRemove.add(it)
                }
            }
            createdImage[heightPos][widthPos + 1].availableTilesIds.removeAll(idsToRemove.toSet())
            idsToRemove.clear()
        }

        if(heightPos - 1 >= 0){
            createdImage[heightPos - 1][widthPos].availableTilesIds.forEach {
                if (connections[createdImage[heightPos][widthPos].tileID]?.get(Side.TOP)?.contains(it) == false) {
                    idsToRemove.add(it)
                }
            }
            createdImage[heightPos - 1][widthPos].availableTilesIds.removeAll(idsToRemove.toSet())
            idsToRemove.clear()
        }

        if(widthPos - 1 >= 0){
            createdImage[heightPos][widthPos - 1].availableTilesIds.forEach {
                if (connections[createdImage[heightPos][widthPos].tileID]?.get(Side.LEFT)?.contains(it) == false) {
                    idsToRemove.add(it)
                }
            }
            createdImage[heightPos][widthPos - 1].availableTilesIds.removeAll(idsToRemove.toSet())
            idsToRemove.clear()
        }

        setTilesRecursive(widthPos + 1, heightPos)
        setTilesRecursive(widthPos, heightPos + 1)
        setTilesRecursive(widthPos - 1, heightPos)
        setTilesRecursive(widthPos, heightPos - 1)
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