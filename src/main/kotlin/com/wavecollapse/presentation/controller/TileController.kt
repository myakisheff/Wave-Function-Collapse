package main.kotlin.com.wavecollapse.presentation.controller

import main.kotlin.com.wavecollapse.service.ImageService

class TileController(
    private val imageService: ImageService
) {
    fun defaultImage(){
        val img = imageService.default()

    }
}