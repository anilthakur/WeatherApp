package com.anil.weatherapp.viewmodel;

import com.anil.weatherapp.model.currentweather.Weather;
import com.anil.weatherapp.model.forecastweather.ForeCastWeather;
import com.anil.weatherapp.usecase.GetUseCase;
import com.anil.weatherapp.usecase.GetUseCaseImpl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Anil Kumar on 2020-02-11
 */
public class WeatherViewModel extends ViewModel {

    private MutableLiveData<Weather> mutableWeatherLiveData;
    private MutableLiveData<ForeCastWeather> mutableForecastLiveData;
    private MutableLiveData<Throwable> apiError;
    private GetUseCase getUseCase;
    private CompositeDisposable disposable;

    /**
     * Call this method when your view model get initialized.
     */
    public void init() {
        getUseCase = new GetUseCaseImpl();
        mutableWeatherLiveData = new MutableLiveData<>();
        mutableForecastLiveData = new MutableLiveData<>();
        apiError = new MutableLiveData<>();
        disposable = new CompositeDisposable();
    }

    public void fetchData(String location, String unit, String appID) {

        Disposable weather = getUseCase.getWeatherResult(location, unit, appID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        mutableWeatherLiveData::postValue,
                        apiError::postValue
                );

        Disposable forecast = getUseCase.getForeCastWeatherResult(location, unit, appID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        mutableForecastLiveData::postValue,
                        apiError::postValue
                );

        disposable.add(weather);
        disposable.add(forecast);

    }

    public LiveData<Weather> getWeatherResponse() {
        return mutableWeatherLiveData;
    }

    public LiveData<ForeCastWeather> getForeCastWeatherResponse() {
        return mutableForecastLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}

