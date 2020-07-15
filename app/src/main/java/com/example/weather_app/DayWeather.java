package com.example.weather_app;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.weatherapp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DayWeather extends AppCompatActivity {

    private ImageView weather_image;
    private TextView city,wind_speed,min_temp,max_temp,humidity,prediction,weather;
    private Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_weather);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Weather we = (Weather) getIntent().getSerializableExtra("weather");

        Toast.makeText(DayWeather.this, "" + we.getWeather_state_name(), Toast.LENGTH_LONG).show();

        weather_image = findViewById(R.id.weather_icon);
        city = findViewById(R.id.city);
        wind_speed = findViewById(R.id.wind_speed);
        min_temp = findViewById(R.id.min_temp);
        max_temp = findViewById(R.id.max_temp);
        humidity = findViewById(R.id.humidity);
        prediction = findViewById(R.id.prediction);
        weather = findViewById(R.id.weather);

        Glide.with(this)
                .load("https://www.metaweather.com/static/img/weather/png/" + we.getWeather_state_abbr() + ".png")
                .into(weather_image);

        weather.setText(we.getWeather_state_name());
        min_temp.setText(String.format("%.2f", we.getMin_temp()));

        max_temp.setText(String.format("%.2f", we.getThe_temp()));
        wind_speed.setText(String.format("%.2f", we.getMax_temp()));

        prediction.setText(String.valueOf(we.getPredictability()) + "%");
        humidity.setText(String.valueOf(we.getHumidity()));


        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-mm-DD");
        Date date = null;
        try {
            date = inFormat.parse(we.getApplicable_date());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
        String goal = outFormat.format(date);

        city.setText(goal);

        close = findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }

}
