package com.wavecollapse.business

import java.util.*

class ImageCell {
    val availableTilesIds = mutableSetOf<UUID>()
    var tile : Tile? = null
}