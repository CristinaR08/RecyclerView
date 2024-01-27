package com.rivera.recyclerview1.data.network.entities.jikan.top


data class TopAnime(
    val `data`: List<Data> = listOf(),
    val pagination: Pagination?= null
)