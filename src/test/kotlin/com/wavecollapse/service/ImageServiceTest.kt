package test.kotlin.com.wavecollapse.service

import main.kotlin.com.wavecollapse.business.Image
import main.kotlin.com.wavecollapse.business.Tile
import main.kotlin.com.wavecollapse.service.ImageService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import test.kotlin.com.wavecollapse.fakeRepository.InMemoryImageRepository
import java.util.*

class ImageServiceTest {
    @Test
    fun `when new image is created it can be found`()
    {
        val tileOne = Tile(
            id = UUID.randomUUID(),
            tile = "|"
        )
        val tileTwo = Tile(
            id = UUID.randomUUID(),
            tile = " "
        )
        val tileThree = Tile(
            id = UUID.randomUUID(),
            tile = "_"
        )

        val img = Image(
            id = UUID.randomUUID(),
            tiles = mutableListOf(tileOne, tileTwo, tileThree),
            height = 5,
            width = 4
        )

        val service = ImageService(InMemoryImageRepository())
        val savedImage = service.createNewTile(img)
        Assertions.assertNotNull(service.get(savedImage.id))
    }
}