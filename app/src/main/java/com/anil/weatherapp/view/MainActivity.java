package com.anil.weatherapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.anil.weatherapp.R;
import com.anil.weatherapp.adapter.ForeCastAdapter;
import com.anil.weatherapp.model.forecastweather.ListItem;
import com.anil.weatherapp.viewmodel.WeatherViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.anil.weatherapp.utils.Utils.convertDateFormat;

public class MainActivity extends AppCompatActivity {

    WeatherViewModel weatherViewModel;
    private TextView addressTxt, updated_atTxt, statusTxt, tempTxt, temp_minTxt, temp_maxTxt, sunriseTxt,
            sunsetTxt, windTxt, pressureTxt, humidityTxt;
    private RecyclerView recyclerView;
    private ForeCastAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        weatherViewModel.init();
        fetchData();
        observeDataChanges();
    }

    private void fetchData() {
        weatherViewModel.fetchData("Bangalore,karnataka", "metric", "8887e1c31f3251430bf8523f2647c959");
    }

    private void observeDataChanges() {
        weatherViewModel.getWeatherResponse().observe(this, weather -> {
            if (weather != null) {
                Log.d("Response", weather.getName());
                int updatedAt = weather.getDt();

                String temp = weather.getMain().getTemp() + "°C";
                String tempMin = "Min Temp: " + weather.getMain().getTempMin() + "°C";
                String tempMax = "Max Temp: " + weather.getMain().getTempMin() + "°C";
                int pressure = weather.getMain().getPressure();
                int humidity = weather.getMain().getHumidity();

                int sunrise = weather.getSys().getSunrise();
                int sunset = weather.getSys().getSunset();
                double windSpeed = weather.getWind().getSpeed();
                String weatherDescription = weather.getWeather().get(0).getDescription();

                addressTxt.setText(weather.getName() + ", " + weather.getSys().getCountry());
                updated_atTxt.setText("Updated at: " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000)));
                statusTxt.setText(weatherDescription.toUpperCase());
                tempTxt.setText(temp);
                temp_minTxt.setText(tempMin);
                temp_maxTxt.setText(tempMax);
                sunriseTxt.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise * 1000)));
                sunsetTxt.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset * 1000)));
                windTxt.setText("" + windSpeed);
                pressureTxt.setText("" + pressure);
                humidityTxt.setText("" + humidity);
                findViewById(R.id.loader).setVisibility(View.GONE);
                findViewById(R.id.mainContainer).setVisibility(View.VISIBLE);
            } else {
                findViewById(R.id.loader).setVisibility(View.GONE);
                findViewById(R.id.errorText).setVisibility(View.VISIBLE);
            }

        });
        weatherViewModel.getForeCastWeatherResponse().observe(this, forecastWeather -> {
            if (forecastWeather != null) {
                Log.d("Response", forecastWeather.getCod());
                ArrayList<ListItem> listItems = new ArrayList<>();

                for (int i = 0; i < forecastWeather.getList().size(); i++) {
                    listItems.add(forecastWeather.getList().get(i));
                }

                adapter = new ForeCastAdapter(this, removeDuplicates(listItems));
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


            }
        });
    }

    private void initView() {
        addressTxt = findViewById(R.id.address);
        updated_atTxt = findViewById(R.id.updated_at);
        statusTxt = findViewById(R.id.status);
        tempTxt = findViewById(R.id.temp);
        temp_minTxt = findViewById(R.id.temp_min);
        temp_maxTxt = findViewById(R.id.temp_max);
        sunriseTxt = findViewById(R.id.sunrise);
        sunsetTxt = findViewById(R.id.sunset);
        windTxt = findViewById(R.id.wind);
        pressureTxt = findViewById(R.id.pressure);
        humidityTxt = findViewById(R.id.humidity);
        recyclerView = findViewById(R.id.recyclerView);

        findViewById(R.id.loader).setVisibility(View.VISIBLE);
        findViewById(R.id.mainContainer).setVisibility(View.GONE);
        findViewById(R.id.errorText).setVisibility(View.GONE);
    }

    public ArrayList<ListItem> removeDuplicates(ArrayList<ListItem> arrayList) {
        Set<ListItem> s = new TreeSet<ListItem>(new Comparator<ListItem>() {

            @Override
            public int compare(ListItem o1, ListItem o2) {

                if (convertDateFormat(o1.getDtTxt()).equalsIgnoreCase(convertDateFormat(o2.getDtTxt()))) {
                    return 0;
                }
                return 1;
            }
        });
        s.addAll(arrayList);
        ArrayList<ListItem> res = convertSetToList(s);
        return res;
    }

    public static <T> ArrayList<T> convertSetToList(Set<T> set) {
        ArrayList<T> list = new ArrayList<>(set);
        return list;
    }


}
