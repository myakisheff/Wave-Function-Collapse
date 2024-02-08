package com.wavecollapse.service

import com.wavecollapse.business.Tile
import com.wavecollapse.presentation.model.TileViewModel
import org.junit.jupiter.api.Assertions.assertEquals
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
            tile = "*",
        )

        val service = TileService(InMemoryTileRepository())
        val savedTile = service.createNewTile(tile)
        assertNotNull(service.get(savedTile.id))
    }

    @Test
    fun `is tile printing correct`()
    {
        val tile = Tile(
            id = UUID.randomUUID(),
            tile = Array(3) { Array(3) { "*" } },
        )

        val tileViewModel = TileViewModel(tile).strings()
        val correctStrings = listOf("***", "***","***")
        assertEquals(tileViewModel, correctStrings)
    }
}