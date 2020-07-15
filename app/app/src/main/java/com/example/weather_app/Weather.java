package com.example.weather_app;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {



    @SerializedName("weather_state_name")
    private String weather_state_name;
    @SerializedName("min_temp")
    private double min_temp;
    @SerializedName("max_temp")
    private double max_temp;
    @SerializedName("wind_speed")
    private double wind_speed;
    @SerializedName("humidity")
    private int humidity;
    @SerializedName("predictability")
    private int predictability;
    @SerializedName("weather_state_abbr")
    private String weather_state_abbr;
    @SerializedName("applicable_date")
    private String applicable_date;
    @SerializedName("the_temp")
    private double the_temp;

    public Weather(String weather_state_name, double min_temp, double max_temp, double wind_speed, int humidity, int predictability, String weather_state_abbr, String applicable_date, double the_temp) {
        this.weather_state_name = weather_state_name;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.wind_speed = wind_speed;
        this.humidity = humidity;
        this.predictability = predictability;
        this.weather_state_abbr = weather_state_abbr;
        this.applicable_date = applicable_date;
        this.the_temp = the_temp;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPredictability() {
        return predictability;
    }

    public void setPredictability(int predictability) {
        this.predictability = predictability;
    }

    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public double getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(double the_temp) {
        this.the_temp = the_temp;
    }

}
