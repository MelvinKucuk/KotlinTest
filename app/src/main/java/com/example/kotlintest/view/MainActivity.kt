package com.example.kotlintest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintest.databinding.ActivityMainBinding
import com.example.kotlintest.utils.hide
import com.example.kotlintest.utils.show
import com.example.kotlintest.viewmodel.PaisesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: PaisesViewModel
    private val paisesAdapter = Adapter(arrayListOf()) {
        MainActivity2.navigate(this, it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProviders.of(this).get(PaisesViewModel::class.java)
        viewModel.refresh()

        with(v) {
            setContentView(root)

            recycler.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = paisesAdapter
            }

        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.paises.observe(this, Observer {
            listaPaises -> listaPaises?.let {
            recycler.show()
            paisesAdapter.actualizarPaises(it)
        }
        })


        viewModel.isLoading.observe(this, Observer {
            isLoading -> isLoading?.let {
            if (it) {
                recycler.hide()
                loadingView.show()
            } else {
                recycler.show()
                loadingView.hide()
            }
        }
        })

        viewModel.error.observe(this, Observer {
            error -> error.let {
            if (it)
                loadingView.hide()
        }
        })
    }

}