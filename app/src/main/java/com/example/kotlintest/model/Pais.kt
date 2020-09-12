package com.example.kotlintest.model

import com.google.gson.annotations.SerializedName

data class Pais(
    @SerializedName("name")
    val nombre: String?
)