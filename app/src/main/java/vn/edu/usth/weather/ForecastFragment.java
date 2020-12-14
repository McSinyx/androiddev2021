package vn.edu.usth.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class ForecastFragment extends Fragment {
    public ForecastFragment() { super(R.layout.fragment_forecast); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout linear = (LinearLayout) super.onCreateView(
            inflater, container, savedInstanceState);
        linear.setOrientation(LinearLayout.VERTICAL);

        TextView text = new TextView(getContext());
        text.setText("Thursday");
        linear.addView(text);

        ImageView image = new ImageView(getContext());
        image.setImageResource(R.drawable.showers);
        linear.addView(image);

        return linear;
    }
}
