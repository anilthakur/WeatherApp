package com.anil.weatherapp.model.forecastweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City{

	@SerializedName("country")
	@Expose
	private String country;

	@SerializedName("coord")
	@Expose
	private Coord coord;

	@SerializedName("sunrise")
	@Expose
	private int sunrise;

	@SerializedName("timezone")
	@Expose
	private int timezone;

	@SerializedName("sunset")
	@Expose
	private int sunset;

	@SerializedName("name")
	@Expose
	private String name;


	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("population")
	@Expose
	private int population;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCoord(Coord coord){
		this.coord = coord;
	}

	public Coord getCoord(){
		return coord;
	}

	public void setSunrise(int sunrise){
		this.sunrise = sunrise;
	}

	public int getSunrise(){
		return sunrise;
	}

	public void setTimezone(int timezone){
		this.timezone = timezone;
	}

	public int getTimezone(){
		return timezone;
	}

	public void setSunset(int sunset){
		this.sunset = sunset;
	}

	public int getSunset(){
		return sunset;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPopulation(int population){
		this.population = population;
	}

	public int getPopulation(){
		return population;
	}

	@Override
 	public String toString(){
		return 
			"City{" + 
			"country = '" + country + '\'' + 
			",coord = '" + coord + '\'' + 
			",sunrise = '" + sunrise + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",sunset = '" + sunset + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",population = '" + population + '\'' + 
			"}";
		}
}