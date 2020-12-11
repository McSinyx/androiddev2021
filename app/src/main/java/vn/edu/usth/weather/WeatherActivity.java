package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.weather.ForecastFragment;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("USTH Weather", "on create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(
            R.id.container, new ForecastFragment()).commit();
    }

    @Override
    protected void onStart() {
        Log.i("USTH Weather", "on start");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i("USTH Weather", "on restart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("USTH Weather", "on resume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("USTH Weather", "on pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("USTH Weather", "on stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("USTH Weather", "on destroy");
        super.onDestroy();
    }
}
