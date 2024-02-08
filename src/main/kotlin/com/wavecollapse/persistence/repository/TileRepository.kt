package main.kotlin.com.wavecollapse.persistence.repository

import main.kotlin.com.wavecollapse.business.Tile
import java.util.*

interface TileRepository {
    fun save(tile : Tile) : Tile
    fun getAll() : MutableIterable<Tile>
    fun deleteById(id: UUID)
    fun deleteAll()
    fun saveAll(tiles: MutableIterable<Tile>):MutableIterable<Tile>
    fun count() : Long
    fun findById(id : UUID) : Tile?
    fun findAllById(ids: MutableIterable<UUID>): MutableIterable<Tile>
    fun existsById(id: UUID): Boolean
    fun delete(tile: Tile)
}