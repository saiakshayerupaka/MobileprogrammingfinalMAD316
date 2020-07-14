package com.example.weather_app.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather_app.Api;
import com.example.weather_app.Location;
import com.example.weatherapp.Api;
import com.example.weatherapp.CustomAdapter;
import com.example.weatherapp.DayWeather;
import com.example.weatherapp.Location;
import com.example.weatherapp.R;
import com.example.weatherapp.Weather;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private View root;

  private ImageView weather_image;
  private TextView city,wind_speed,min_temp,max_temp,humidity,prediction,weather;
  private RecyclerView listView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        Api api = retrofit.create(Api.class);
        Call<Location> call;
        call = api.getMontrel();

        if(getArguments()!=null) {

            if (getArguments().getString("city").equals("montreal")) {
                call = api.getMontrel();
            } else if (getArguments().getString("city").equals("newyork")) {
                call = api.getNewYork();
            } else if (getArguments().getString("city").equals("toronto")) {
                call = api.getToronto();

            }

        }

        
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
       weather_image = root.findViewById(R.id.weather_icon);
       city = root.findViewById(R.id.city);

       weather = root.findViewById(R.id.weather);
       wind_speed = root.findViewById(R.id.wind_speed);
       min_temp = root.findViewById(R.id.min_temp);
       max_temp = root.findViewById(R.id.max_temp);
       prediction = root.findViewById(R.id.prediction);
       humidity = root.findViewById(R.id.humidity);
        listView = root.findViewById(R.id.main_recyclerView);



        return root;
    }


}