package main.kotlin.com.wavecollapse.persistence.repository

import main.kotlin.com.wavecollapse.business.Image
import java.util.*

interface ImageRepository {
    fun save(image : Image)
    fun getAll() : Map<UUID, Image>
    fun findById(id : UUID) : Image?
    fun getUniqueID(): UUID
}