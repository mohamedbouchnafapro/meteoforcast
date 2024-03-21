package com.meteo.meteoforecast.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.meteo.meteoforecast.databinding.ForecastItemBinding

class WeatherForecastViewHolder(binding : ForecastItemBinding) : ViewHolder(binding.root) {
    val day = binding.dayText
    val temperatureMin = binding.temperatureMin
    val temperatureMax = binding.temperatureMax
    val temperatureAvg = binding.temperatureAvg
    val humidityMin = binding.humidityMin
    val humidityMax = binding.humidityMax
    val humidityAvg = binding.humidityAvg
}