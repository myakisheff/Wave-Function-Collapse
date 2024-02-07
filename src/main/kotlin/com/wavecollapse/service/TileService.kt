package main.kotlin.com.wavecollapse.service

import main.kotlin.com.wavecollapse.business.Tile
import main.kotlin.com.wavecollapse.persistence.repository.ListTileRepository

class TileService(
    private val repository: ListTileRepository
) {
    fun default() {
        var tile : Tile
        for(i in 1..4)
        {
            val id = repository.getUniqueID()
            val view = Array(3) { Array(3) { " " } }
            when(i)
            {
                1 -> { // vertical
                    view[0][1] = "*"
                    view[1][1] = "*"
                    view[2][1] = "*"
                }
                2 -> { // horizontal
                    view[1][0] = "*"
                    view[1][1] = "*"
                    view[1][2] = "*"
                }
                3 -> { // cross
                    view[0][1] = "*"
                    view[1][1] = "*"
                    view[2][1] = "*"
                    view[1][0] = "*"
                    view[1][2] = "*"
                }
            }
            tile = Tile(
                id,
                view,
            )
            repository.save(tile)
        }
    }
}