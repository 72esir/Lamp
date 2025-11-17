package com.example.lampochka.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lampochka.domain.TurnOffUseCase
import com.example.lampochka.domain.TurnOnUseCase
import com.example.lampochka.di.NetworkModule
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val turnOn: TurnOnUseCase,
    private val turnOff: TurnOffUseCase,
) : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun turnOn() {
        viewModelScope.launch {
            try {
                val result = NetworkModule.provideBulbService().postTurnOn() // ← предполагаем, что use case возвращает String или данные
                _response.value = result.toString()
            } catch (e: Exception) {
                _error.value = "Ошибка: ${e.message}"
            }
        }
    }

    fun turnOff() {
        viewModelScope.launch {
            try {
                val result = NetworkModule.provideBulbService().postTurnOff()
                _response.value = result.toString()
            } catch (e: Exception) {
                _error.value = "Ошибка: ${e.message}"
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