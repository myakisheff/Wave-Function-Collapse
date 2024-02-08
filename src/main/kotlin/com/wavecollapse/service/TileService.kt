package com.wavecollapse.service

import com.wavecollapse.business.Tile
import com.wavecollapse.persistence.repository.TileRepository
import java.util.*

class TileService(
    private val repository: TileRepository
) {
    fun default(): MutableIterable<UUID> {
        var tile : Tile
        val ids = mutableListOf<UUID>()
        for(i in 1..6)
        {
            var id = UUID.randomUUID()
            while(repository.existsById(id))
                id = UUID.randomUUID()

            val view = when(i)
            {
                1 -> "╠"
                2 -> "╩"
                3 -> "╗"
                4 -> "╚"
                5 -> "╔"
                6 -> "╝"
                else -> " "
            }
            tile = Tile(
                id,
                view,
                true,
            )
            repository.save(tile)
            ids.add(tile.id)
        }
        return ids
    }

    fun get(id: UUID): Tile? =
        repository.findById(id)

    fun createNewTile(tile: Tile): Tile = repository.save(tile)
    fun getAllById(ids: MutableIterable<UUID>): MutableIterable<Tile> =
        repository.findAllById(ids)
}