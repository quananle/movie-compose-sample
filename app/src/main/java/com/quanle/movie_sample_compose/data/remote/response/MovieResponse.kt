package com.quanle.movie_sample_compose.data.remote.response

import java.io.Serializable

data class Movie(
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
): Serializable {

    override fun toString(): String {
        return """
            Movie Title: $title
            Release Date: $release_date
            Overview: $overview
            Vote Average: $vote_average
        """.trimIndent()
    }
}