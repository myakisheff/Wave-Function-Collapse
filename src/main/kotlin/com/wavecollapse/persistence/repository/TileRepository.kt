package main.kotlin.com.wavecollapse.persistence.repository

import main.kotlin.com.wavecollapse.business.Tile
import java.util.*

interface TileRepository {
    fun save(tile : Tile)
    fun getAll() : Map<UUID, Tile>
    fun findById(id : UUID) : Tile?
    fun getUniqueID(): UUID
}