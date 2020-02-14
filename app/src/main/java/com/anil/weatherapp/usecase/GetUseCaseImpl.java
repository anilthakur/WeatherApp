package com.anil.weatherapp.usecase;

import com.anil.weatherapp.model.currentweather.Weather;
import com.anil.weatherapp.model.forecastweather.ForeCastWeather;
import com.anil.weatherapp.networking.WeatherRepositorty;

import io.reactivex.Observable;

public class GetUseCaseImpl implements GetUseCase {

    private WeatherRepositorty weatherRepositorty;

    /**
     * Use Dagger for providing object
     */
    public GetUseCaseImpl() {
        weatherRepositorty = new WeatherRepositorty();
    }

    @Override
    public Observable<Weather> getWeatherResult(String location, String unit, String appId) {
        return weatherRepositorty.getWeatherResult(location, unit, appId);
    }

    @Override
    public Observable<ForeCastWeather> getForeCastWeatherResult(String weather, String unit, String appID) {
        return weatherRepositorty.getForeCastWeatherResult(weather, unit, appID);
    }
}
