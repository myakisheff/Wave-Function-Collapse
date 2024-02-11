package com.wavecollapse.business

import java.util.UUID

class Tile (
    val id : UUID,
    val tile : Any,
){
    // if every tile have connections
    /*private val connections : MutableMap<Side, MutableList<UUID>> = mutableMapOf()

    fun addConnection(side : Side, tileID : UUID)
    {
        connections[side]?.add(tileID) ?: {connections[side] = mutableListOf(tileID)}

    }

    fun addConnection(side : Side, tileIDs: List<UUID>)
    {
        tileIDs.forEach {
            connections[side]?.add(it) ?: {connections[side] = mutableListOf(it)}
        }
    }*/
}