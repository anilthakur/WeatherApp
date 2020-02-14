package com.anil.weatherapp.model.currentweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather{

	@SerializedName("visibility")
	@Expose
	private int visibility;

	@SerializedName("timezone")
	@Expose
	private int timezone;

	@SerializedName("main")
	@Expose
	private Main main;

	@SerializedName("clouds")
	@Expose
	private Clouds clouds;

	@SerializedName("sys")
	@Expose
	private Sys sys;

	@SerializedName("dt")
	@Expose
	private int dt;

	@SerializedName("coord")
	@Expose
	private Coord coord;

	@SerializedName("weather")
	@Expose
	private List<WeatherItem> weather;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("cod")
	@Expose
	private int cod;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("base")
	@Expose
	private String base;

	@SerializedName("wind")
	@Expose
	private Wind wind;

	public void setVisibility(int visibility){
		this.visibility = visibility;
	}

	public int getVisibility(){
		return visibility;
	}

	public void setTimezone(int timezone){
		this.timezone = timezone;
	}

	public int getTimezone(){
		return timezone;
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

	public void setDt(int dt){
		this.dt = dt;
	}

	public int getDt(){
		return dt;
	}

	public void setCoord(Coord coord){
		this.coord = coord;
	}

	public Coord getCoord(){
		return coord;
	}

	public void setWeather(List<WeatherItem> weather){
		this.weather = weather;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public int getCod(){
		return cod;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBase(String base){
		this.base = base;
	}

	public String getBase(){
		return base;
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
			"Weather{" + 
			"visibility = '" + visibility + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",main = '" + main + '\'' + 
			",clouds = '" + clouds + '\'' + 
			",sys = '" + sys + '\'' + 
			",dt = '" + dt + '\'' + 
			",coord = '" + coord + '\'' + 
			",weather = '" + weather + '\'' + 
			",name = '" + name + '\'' + 
			",cod = '" + cod + '\'' + 
			",id = '" + id + '\'' + 
			",base = '" + base + '\'' + 
			",wind = '" + wind + '\'' + 
			"}";
		}
}