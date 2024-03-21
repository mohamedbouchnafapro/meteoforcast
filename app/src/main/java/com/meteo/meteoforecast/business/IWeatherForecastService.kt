package com.meteo.meteoforecast.business

import com.meteo.meteoforecast.shared.WeatherForecast

interface IWeatherForecastService {
    suspend fun getWeatherForecast() : List<WeatherForecast>
}