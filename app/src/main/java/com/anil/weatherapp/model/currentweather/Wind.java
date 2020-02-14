package com.anil.weatherapp.model.currentweather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("deg")
    @Expose
    private int deg;

    @SerializedName("speed")
    @Expose
    private double speed;

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getDeg() {
        return deg;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return
                "Wind{" +
                        "deg = '" + deg + '\'' +
                        ",speed = '" + speed + '\'' +
                        "}";
    }
}