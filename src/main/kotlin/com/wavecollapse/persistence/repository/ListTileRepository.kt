package main.kotlin.com.wavecollapse.persistence.repository

import main.kotlin.com.wavecollapse.business.Tile
import java.util.UUID

class ListTileRepository : TileRepository {
    // fake implementation of local storage
    // For ideal: use persistence.model for saving to DB
    private val tiles : MutableMap<UUID, Tile> = mutableMapOf()

    override fun save(tile: Tile) {
        tiles[tile.id] = tile
    }

    override fun getAll(): Map<UUID, Tile> = tiles

    override fun findById(id: UUID): Tile? = tiles[id]
    override fun getUniqueID(): UUID {
        var id = UUID.randomUUID()
        while(tiles.containsKey(id))
            id = UUID.randomUUID()
        return id
    }
}