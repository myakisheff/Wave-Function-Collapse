package test.kotlin.com.wavecollapse.service

import com.wavecollapse.business.Image
import com.wavecollapse.business.Side
import com.wavecollapse.business.Tile
import com.wavecollapse.service.ImageService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import test.kotlin.com.wavecollapse.fakeRepository.InMemoryImageRepository
import java.util.*

class ImageServiceTest {
    @Test
    fun `when new image is created it can be found`()
    {
        val img = testImage()

        val service = ImageService(InMemoryImageRepository())
        val savedImage = service.createNewImage(img)
        Assertions.assertNotNull(service.get(savedImage.id))
    }

    @Test
    fun `correct image checking with connections`()
    {
        val img = testImage()

        img.tiles.forEach {
            img.addConnection(
                it.id,
                listOf(
                    UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                    UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe")
                ),
                Side.TOP)

            img.addConnection(
                it.id,
                listOf(
                    UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                    UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe")
                ),
                Side.RIGHT)

            img.addConnection(
                it.id,
                listOf(
                    UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                    UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe")
                ),
                Side.BOTTOM)

            img.addConnection(
                it.id,
                listOf(
                    UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                    UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe")
                ),
                Side.LEFT)
        }

        assertTrue(img.correct().first)
    }

    private fun testImage() : Image
    {
        val tileOne = Tile(
            id = UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
            tile = "|",
            canGrow = true,
        )
        val tileTwo = Tile(
            id = UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
            tile = " ",
            canGrow = true,
        )

        return Image(
            id = UUID.randomUUID(),
            tag = "Test",
            tiles = mutableListOf(tileOne, tileTwo),
            height = 4,
            width = 4
        )
    }
}