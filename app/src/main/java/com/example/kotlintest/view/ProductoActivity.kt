package com.example.kotlintest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityProductoBinding

class ProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_producto)
        val v = ActivityProductoBinding.inflate(layoutInflater)


        with(v) {
            miTexto

        }

    }
}