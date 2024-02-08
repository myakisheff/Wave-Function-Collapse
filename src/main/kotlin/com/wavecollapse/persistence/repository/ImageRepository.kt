package com.wavecollapse.persistence.repository

import com.wavecollapse.business.Image
import java.util.*

interface ImageRepository {
    fun save(image : Image) : Image
    fun getAll() : MutableIterable<Image>
    fun findById(id : UUID) : Image?
    fun deleteById(id: UUID)
    fun deleteAll()
    fun saveAll(tiles: MutableIterable<Image>):MutableIterable<Image>
    fun count() : Long
    fun findAllById(ids: MutableIterable<UUID>): MutableIterable<Image>
    fun existsById(id: UUID): Boolean
    fun delete(image: Image)
}