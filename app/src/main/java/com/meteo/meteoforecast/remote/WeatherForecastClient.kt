package com.meteo.meteoforecast.remote

import com.meteo.meteoforecast.remote.models.WeatherForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherForecastClient {

    @GET("v4/weather/forecast")
    suspend fun getWeatherForecast(
        @Query("apiKey") apikey : String = "1A8iuFAHzq0uNDOsXYYGZH8CVWRqkLaE",
        @Query("location") location: String,
        @Query("timesteps") timesteps : String
    ) : WeatherForecastResponse
}
