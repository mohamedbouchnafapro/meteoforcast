package com.meteo.meteoforecast.remote.di

import com.meteo.meteoforecast.remote.IWeatherForecastProvider
import com.meteo.meteoforecast.remote.WeatherForecastProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object WeatherForecastRemoteModule {

    @Provides
    @Singleton
    fun retrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(
                "https://api.tomorrow.io"
            )
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun weatherForecastProvider(weatherForecastProvider : WeatherForecastProvider) : IWeatherForecastProvider{
        return weatherForecastProvider
    }
}
