package com.meteo.meteoforecast.business.di

import com.meteo.meteoforecast.business.IWeatherForecastService
import com.meteo.meteoforecast.business.WeatherForecastService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BusinessModule {
    @Provides
    @Singleton
    fun provideForecastService(weatherForecastService : WeatherForecastService) : IWeatherForecastService{
        return weatherForecastService
    }
}