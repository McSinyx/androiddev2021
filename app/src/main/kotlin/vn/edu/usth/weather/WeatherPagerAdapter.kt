package vn.edu.usth.weather

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

import vn.edu.usth.weather.WeatherAndForecastFragment

class WeatherPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment =
        WeatherAndForecastFragment()
}
