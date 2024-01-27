package com.rivera.recyclerview1.data.network.endpoints

import com.rivera.recyclerview1.data.network.entities.jikan.anime.FullInfoAnime
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeEndpoint {
    @GET("anime/{id}/full")
    suspend fun getAnimeFullInfo(@Path("id") name: Int) : Response<FullInfoAnime>


}