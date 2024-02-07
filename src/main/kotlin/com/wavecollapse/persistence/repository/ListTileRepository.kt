package main.kotlin.com.wavecollapse.persistence.repository

import main.kotlin.com.wavecollapse.business.Tile

class ListTileRepository : TileRepository {
    // fake implementation of local storage
    // For ideal: use persistence.model for saving to DB
    private val tiles : MutableList<Tile> = mutableListOf()
    override fun save(tile: Tile) {
        tiles.add(tile)
    }

    override fun getAll(): List<Tile> = tiles

    override fun findById(id: Int): Tile? = tiles.find { it.id == id }
}