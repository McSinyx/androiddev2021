package vn.edu.usth.weather;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayoutMediator;

import vn.edu.usth.weather.WeatherPagerAdapter;

public class WeatherActivity extends FragmentActivity {
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    public static final int[] city = {
        R.string.hanoi, R.string.paris, R.string.toulouse};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new WeatherPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(
            findViewById(R.id.tab_layout),
            viewPager,
            (tab, position) -> tab.setText(getString(city[position]))).attach();
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }
}
