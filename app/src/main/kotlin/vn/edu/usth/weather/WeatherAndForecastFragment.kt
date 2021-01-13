package vn.edu.usth.weather

import kotlinx.coroutines.launch

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope

import vn.edu.usth.weather.ICON
import vn.edu.usth.weather.DESCRIPTION
import vn.edu.usth.weather.openWeatherMap

import androidx.fragment.app.Fragment

class WeatherAndForecastFragment :
    Fragment(R.layout.fragment_weather_and_forecast) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewLifecycleOwner.lifecycleScope.launch {
            val response = openWeatherMap.weather("Hanoi")
            val icon = response.weather[0].icon
            val drawable = ResourcesCompat.getDrawable(resources, ICON[icon]!!, null)
            view.findViewById<ImageView>(R.id.weather_icon).setImageDrawable(drawable)
            val main = response.main
            view.findViewById<TextView>(R.id.weather_brief).text =
                "${DESCRIPTION[icon]}\n${main.temp_min}C-${main.temp_max}C"
        }
    }
}
