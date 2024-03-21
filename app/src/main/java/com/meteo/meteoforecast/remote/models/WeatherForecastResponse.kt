package com.meteo.meteoforecast.remote.models

import com.fasterxml.jackson.annotation.JsonProperty

class WeatherForecastResponse {
    @JsonProperty("timelines")
    val timelines : WeatherForecastTimeline = WeatherForecastTimeline()
}

class WeatherForecastTimeline {
    @JsonProperty("daily")
    val daily : List<WeatherForecastDaily> = emptyList()
}

class WeatherForecastDaily {
    @JsonProperty("time")
    val time : String = ""
    @JsonProperty("values")
    val values : WeatherForecastValuesResponse = WeatherForecastValuesResponse()
}

class WeatherForecastValuesResponse {
    @JsonProperty("humidityAvg")
    val humidityAvg : String = ""
    @JsonProperty("humidityMax")
    val humidityMax : String = ""
    @JsonProperty("humidityMin")
    val humidityMin : String = ""
    @JsonProperty("humidityAvg")
    val temperatureAvg : String = ""
    @JsonProperty("humidityMax")
    val temperatureMax : String = ""
    @JsonProperty("humidityMin")
    val temperatureMin : String = ""
}
