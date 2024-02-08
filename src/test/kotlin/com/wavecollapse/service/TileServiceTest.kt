package test.kotlin.com.wavecollapse.service

import main.kotlin.com.wavecollapse.business.Tile
import main.kotlin.com.wavecollapse.service.TileService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import test.kotlin.com.wavecollapse.fakeRepository.InMemoryTileRepository
import java.util.*

internal class TileServiceTest {

    @Test
    fun `when new tile is created it can be found`()
    {
        val tile = Tile(
            id = UUID.randomUUID(),
            tile = "*"
        )

        val service = TileService(InMemoryTileRepository())
        val savedTile = service.createNewTile(tile)
        assertNotNull(service.get(savedTile.id))
    }
}