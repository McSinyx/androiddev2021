package vn.edu.usth.weather

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator

import vn.edu.usth.weather.PreferencesActivity
import vn.edu.usth.weather.WeatherPagerAdapter

val city = arrayOf(R.string.hanoi, R.string.paris, R.string.toulouse)

class WeatherActivity() : FragmentActivity(R.layout.activity_weather) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener(
            object : Toolbar.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem): Boolean {
                    return when (item.getItemId()) {
                        R.id.action_refresh -> {
                            Snackbar.make(
                                findViewById(R.id.pager), "Refreshing",
                                Snackbar.LENGTH_SHORT).show()
                            true
                        }
                        R.id.action_pref -> {
                            this@WeatherActivity.startActivity(Intent(
                                this@WeatherActivity,
                                PreferencesActivity::class.java))
                            true
                        }
                        else -> false
                    }
                }
            })

        val viewPager: ViewPager2 = findViewById(R.id.pager)
        viewPager.setAdapter(WeatherPagerAdapter(this))
        TabLayoutMediator(
            findViewById(R.id.tab_layout), viewPager,
            { tab, position -> tab.setText(getString(city[position]))}).attach()
    }

    override fun onBackPressed() {
        val viewPager: ViewPager2 = findViewById(R.id.pager)
        if (viewPager.getCurrentItem() == 0)
            super.onBackPressed()
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1)
    }
}
