package main.kotlin.com.wavecollapse.persistence.repository

import main.kotlin.com.wavecollapse.business.Image
import java.util.*

class ListImageRepository : ImageRepository {
    // fake implementation of local storage
    // For ideal: use persistence.model for saving to DB
    private val storage : MutableMap<UUID, Image> = mutableMapOf()

    override fun save(image: Image) : Image {
        storage[image.id] = image
        return image
    }

    override fun getAll(): MutableIterable<Image> = storage.values
    override fun findById(id: UUID): Image? = storage[id]
    override fun deleteById(id: UUID) {
        storage.remove(id)
    }

    override fun deleteAll() {
        storage.clear()
    }

    override fun saveAll(tiles: MutableIterable<Image>): MutableIterable<Image> {
        tiles.forEach { storage[it.id] = it }
        return tiles
    }

    override fun count(): Long = storage.size.toLong()

    override fun findAllById(ids: MutableIterable<UUID>): MutableIterable<Image> =
        storage
            .filterKeys { it in ids }
            .values
            .toMutableList()

    override fun existsById(id: UUID): Boolean =
        storage.containsKey(id)

    override fun delete(image: Image) {
        storage.remove(image.id)
    }
}