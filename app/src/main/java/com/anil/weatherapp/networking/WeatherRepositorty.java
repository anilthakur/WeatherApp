package com.anil.weatherapp.networking;


import com.anil.weatherapp.model.currentweather.Weather;
import com.anil.weatherapp.model.forecastweather.ForeCastWeather;

import io.reactivex.Observable;

/**
 * Created by Anil Kumar on 2020-02-11
 */
public class WeatherRepositorty {

    private WeatherAPI weatherAPI;

    public WeatherRepositorty() {
        weatherAPI = WeatherService.createService(WeatherAPI.class);
    }

    public Observable<Weather> getWeatherResult(String location, String unit, String appId) {
        return weatherAPI.getWeatherResult(location, unit, appId);
    }

    public Observable<ForeCastWeather> getForeCastWeatherResult(String weather, String unit, String appID) {
        return weatherAPI.getForeCastWeatherResult(weather, unit, appID);
    }
}