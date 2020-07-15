package com.example.weather_app.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather_app.Api;
import com.example.weather_app.CustomAdapter;
import com.example.weather_app.DayWeather;
import com.example.weather_app.Location;
import com.example.weather_app.R;
import com.example.weather_app.Weather;

import java.io.Serializable;
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
  private CustomAdapter customAdapter;
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
                else if (getArguments().getString("city").equals("Vancouver")) {
                    call = api.getVancouver();

                }
                else if (getArguments().getString("city").equals("Mumbai")) {
                    call = api.getMumbai();

                }
            }

            call.enqueue(new Callback<Location>() {
                @Override
                public void onResponse(Call<Location> call, Response<Location> response) {


                    final Location location = response.body();

                    final List<Weather> weathers = location.getConsolidated_weather();


                    Glide.with(getActivity())
                            .load("https://www.metaweather.com/static/img/weather/png/" + location.getConsolidated_weather().get(0).getWeather_state_abbr() + ".png")
                            .into(weather_image);

                    city.setText(location.getTitle());
                    weather.setText(location.getConsolidated_weather().get(0).getWeather_state_name());
                    min_temp.setText(String.format("%.2f", location.getConsolidated_weather().get(0).getMin_temp()));

                    max_temp.setText(String.format("%.2f", location.getConsolidated_weather().get(0).getThe_temp()));
                    wind_speed.setText(String.format("%.2f", location.getConsolidated_weather().get(0).getMax_temp()));

                    prediction.setText(String.valueOf(location.getConsolidated_weather().get(0).getPredictability()) + "%");
                    humidity.setText(String.valueOf(location.getConsolidated_weather().get(0).getHumidity()));


                    SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-mm-DD");
                    Date date = null;
                    try {
                        date = inFormat.parse(location.getConsolidated_weather().get(0).getApplicable_date());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
                    String goal = outFormat.format(date);


                    customAdapter = new CustomAdapter(weathers, getActivity().getApplicationContext());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
                    listView.setLayoutManager(layoutManager);
                    listView.setAdapter(customAdapter);
                    customAdapter.setOnClickListner(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
                            int position = viewHolder.getAdapterPosition();
                            Toast.makeText(getActivity().getApplicationContext(), ""+position, Toast.LENGTH_SHORT).show();

                            Intent in = new Intent(getActivity(), DayWeather.class);
                            in.putExtra("weather", (Serializable) weathers.get(position));
                            startActivity(in);

                        }});

                    Log.d("ee", "" + location.getConsolidated_weather().get(0).getHumidity());
                    Toast.makeText(getActivity(), "" + location.getConsolidated_weather().get(0).getHumidity(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<Location> call, Throwable t) {
                    Toast.makeText(getActivity().getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("ee", t.getMessage());

                }
            });
        
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