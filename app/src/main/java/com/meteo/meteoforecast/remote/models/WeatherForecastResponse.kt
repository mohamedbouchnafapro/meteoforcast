package com.meteo.meteoforecast.remote.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherForecastResponse {
    @JsonProperty("timelines")
    val timelines : WeatherForecastTimeline = WeatherForecastTimeline()
}

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherForecastTimeline {
    @JsonProperty("daily")
    val daily : List<WeatherForecastDaily> = emptyList()
}

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherForecastDaily {
    @JsonProperty("time")
    val time : String = ""
    @JsonProperty("values")
    val values : WeatherForecastValuesResponse = WeatherForecastValuesResponse()
}

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherForecastValuesResponse {
    @JsonProperty("humidityAvg")
    val humidityAvg : String = ""
    @JsonProperty("humidityMax")
    val humidityMax : String = ""
    @JsonProperty("humidityMin")
    val humidityMin : String = ""
    @JsonProperty("temperatureAvg")
    val temperatureAvg : String = ""
    @JsonProperty("temperatureMax")
    val temperatureMax : String = ""
    @JsonProperty("temperatureMin")
    val temperatureMin : String = ""
}
