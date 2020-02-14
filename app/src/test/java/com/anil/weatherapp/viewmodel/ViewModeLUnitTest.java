package com.anil.weatherapp.viewmodel;

import com.anil.weatherapp.model.currentweather.Weather;
import com.anil.weatherapp.model.forecastweather.ForeCastWeather;
import com.anil.weatherapp.networking.WeatherRepositorty;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import androidx.lifecycle.MutableLiveData;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Anil Kumar on 2020-02-12
 */
@RunWith(JUnit4.class)
public class ViewModeLUnitTest {


    private WeatherViewModel viewModel;
    @Mock
    MutableLiveData<Weather> weatherMutableLiveData;
    @Mock
    MutableLiveData<ForeCastWeather> foreCastWeatherMutableLiveData;
    @Mock
    private WeatherRepositorty weatherRepositorty;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        if (weatherRepositorty == null) {
            weatherRepositorty = new WeatherRepositorty();
        }
//        weatherRepositorty = WeatherRepositorty.getInstance();
//        weatherMutableLiveData = weatherRepositorty.getWeatherData("Bangalore,karnataka", "metric", "8887e1c31f3251430bf8523f2647c959");
//        foreCastWeatherMutableLiveData = weatherRepositorty.getForeCastWeatherData("Bangalore,karnataka", "metric", "8887e1c31f3251430bf8523f2647c959");
    }

    @Test
    public void testNull() {
//        when(weatherMutableLiveData).thenReturn(null);
//        assertNotNull(viewModel.getNewsListState());
//        assertTrue(viewModel.getNewsListState().hasObservers());


        when(viewModel).thenReturn(null);
        assertNotNull(viewModel.getWeatherResponse());
//        assertTrue(viewModel.getNewsListState().hasObservers());
    }

    //
//    @Test
//    public void testApiFetchDataSuccess() {
//        // Mock API response
//        when(apiClient.fetchNews()).thenReturn(Single.just(new NewsList()));
//        viewModel.fetchNews();
//        verify(observer).onChanged(NewsListViewState.LOADING_STATE);
//        verify(observer).onChanged(NewsListViewState.SUCCESS_STATE);
//    }
//
    @Test
    public void testApiFetchDataError() {
//        viewModel.init("Bangalore,karnataka", "metric", "8887e1c31f3251430bf8523f2647c959");
//
        verify(weatherMutableLiveData, null);
//        verify(observer).onChanged(NewsListViewState.ERROR_STATE);
    }

    @After
    public void tearDown() throws Exception {
        viewModel = null;
    }
}
