package main.kotlin.com.wavecollapse.persistence.repository

import main.kotlin.com.wavecollapse.business.Image

interface ImageRepository {
    fun save(image : Image)
    fun getAll() : List<Image>
    fun findById(id : Int) : Image?
}