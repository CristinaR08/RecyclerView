package com.rivera.recyclerview1.logic.usercase.jikan

import android.util.Log
import com.rivera.recyclerview1.core.Constants
import com.rivera.recyclerview1.core.getFullInfoAnimeLG
import com.rivera.recyclerview1.data.network.endpoints.TopAnimesEndpoint
import com.rivera.recyclerview1.data.network.repositorio.RetrofitBase
import com.rivera.recyclerview1.logic.entities.FullInfoAnimeLG

class JikanTopAnimesUserCase {

    suspend fun invoke() : Result<List<FullInfoAnimeLG>> {
        var result : Result<List<FullInfoAnimeLG>>? = null
        var items = ArrayList<FullInfoAnimeLG>()

        try{
            val baseService = RetrofitBase.getRetrofitJikanConnection()
            val service = baseService.create(TopAnimesEndpoint::class.java)
            val call = service.getAllTopAnimes()

            if(call.isSuccessful){
                val infoAnime = call.body()!!
                infoAnime.data.forEach{
                    items.add(it.getFullInfoAnimeLG())
                }
                result = Result.success(items)

            }else{
                Log.e(Constants.TAG,"Error en el llamado API de Jikan")
                result = Result.failure(Exception("Error en el llamado API de Jikan"))
            }
        }catch (ex: Exception){
            Log.e(Constants.TAG, ex.stackTraceToString())
            result = Result.failure(Exception(ex))

        }

        return result!!
    }
}