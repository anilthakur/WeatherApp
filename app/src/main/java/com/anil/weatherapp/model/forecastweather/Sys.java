package com.anil.weatherapp.model.forecastweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys{

	@SerializedName("pod")
	@Expose
	private String pod;

	public void setPod(String pod){
		this.pod = pod;
	}

	public String getPod(){
		return pod;
	}

	@Override
 	public String toString(){
		return 
			"Sys{" + 
			"pod = '" + pod + '\'' + 
			"}";
		}
}