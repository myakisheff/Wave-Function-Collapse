package com.wavecollapse.business

import java.util.UUID

class Image(
    val id : UUID,
    val tiles : MutableList<Tile>,
    val height : Int,
    val width : Int,
) {
    private val connections: MutableMap<UUID, MutableMap<Side, MutableList<UUID>>> = mutableMapOf()

    fun correct(): Message
    {
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

    fun addConnection(ownTile: Tile, attachedTile: Tile, side: Side)
    {
        if(connections.containsKey(ownTile.id))
            connections[ownTile.id]?.get(side)?.add(attachedTile.id)
        else connections[ownTile.id] = mutableMapOf(Pair(side, mutableListOf(attachedTile.id)))
    }
}
typealias Message = Pair<Boolean, String>