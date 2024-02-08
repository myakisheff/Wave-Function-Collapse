package com.wavecollapse.presentation.model

import com.wavecollapse.business.Image

class ImageViewModel(
    private val image: Image
) {
    fun size() = "Size:\nHeight: ${image.height}\nWidth: ${image.width}"
}