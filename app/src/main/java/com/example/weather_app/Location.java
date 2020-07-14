package com.example.weather_app;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Location {

    public Location(List<Weather> consolidated_weather, String title) {
        this.consolidated_weather = consolidated_weather;
        this.title = title;

    }

    public List<Weather> getConsolidated_weather() {
        return consolidated_weather;
    }

    public void setConsolidated_weather(List<Weather> consolidated_weather) {
        this.consolidated_weather = consolidated_weather;
    }

    @SerializedName("consolidated_weather")
    List<Weather> consolidated_weather;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("title")
    private String title;


}
