package com.rivera.recyclerview1.data.network.endpoints

import com.rivera.recyclerview1.data.network.entities.jikan.top.TopAnime
import retrofit2.Response

import retrofit2.http.GET

interface TopAnimesEndpoint {
     @GET("top/anime")
     suspend fun getAllTopAnimes() : Response<TopAnime>

}