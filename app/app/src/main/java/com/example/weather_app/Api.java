package com.example.weather_app;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://www.metaweather.com/api/location/";

    @GET("3534")
    Call<Location> getMontrel();

    @GET("2459115")
    Call<Location> getNewYork();

    @GET("4118")
    Call<Location> getToronto();

    @GET("9807")
    Call<Location> getVancouver();

    @GET("12586539")
    Call<Location>  getMumbai();
}
