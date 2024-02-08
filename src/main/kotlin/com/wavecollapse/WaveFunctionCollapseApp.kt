package com.wavecollapse

import com.wavecollapse.persistence.repository.ListImageRepository
import com.wavecollapse.persistence.repository.ListTileRepository
import com.wavecollapse.presentation.controller.ImageController
import com.wavecollapse.presentation.controller.TileController
import com.wavecollapse.service.ImageService
import com.wavecollapse.service.TileService
import mu.KotlinLogging

private val kLogger = KotlinLogging.logger {}

fun main() {
    println("There is Wave Function Collapse implementation in Console!\n")

    // We need it because there fake repositories (not a DB)
    val imagesRep = ListImageRepository()
    val tilesRep = ListTileRepository()

    println("Example: ")
    println("Tiles: ")
    val tileIds = TileController(TileService(tilesRep)).addDefaultTiles()
    val tiles = TileController(TileService(tilesRep)).getTiles(tileIds)

    // create example image
    val res = ImageController(ImageService(imagesRep))
        .create(ImageService(imagesRep).default(tiles))

    println()
    println("Result: ")

    if(res.first) kLogger.info { res.second }
    else kLogger.error { res.second }

    print("╠")
    print("╩")
    println("╗")

    print("╠")
    print("╗")
    println("╠")

    print("╚")
    print("╝")
    println("╚")

    print("╔")
    print("╗")
    println(" ")

    print(" ")
    print("╠")
    println("╗")

    println("Generate again?")
}