package com.wavecollapse.service

import com.wavecollapse.business.Image
import com.wavecollapse.business.Side
import com.wavecollapse.business.Tile
import com.wavecollapse.persistence.repository.ImageRepository
import com.wavecollapse.presentation.model.ImageViewModel
import com.wavecollapse.presentation.view.renderImageView
import java.util.*

class ImageService(
    private val repository: ImageRepository
) {
    fun default(tiles : MutableIterable<Tile>): Image {
        val img = Image(
            UUID.randomUUID(),
            "Example",
            tiles.toMutableList(),
            15,
            15
        )

        // Add connections
        // ╠
        img.addConnection(
            UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.TOP)

        img.addConnection(
            UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
            listOf(
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.RIGHT)

        img.addConnection(
            UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.BOTTOM)

        img.addConnection(
            UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
            listOf(
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.LEFT)

        // ╩
        img.addConnection(
            UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.TOP)

        img.addConnection(
            UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
            listOf(
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.RIGHT)

        img.addConnection(
            UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
            listOf(
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.BOTTOM)

        img.addConnection(
            UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
            listOf(
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.LEFT)

        // ╗
        img.addConnection(
            UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
            listOf(
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.TOP)

        img.addConnection(
            UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.RIGHT)

        img.addConnection(
            UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07")
            ),
            Side.BOTTOM)

        img.addConnection(
            UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.LEFT)

        // ╚
        img.addConnection(
            UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.TOP)

        img.addConnection(
            UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
            listOf(
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.RIGHT)

        img.addConnection(
            UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
            listOf(
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.BOTTOM)

        img.addConnection(
            UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
            listOf(
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.LEFT)

        // ╔
        img.addConnection(
            UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90"),
            listOf(
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.TOP)

        img.addConnection(
            UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90"),
            listOf(
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.RIGHT)

        img.addConnection(
            UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.BOTTOM)

        img.addConnection(
            UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90"),
            listOf(
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf")
            ),
            Side.LEFT)

        // ╝
        img.addConnection(
            UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.TOP)

        img.addConnection(
            UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.RIGHT)

        img.addConnection(
            UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf"),
            listOf(
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.BOTTOM)

        img.addConnection(
            UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90")
            ),
            Side.LEFT)

        //
        img.addConnection(
            UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf"),
                UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341")
            ),
            Side.TOP)

        img.addConnection(
            UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf"),
                UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341")
            ),
            Side.RIGHT)

        img.addConnection(
            UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf"),
                UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341")
            ),
            Side.BOTTOM)

        img.addConnection(
            UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341"),
            listOf(
                UUID.fromString("bd2291d5-bfbc-48b1-bb84-576a016bd259"),
                UUID.fromString("0754299d-4c89-414f-840d-50d61ad1eefe"),
                UUID.fromString("f5f763c4-3cf1-4e04-a2ed-78fb9c8927d7"),
                UUID.fromString("d07e4dad-71de-4b48-add8-c91de7268d07"),
                UUID.fromString("270760f7-4a93-4984-90c8-6d7bfcd7cb90"),
                UUID.fromString("17a55163-8217-492f-a5ed-ee1ef79f0abf"),
                UUID.fromString("acc6d4c8-b0cb-49fd-ae20-7761c924f341")
            ),
            Side.LEFT)

        img.createImage()

        return repository
            .save(img)
            .let{img}
    }

    fun get(id: UUID): Image? =
        repository.findById(id)

    fun getByTag(tag: String): Image {
        val allImages = repository.getAll()
        return allImages.first { it.tag == tag }
    }

    fun createNewImage(img: Image): Image =
        repository.save(img)
}