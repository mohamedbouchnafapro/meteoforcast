package com.meteo.meteoforecast.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meteo.meteoforecast.business.IWeatherForecastService
import com.meteo.meteoforecast.shared.WeatherForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherForecastService : IWeatherForecastService) : ViewModel() {

    private val _forecastStateFlow = MutableStateFlow(ArrayList<WeatherForecast>())
    val forecastStateFlow = _forecastStateFlow.asStateFlow()

    private val _forecastErrorStateFlow = MutableStateFlow(false)
    val forecastErrorStateFlow = _forecastErrorStateFlow.asStateFlow()




    fun callWeatherForecastService(){
        viewModelScope.launch {
            try {
                val response = weatherForecastService.getWeatherForecast()
                _forecastStateFlow.value = ArrayList(response)
                _forecastErrorStateFlow.value = false
            }catch (throwable : Throwable){
                _forecastStateFlow.value = arrayListOf()
                _forecastErrorStateFlow.value = true
            }

        }
    }
}