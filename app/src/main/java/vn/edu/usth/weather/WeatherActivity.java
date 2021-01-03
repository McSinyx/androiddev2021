package vn.edu.usth.weather;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayoutMediator;

import vn.edu.usth.weather.PreferencesActivity;
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(
            new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_refresh:
                            Snackbar.make(
                                findViewById(R.id.pager), "Refreshing",
                                Snackbar.LENGTH_SHORT).show();
                            return true;
                        case R.id.action_pref:
                            Context context = getApplicationContext();
                            Intent intent = new Intent(
                                context, PreferencesActivity.class);
                            context.startActivity(intent);
                            return true;
                        default:
                            return false;
                    }
                }
            });

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
    protected void onStart() {
        super.onStart();
        MediaPlayer.create(this, R.raw.techno).start();
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }
}
