package main.kotlin.com.wavecollapse.persistence.repository

import main.kotlin.com.wavecollapse.business.Tile

interface TileRepository {
    fun save(tile : Tile)
    fun getAll() : List<Tile>
    fun findById(id : Int) : Tile?
}