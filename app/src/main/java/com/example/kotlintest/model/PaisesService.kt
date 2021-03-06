package com.example.kotlintest.model

import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PaisesService {

    private val BASE_URL = "https://raw.githubusercontent.com"
    private val api: PaisesApi

    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PaisesApi::class.java)
    }

    fun getPaises(): Call<List<Pais>> {
        return api.getPaises()
    }
}