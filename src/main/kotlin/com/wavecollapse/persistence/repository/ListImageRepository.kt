package main.kotlin.com.wavecollapse.persistence.repository

import main.kotlin.com.wavecollapse.business.Image
import java.util.*

class ListImageRepository : ImageRepository {
    // fake implementation of local storage
    // For ideal: use persistence.model for saving to DB
    private val images : MutableMap<UUID, Image> = mutableMapOf()

    override fun save(image: Image) {
        images[image.id] = image
    }

    override fun getAll(): Map<UUID, Image> = images
    override fun findById(id: UUID): Image? = images[id]

    override fun getUniqueID(): UUID {
        var id = UUID.randomUUID()
        while(images.containsKey(id))
            id = UUID.randomUUID()
        return id
    }

}