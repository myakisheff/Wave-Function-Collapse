package com.wavecollapse.service

import com.wavecollapse.business.Tile
import com.wavecollapse.persistence.repository.TileRepository
import java.util.*

class TileService(
    private val repository: TileRepository
) {
    fun default(): MutableIterable<UUID> {
        var tile : Tile
        val ids = mutableListOf<UUID>(
            UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),    // ╠
            UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),    // ╩
            UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),    // ╗
            UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),    // ╚
            UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90"),    // ╔
            UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf"),    // ╝
            UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341")     //
        )
        for(i in 0..6)
        {
            val id = ids[i]
//            while(repository.existsById(id))
//                id = UUID.randomUUID()

            val view = when(i)
            {
                0 -> "╠"
                1 -> "╩"
                2 -> "╗"
                3 -> "╚"
                4 -> "╔"
                5 -> "╝"
                else -> " "
            }
            tile = Tile(
                id,
                view,
            )
            repository.save(tile)
        }
        return ids
    }

    fun get(id: UUID): Tile? =
        repository.findById(id)

    fun createNewTile(tile: Tile): Tile = repository.save(tile)
    fun getAllById(ids: MutableIterable<UUID>): MutableIterable<Tile> =
        repository.findAllById(ids)
}