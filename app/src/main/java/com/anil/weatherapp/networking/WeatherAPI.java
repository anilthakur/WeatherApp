package com.anil.weatherapp.networking;

import com.anil.weatherapp.model.currentweather.Weather;
import com.anil.weatherapp.model.forecastweather.ForeCastWeather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Anil Kumar on 2020-02-11
 */
public interface WeatherAPI {
    @GET("data/2.5/weather")
    Observable<Weather> getWeatherResult(@Query("q") String weather, @Query("units") String unit, @Query("appid") String appID);

    @GET("data/2.5/forecast")
    Observable<ForeCastWeather> getForeCastWeatherResult(@Query("q") String weather, @Query("units") String unit, @Query("appid") String appID);

}
