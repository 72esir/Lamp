package com.example.lampochka.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lampochka.data.domain.TurnOffUseCase
import com.example.lampochka.data.domain.TurnOnUseCase
import com.example.lampochka.di.NetworkModule


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val turnOn: TurnOnUseCase,
    private val turnOff: TurnOffUseCase,
) : ViewModel() {

    fun turnOn() {
        viewModelScope.launch {
            try {
                val response = NetworkModule.provideBulbService().postTurnOn()
            } catch (e: Exception) {
            }
        }
    }

    fun turnOff() {
        viewModelScope.launch {
            try {
                val response = NetworkModule.provideBulbService().postTurnOff()
            } catch (e: Exception) {
            }
        }
    }


//    private val _dogImageUrl = MutableLiveData<String>()
//    val dogImageUrl: LiveData<String>
//        get() = _dogImageUrl

//    fun loadNewDog() {
//        viewModelScope.launch{
//            val dogInfo = getDogsUseCase()
//
//            _dogImageUrl.postValue(
//                dogInfo?.url
//            )
//        }
//    }
}