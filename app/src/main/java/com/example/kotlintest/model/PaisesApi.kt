package com.example.kotlintest.model

import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PaisesApi {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getPaises(): Call<List<Pais>>
}