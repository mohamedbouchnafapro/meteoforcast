package com.meteo.meteoforecast.remote

import com.meteo.meteoforecast.shared.WeatherForecast
import com.meteo.meteoforecast.shared.WeatherForecastValues
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import retrofit2.Retrofit


class WeatherForecastProvider @Inject constructor(retrofit: Retrofit) : IWeatherForecastProvider {

    private val client = retrofit.create(WeatherForecastClient::class.java)

    var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX")


    override suspend fun getWeatherForecast(): List<WeatherForecast> {
        val response = client.getWeatherForecast(
            location = "42.3478,-71.0466" ,
            timesteps = "1d"
        )

        return response.timelines.daily.map { weatherForecastDaily ->
            WeatherForecast(
                date = LocalDate.parse(weatherForecastDaily.time,formatter),
                forecastValue = WeatherForecastValues(
                    humidityAvg = weatherForecastDaily.values.humidityAvg,
                    humidityMax = weatherForecastDaily.values.humidityMax,
                    humidityMin = weatherForecastDaily.values.humidityMin,
                    temperatureAvg = weatherForecastDaily.values.temperatureAvg,
                    temperatureMin = weatherForecastDaily.values.temperatureMin,
                    temperatureMax = weatherForecastDaily.values.temperatureMax
                )
            )
        }
    }
}
