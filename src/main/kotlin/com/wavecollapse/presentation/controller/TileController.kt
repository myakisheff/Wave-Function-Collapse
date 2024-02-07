package main.kotlin.com.wavecollapse.presentation.controller

import main.kotlin.com.wavecollapse.service.TileService

class TileController(
    private val tileService: TileService
) {
    fun addDefaultTiles(){
        val img = tileService.default()
    }
}