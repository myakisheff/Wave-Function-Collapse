package com.wavecollapse.presentation.model

import com.wavecollapse.business.Tile

class TileViewModel(
    private val tile : Tile?
) {
    fun strings(): List<String> {
        val list = mutableListOf<String>()

        if(tile == null) return list

        if(tile.tile is Array<*> && tile.tile.isArrayOf<Array<String>>())
        {
            tile.tile.forEach {
                list.add((it as Array<*>).joinToString(""))
            }
        }

        if(tile.tile is String)
        {
                list.add(tile.tile)
        }
        return list
    }
}