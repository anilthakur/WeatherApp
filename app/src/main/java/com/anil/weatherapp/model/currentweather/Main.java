package com.anil.weatherapp.model.currentweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main{

	@SerializedName("temp")
	@Expose
	private double temp;

	@SerializedName("temp_min")
	@Expose

	private double tempMin;

	@SerializedName("humidity")
	@Expose
	private int humidity;

	@SerializedName("pressure")
	@Expose
	private int pressure;

	@SerializedName("feels_like")
	@Expose
	private double feelsLike;

	@SerializedName("temp_max")
	@Expose
	private double tempMax;

	public void setTemp(double temp){
		this.temp = temp;
	}

	public double getTemp(){
		return temp;
	}

	public void setTempMin(double tempMin){
		this.tempMin = tempMin;
	}

	public double getTempMin(){
		return tempMin;
	}

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	public int getHumidity(){
		return humidity;
	}

	public void setPressure(int pressure){
		this.pressure = pressure;
	}

	public int getPressure(){
		return pressure;
	}

	public void setFeelsLike(double feelsLike){
		this.feelsLike = feelsLike;
	}

	public double getFeelsLike(){
		return feelsLike;
	}

	public void setTempMax(double tempMax){
		this.tempMax = tempMax;
	}

	public double getTempMax(){
		return tempMax;
	}

	@Override
 	public String toString(){
		return 
			"Main{" + 
			"temp = '" + temp + '\'' + 
			",temp_min = '" + tempMin + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",feels_like = '" + feelsLike + '\'' + 
			",temp_max = '" + tempMax + '\'' + 
			"}";
		}
}