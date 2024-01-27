package com.rivera.recyclerview1.logic.usercase.jikan

import android.util.Log
import com.rivera.recyclerview1.data.network.endpoints.AnimeEndpoint
import com.rivera.recyclerview1.data.network.repositorio.RetrofitBase
import com.rivera.recyclerview1.logic.entities.FullInfoAnimeLG
import com.rivera.recyclerview1.core.Constants
import com.rivera.recyclerview1.core.getFullInfoAnimeLG


class JikanAnimeUsercase {

    suspend fun getFullAnimeInfo(nameAnime: Int) : Result<FullInfoAnimeLG> {
        var infoAnime = FullInfoAnimeLG()
        var result: Result<FullInfoAnimeLG>?= null

        try {
            val baseService = RetrofitBase.getRetrofitJikanConnection()
            val service = baseService.create(AnimeEndpoint::class.java)
            val call = service.getAnimeFullInfo(nameAnime)


            if(call.isSuccessful){
                val a = call.body()!!
                infoAnime = a.getFullInfoAnimeLG()
                result = Result.success(infoAnime) // POSIBLE ERROR
            }else{
                Log.d(Constants.TAG, "Error en el llamado del API Jikan")
                result = Result.failure(Exception("Error en el llamado del API Jikan"))
            }
        }catch (ex:Exception){
            Log.e(Constants.TAG, ex.stackTraceToString())
        }

        return result!!
    }


}