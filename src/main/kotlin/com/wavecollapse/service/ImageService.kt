package com.wavecollapse.service

import com.wavecollapse.business.Image
import com.wavecollapse.business.Tile
import com.wavecollapse.persistence.repository.ImageRepository
import java.util.*

class ImageService(
    private val repository: ImageRepository
) {
    fun default(tiles : MutableIterable<Tile>): Image {
        val img = Image(
            UUID.randomUUID(),
            tiles.toMutableList(),
            5,
            5
        )
        return repository
            .save(img)
            .let{img}
    }

    fun get(id: UUID): Image? =
        repository.findById(id)

    fun createNewImage(img: Image): Image =
        repository.save(img)
}