package vn.edu.usth.weather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val DESCRIPTION = mapOf(
    "01d" to "Clear sky", "02d" to "Few clouds",
    "03d" to "Scattered clouds", "04d" to "Broken clouds",
    "09d" to "Shower rain", "10d" to "Rain", "11d" to "Thunderstorm",
    "13d" to "Snow", "50d" to "Mist")
val ICON = mapOf(
    "01d" to R.drawable.api01d, "02d" to R.drawable.api02d,
    "03d" to R.drawable.api03d, "04d" to R.drawable.api04d,
    "09d" to R.drawable.api09d, "10d" to R.drawable.api10d,
    "11d" to R.drawable.api11d, "13d" to R.drawable.api13d,
    "50d" to R.drawable.api50d)

data class Weather(val icon: String)
data class Main(val temp_min: Int, val temp_max: Int)
data class Response(val weather: Array<Weather>, val main: Main)

interface OpenWeatherMap {
    @GET("/data/2.5/weather?appid=633f282ec292b27cee1371842180da61&mode=json&units=metric")
    suspend fun weather(@Query("q") city: String): Response
}

val openWeatherMap = Retrofit.Builder()
    .baseUrl("https://api.openweathermap.org")
    .addConverterFactory(GsonConverterFactory.create()).build()
    .create(OpenWeatherMap::class.java)
