package com.anil.weatherapp.model.forecastweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForeCastWeather{

	@SerializedName("city")
	@Expose
	private City city;

	@SerializedName("cnt")
	@Expose
	private int cnt;

	@SerializedName("cod")
	@Expose
	private String cod;

	@SerializedName("message")
	@Expose
	private int message;

	@SerializedName("list")
	@Expose
	private List<ListItem> list;

	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}

	public void setCnt(int cnt){
		this.cnt = cnt;
	}

	public int getCnt(){
		return cnt;
	}

	public void setCod(String cod){
		this.cod = cod;
	}

	public String getCod(){
		return cod;
	}

	public void setMessage(int message){
		this.message = message;
	}

	public int getMessage(){
		return message;
	}

	public void setList(List<ListItem> list){
		this.list = list;
	}

	public List<ListItem> getList(){
		return list;
	}

	@Override
 	public String toString(){
		return 
			"ForeCastWeather{" + 
			"city = '" + city + '\'' + 
			",cnt = '" + cnt + '\'' + 
			",cod = '" + cod + '\'' + 
			",message = '" + message + '\'' + 
			",list = '" + list + '\'' + 
			"}";
		}
}