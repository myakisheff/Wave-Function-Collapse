package com.wavecollapse.presentation.model

import com.wavecollapse.business.Image

class ImageViewModel(
    private val image: Image
) {
    fun size() = "Size:\nHeight: ${image.height}\nWidth: ${image.width}"
    fun tiles() = buildList {
        image.tiles.forEach { add(it.tile) }
    }

    fun title() = image.tag
    fun result() = buildList {
        image.getImage().forEach { cell ->
            var line = ""
            cell.forEach {
                line += it.tile ?: return listOf("Some tiles empty. Check connections")
            }
            add(line)
        }
    }
}