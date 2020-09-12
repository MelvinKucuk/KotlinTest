package com.example.kotlintest.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintest.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {


    companion object {

        const val KEY_TEXTO = "texto"

        fun navigate(activity: Activity, texto1: String) {
            val datos = Bundle()
            val intent = Intent(activity, MainActivity2::class.java)
            intent.putExtras(datos)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ActivityMain2Binding.inflate(layoutInflater)
        val estoString: String
        with(v) {
            setContentView(root)
            val textoExtra = intent.extras?.getString(KEY_TEXTO, "asd")
            texto.text = textoExtra
        }
    }
}