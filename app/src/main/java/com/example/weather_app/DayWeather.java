package com.example.weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.R;

public class DayWeather extends AppCompatActivity {

    private ImageView weather_image;
    private TextView city,wind_speed,min_temp,max_temp,humidity,prediction,weather;
    private Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_weather);

        weather_image = findViewById(R.id.weather_icon);
        city = findViewById(R.id.city);
        wind_speed = findViewById(R.id.wind_speed);
        min_temp = findViewById(R.id.min_temp);
        max_temp = findViewById(R.id.max_temp);
        humidity = findViewById(R.id.humidity);
        prediction = findViewById(R.id.prediction);
        weather = findViewById(R.id.weather);


        close = findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
