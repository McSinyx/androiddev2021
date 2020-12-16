package vn.edu.usth.weather;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.weather.WeatherAndForecastFragment;

class WeatherPagerAdapter extends FragmentStateAdapter {
    public WeatherPagerAdapter(FragmentActivity fa) { super(fa); }

    @Override
    public Fragment createFragment(int position) {
        return new WeatherAndForecastFragment();
    }

    @Override
    public int getItemCount() { return 3; }
}
