package com.thoughtbot.tropos.main

import android.content.Context
import android.location.Geocoder
import com.thoughtbot.tropos.R
import com.thoughtbot.tropos.data.WeatherData
import com.thoughtbot.tropos.extensions.iconResId
import com.thoughtbot.tropos.extensions.labelResId
import java.text.SimpleDateFormat
import java.util.Locale

class CurrentWeatherViewModel(val context: Context, val weatherData: WeatherData) {

  val weatherSummary: String = weatherData.summary

  val icon: Int = weatherData.condition.iconResId()

  val temperatures: String = context.getString(R.string.formatted_temperature_string,
      weatherData.currentTemp, weatherData.highTemp, weatherData.lowTemp)

  val temperatureIcon = R.drawable.label_thermometer

  val wind: String = {
    val windDirection = context.getString(weatherData.windDirection.labelResId())
    context.getString(R.string.formatted_wind_string, weatherData.windSpeed, windDirection)
  }()

  val windIcon = R.drawable.label_wind

}
