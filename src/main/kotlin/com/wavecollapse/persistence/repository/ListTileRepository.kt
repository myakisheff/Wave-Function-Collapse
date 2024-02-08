package com.wavecollapse.persistence.repository

import com.wavecollapse.business.Tile
import java.util.UUID

class ListTileRepository : TileRepository {
    // fake implementation
    // For ideal: use persistence.model for saving to DB
    private val storage : MutableMap<UUID, Tile> = mutableMapOf()

    override fun save(tile: Tile) : Tile {
        storage[tile.id] = tile
        return tile
    }

    override fun getAll(): MutableIterable<Tile> = storage.values
    override fun deleteById(id: UUID) {
        storage.remove(id)
    }

    override fun deleteAll() {
        storage.clear()
    }

    override fun saveAll(tiles: MutableIterable<Tile>): MutableIterable<Tile> {
        tiles.forEach { storage[it.id] = it }
        return tiles
    }

    override fun count(): Long = storage.size.toLong()

    override fun findById(id: UUID): Tile? = storage[id]
    override fun findAllById(ids: MutableIterable<UUID>): MutableIterable<Tile> =
        storage
            .filterKeys { it in ids }
            .values
            .toMutableList()

    override fun existsById(id: UUID): Boolean =
        storage.containsKey(id)

    override fun delete(tile: Tile) {
        storage.remove(tile.id)
    }
}