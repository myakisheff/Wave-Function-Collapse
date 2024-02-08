package com.wavecollapse.presentation.view

import com.wavecollapse.presentation.model.TileViewModel

fun renderTileView(tile: TileViewModel)
{
    tile.strings().forEach{
        println(it)
    }
}