package com.wavecollapse.presentation.controller

import com.wavecollapse.business.Image
import com.wavecollapse.presentation.model.ImageViewModel
import com.wavecollapse.presentation.view.renderImageView
import com.wavecollapse.service.ImageService
import java.util.UUID

class ImageController(
    private val imageService: ImageService
) {
    fun get(id: String): Boolean{
        val idUUID = try {
            UUID.fromString(id)
        } catch (e: IllegalArgumentException) {
            return false
        }

        val image = imageService.get(idUUID)
            ?: return false

        renderImageView(ImageViewModel(image))

        return true
    }

    fun getByTag(tag: String): Image?{
        val img = try {
            imageService.getByTag(tag)
        } catch (e: NoSuchElementException)
        {
            return null
        }
        return img
    }

    fun create(image: Image): Pair<Boolean, String>{
        val createdImage = imageService.createNewImage(image)
        val message = createdImage.correct()
        return Pair(message.first, message.second)
    }
}