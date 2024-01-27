package com.rivera.recyclerview1.data.network.repositorio

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBase {

    //private const val JIKAN_URL = "https://api.jikan.moe/v4/"
    fun getRetrofitJikanConnection():Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}