package com.anil.weatherapp.usecase;


import com.anil.weatherapp.model.currentweather.Weather;
import com.anil.weatherapp.model.forecastweather.ForeCastWeather;

import io.reactivex.Observable;

public interface GetUseCase {
    Observable<Weather> getWeatherResult(String location, String unit, String appId);
    Observable<ForeCastWeather> getForeCastWeatherResult(String weather, String unit, String appID);
}
