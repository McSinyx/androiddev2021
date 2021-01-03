package vn.edu.usth.weather

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar

import androidx.fragment.app.FragmentActivity

import com.google.android.material.snackbar.Snackbar

class PreferencesActivity : FragmentActivity(R.layout.activity_preferences) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener(
            object : Toolbar.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem): Boolean {
                    if (item.getItemId() == R.id.action_refresh) {
                        Snackbar.make(
                            findViewById(R.id.pref), "Refreshing",
                            Snackbar.LENGTH_SHORT).show()
                        return true
                    }
                    return false
                }
            }
        )
    }
}
