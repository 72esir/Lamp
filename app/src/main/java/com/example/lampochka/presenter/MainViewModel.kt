package com.example.lampochka.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lampochka.domain.TurnOffUseCase
import com.example.lampochka.domain.TurnOnUseCase
import com.example.lampochka.di.NetworkModule
import com.example.lampochka.domain.GetBrightnessUseCase
import com.example.lampochka.domain.GetColorNamesUseCase
import com.example.lampochka.domain.GetColorsUseCase
import com.example.lampochka.domain.GetCurrentBrightnessUseCase
import com.example.lampochka.domain.GetCurrentColorUseCase
import com.example.lampochka.domain.PostBrightnessUseCase
import com.example.lampochka.domain.PostColorUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val turnOnUC: TurnOnUseCase,
    private val turnOffUC: TurnOffUseCase,
    private val getBrightnessUC: GetBrightnessUseCase,
    private val getCurrentBrightnessUC: GetCurrentBrightnessUseCase,
    private val getColorsUC: GetColorsUseCase,
    private val getColorNamesUC: GetColorNamesUseCase,
    private val getCurrentColorUC: GetCurrentColorUseCase,
    private val postBrightnessUC: PostBrightnessUseCase,
    private val postColorUC: PostColorUseCase,
) : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun turnOn() {
        viewModelScope.launch {
            try {
                val result = turnOnUC()
                _response.value = if (result) "Лампа включена" else "Ошибка при включении"
            } catch (e: Exception) {
                _error.value = "Ошибка: ${e.message}"
            }
        }
    }

    fun turnOff() {
        viewModelScope.launch {
            try {
                val result = turnOffUC()
                _response.value = if (result) "Лампа выключена" else "Ошибка при выключении"
            } catch (e: Exception) {
                _error.value = "Ошибка: ${e.message}"
            }
        }
    }

    fun getBrightness(){
        viewModelScope.launch {
            try {
                val result = getBrightnessUC()
                _response.value = "Яркость: max - ${result.max}, min - ${result.min}, precision - ${result.precision}"
            }catch (e: Exception){
                _error.value = "Ошибка яркости: ${e.message}"
            }
        }
    }

    fun getCurrentBrightness(){
        viewModelScope.launch {
            try {
                val result = getCurrentBrightnessUC()
                _response.value = "Текущая яркость: $result"
            }catch (e: Exception){
                _error.value = "Ошибка яркости: ${e.message}"
            }
        }
    }

    fun getColors(){
        viewModelScope.launch {
            try {
                val result = getColorsUC()
                var message = "Цвета: \n"
                for (res in result){
                    message += "id: ${res.id}, name: ${res.name}, type: ${res.type}, color: ${res.color}\n"
                }
                _response.value = message
            }catch (e: Exception){
                _error.value = "Ошибка при получении цветов: ${e.message}"
            }
        }
    }

    fun getCurrentColor(){
        viewModelScope.launch {
            try {
                val result = getCurrentColorUC()
                _response.value = "Текущий цвет: id - ${result.id}, name - ${result.name}, type - ${result.type}, color - ${result.color}"
            }catch (e: Exception){
                _error.value = "Ошибка при получении текущего цвета: ${e.message}"
            }
        }
    }

    fun getColorNames(){
        viewModelScope.launch {
            try {
                val result = getColorNamesUC()
                var message = "Названия цветов: \n"
                for (res in result){
                    message += "$res, "
                }
                _response.value = message
            }catch (e: Exception){
                _error.value = "Ошибка при получении названий цветов: ${e.message}"
            }
        }
    }

    fun setBrightness(brightness: Int) {
        viewModelScope.launch {
            try {
                val success = postBrightnessUC(brightness)
                _response.value = if (success) {
                    "Яркость установлена: $brightness"
                } else {
                    "Не удалось установить яркость"
                }
            } catch (e: Exception) {
                _error.value = "Ошибка установки яркости: ${e.message}"
            }
        }
    }

    fun setColor(colorName: String) {
        viewModelScope.launch {
            try {
                val success = postColorUC(colorName)
                _response.value = if (success) {
                    "Цвет установлен: $colorName"
                } else {
                    "Не удалось установить цвет"
                }
            } catch (e: Exception) {
                _error.value = "Ошибка установки цвета: ${e.message}"
            }
        }
    }
}