package main.kotlin.com.wavecollapse.service

import main.kotlin.com.wavecollapse.business.Image
import main.kotlin.com.wavecollapse.business.Tile
import main.kotlin.com.wavecollapse.persistence.repository.ListImageRepository
import java.util.*

class ImageService(
    private val repository: ListImageRepository
) {
    fun default(tiles : MutableList<Tile>): Image {
        val img = Image(
            UUID.randomUUID(),
            tiles,
            5,
            5
        )
        return repository
            .save(img)
            .let{img}
    }
}