package com.example.kotlintest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlintest.model.Pais
import com.example.kotlintest.model.PaisesService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import java.lang.Exception

class PaisesViewModel: ViewModel() {

    private val paisesService = PaisesService()
    private val disposable = CompositeDisposable()

    val paises = MutableLiveData<List<Pais>>()
    val isLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
        isLoading.value = true

        GlobalScope.launch(Dispatchers.IO) {

            try {
                val response = paisesService.getPaises().awaitResponse()
                if (response.isSuccessful){
                    isLoading.postValue(false)
                    paises.postValue(response.body())
                }
            } catch (e: Exception) {
                error.postValue(true)
            }

        }
        /*disposable.add(
            paisesService.getPaises()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Pais>>() {
                    override fun onSuccess(value: List<Pais>?) {
                        isLoading.value = false
                        paises.value = value
                    }

                    override fun onError(e: Throwable?) {
                        isLoading.value = false
                        error.value = true
                    }
                })
        )*/
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}