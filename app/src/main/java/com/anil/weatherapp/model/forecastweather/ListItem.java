package com.anil.weatherapp.model.forecastweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListItem{

	@SerializedName("dt")
	@Expose
	private int dt;

	@SerializedName("dt_txt")
	@Expose
	private String dtTxt;

	@SerializedName("weather")
	@Expose
	private List<WeatherItem> weather;

	@SerializedName("main")
	@Expose
	private Main main;

	@SerializedName("clouds")
	@Expose
	private Clouds clouds;

	@SerializedName("sys")
	@Expose
	private Sys sys;

	@SerializedName("wind")
	@Expose
	private Wind wind;

	public void setDt(int dt){
		this.dt = dt;
	}

	public int getDt(){
		return dt;
	}

	public void setDtTxt(String dtTxt){
		this.dtTxt = dtTxt;
	}

	public String getDtTxt(){
		return dtTxt;
	}

	public void setWeather(List<WeatherItem> weather){
		this.weather = weather;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public void setMain(Main main){
		this.main = main;
	}

	public Main getMain(){
		return main;
	}

	public void setClouds(Clouds clouds){
		this.clouds = clouds;
	}

	public Clouds getClouds(){
		return clouds;
	}

	public void setSys(Sys sys){
		this.sys = sys;
	}

	public Sys getSys(){
		return sys;
	}

	public void setWind(Wind wind){
		this.wind = wind;
	}

	public Wind getWind(){
		return wind;
	}

	@Override
 	public String toString(){
		return 
			"ListItem{" + 
			"dt = '" + dt + '\'' + 
			",dt_txt = '" + dtTxt + '\'' + 
			",weather = '" + weather + '\'' + 
			",main = '" + main + '\'' + 
			",clouds = '" + clouds + '\'' + 
			",sys = '" + sys + '\'' + 
			",wind = '" + wind + '\'' + 
			"}";
		}
}