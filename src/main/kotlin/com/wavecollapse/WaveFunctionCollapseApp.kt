package com.wavecollapse

import com.wavecollapse.persistence.repository.ListImageRepository
import com.wavecollapse.persistence.repository.ListTileRepository
import com.wavecollapse.presentation.controller.ImageController
import com.wavecollapse.presentation.controller.TileController
import com.wavecollapse.service.ImageService
import com.wavecollapse.service.TileService
import mu.KotlinLogging

val kLogger = KotlinLogging.logger {}

fun main() {
    println("There is Wave Function Collapse implementation in Console!\n")

    // We need it because there fake repositories (not a DB)
    val imagesRep = ListImageRepository()
    val tilesRep = ListTileRepository()

    val imageController = ImageController(ImageService(imagesRep))

    // create default tiles
    val tileIds = TileController(TileService(tilesRep)).addDefaultTiles()

    // get created tiles
    val tiles = TileController(TileService(tilesRep)).getTiles(tileIds)

    var i = 0
    do {
        // create example image
        val res = imageController
            .create(ImageService(imagesRep).default(tiles, i))

        if(res.first) kLogger.info { res.second }
        else kLogger.error { res.second }

        println()

        // show created image
        imageController
            .get(imageController.getByTag("Example")?.id.toString())

        i++

        println("Generate again? [Y/N]")

    }while (checkYN(readln()))

}

fun checkYN(message : String) : Boolean
{
    return when(message)
    {
        "Y" -> true
        "N" -> false
        else -> {
            println("Print Y or N")
            checkYN(readln())
        }
    }
}