package com.meteo.meteoforecast.remote

import com.meteo.meteoforecast.shared.WeatherForecast

interface IWeatherForecastProvider {
    suspend fun getWeatherForecast() : List<WeatherForecast>
}
