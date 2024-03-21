package com.meteo.meteoforecast.shared

import java.time.LocalDate

data class WeatherForecast(
    val date : LocalDate ,
    val forecastValue : WeatherForecastValues
)
