package test.kotlin.com.wavecollapse.service

import com.wavecollapse.business.Image
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
            //img.addConnection(it, )
        }

        assertTrue(img.correct().first)
    }

    private fun testImage() : Image
    {
        val tileOne = Tile(
            id = UUID.randomUUID(),
            tile = "|",
            canGrow = true,
        )
        val tileTwo = Tile(
            id = UUID.randomUUID(),
            tile = " ",
            canGrow = true,
        )
        val tileThree = Tile(
            id = UUID.randomUUID(),
            tile = "_",
            canGrow = true,
        )

        return Image(
            id = UUID.randomUUID(),
            tiles = mutableListOf(tileOne, tileTwo, tileThree),
            height = 4,
            width = 4
        )
    }
}