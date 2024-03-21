package com.meteo.meteoforecast.business

import com.meteo.meteoforecast.remote.IWeatherForecastProvider
import com.meteo.meteoforecast.remote.WeatherForecastProvider
import com.meteo.meteoforecast.shared.WeatherForecast
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherForecastService @Inject constructor(
    private val weatherForecastProvider: IWeatherForecastProvider
) : IWeatherForecastService {
    override suspend fun getWeatherForecast(): List<WeatherForecast> {
        return withContext(Dispatchers.IO){
            weatherForecastProvider.getWeatherForecast()
        }
    }
}