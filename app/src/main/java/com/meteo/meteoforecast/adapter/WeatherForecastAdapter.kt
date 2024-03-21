package com.meteo.meteoforecast.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meteo.meteoforecast.databinding.ForecastItemBinding
import com.meteo.meteoforecast.shared.WeatherForecast
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class WeatherForecastAdapter @Inject constructor(
    @ActivityContext private val context: Context
    ) : RecyclerView.Adapter<WeatherForecastViewHolder>() {
    var items : ArrayList<WeatherForecast> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForecastViewHolder {
        return WeatherForecastViewHolder(
            ForecastItemBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: WeatherForecastViewHolder, position: Int) {
        holder.day.text = "Day N°" + (position + 1).toString()
        holder.temperatureMin.text = "temperature Min : " + items[position].forecastValue.temperatureMin
        holder.temperatureMax.text = "temperatureMax : " +items[position].forecastValue.temperatureMax
        holder.temperatureAvg.text = "temperatureAvg : " +items[position].forecastValue.temperatureAvg
        holder.humidityMin.text = "humidityMin : " +items[position].forecastValue.humidityMin
        holder.humidityMax.text = "humidityMax : " +items[position].forecastValue.humidityMax
        holder.humidityAvg.text = "humidityAvg : " +items[position].forecastValue.humidityAvg

    }

    fun updateItems(items : ArrayList<WeatherForecast>){
        this.items = items
        Log.i("items","${items.size}")
        notifyDataSetChanged()
    }
}