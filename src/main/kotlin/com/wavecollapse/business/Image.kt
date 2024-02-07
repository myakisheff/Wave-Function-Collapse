package main.kotlin.com.wavecollapse.business

import java.util.UUID

class Image(
    val id : UUID,
    val tiles : MutableList<Tile>,
    val height : Int,
    val width : Int,
) {
    private val connections: MutableMap<UUID, MutableMap<Side, MutableList<UUID>>> = mutableMapOf()

    fun IsCorrect() : Boolean = connections.size == tiles.size

    fun addConnection(ownTile: Tile, attachedTile: Tile, side: Side)
    {
        if(connections.containsKey(ownTile.id))
            connections[ownTile.id]?.get(side)?.add(attachedTile.id)
        else connections[ownTile.id] = mutableMapOf(Pair(side, mutableListOf(attachedTile.id)))
    }
}