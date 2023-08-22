package com.quanle.movie_sample_compose.utils


enum class SourceImage(val type: String) {
    ORIGINAL(URL.IMAGE_URL_ORIGINAL),
    LARGE(URL.IMAGE_URL_LARGE)
}

fun String.toImageUri(byType: SourceImage): String = when(byType) {
    SourceImage.ORIGINAL -> "${SourceImage.ORIGINAL.type}$this"
    SourceImage.LARGE -> "${SourceImage.LARGE.type}$this"
}

