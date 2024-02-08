package com.wavecollapse.presentation.view

import com.wavecollapse.presentation.model.ImageViewModel

fun renderImageView(image: ImageViewModel)
{
    println(image.title())
    println(image.size())
    println()
    println("Tiles:")
    image.tiles().forEach{
        println(it)
    }
    println("Result:")
    image.result().forEach{
        println(it)
    }
}