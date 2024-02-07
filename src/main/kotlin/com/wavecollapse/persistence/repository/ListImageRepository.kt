package main.kotlin.com.wavecollapse.persistence.repository

import main.kotlin.com.wavecollapse.business.Image

class ListImageRepository : ImageRepository {
    // fake implementation of local storage
    // For ideal: use persistence.model for saving to DB
    private val images : MutableList<Image> = mutableListOf()
    override fun save(image: Image) {
        images.add(image)
    }

    override fun getAll(): List<Image> = images

    override fun findById(id: Int): Image? = images.find { it.id == id }
}