package com.meteo.meteoforecast.shared

data class WeatherForecastValues(
    val humidityAvg : String = "",
    val humidityMax : String = "",
    val humidityMin : String = "",
    val temperatureAvg : String = "",
    val temperatureMax : String = "",
    val temperatureMin : String = ""
)
