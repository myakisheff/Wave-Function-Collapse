package com.wavecollapse.presentation.controller

import com.wavecollapse.business.Tile
import com.wavecollapse.presentation.model.TileViewModel
import com.wavecollapse.presentation.view.renderTileView
import com.wavecollapse.service.TileService
import java.util.*

class TileController(
    private val tileService: TileService
) {
    fun getTiles(ids: MutableIterable<UUID>) : MutableIterable<Tile> = tileService.getAllById(ids)
    fun addDefaultTiles(): MutableIterable<UUID>{
        val default = tileService.default()
        default.forEach {
            renderTileView(tile = TileViewModel(tileService.get(it)))
        }
        return default
    }
}