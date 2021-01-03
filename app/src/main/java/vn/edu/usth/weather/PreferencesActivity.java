package vn.edu.usth.weather;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.fragment.app.FragmentActivity;

import com.google.android.material.snackbar.Snackbar;

public class PreferencesActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(
            new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_refresh:
                            Snackbar.make(
                                findViewById(R.id.pref), "Refreshing",
                                Snackbar.LENGTH_SHORT).show();
                            return true;
                        default:
                            return false;
                    }
                }
            });
    }
}
