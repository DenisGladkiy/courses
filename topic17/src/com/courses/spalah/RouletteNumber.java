package com.courses.spalah;

import java.io.Serializable;

/**
 * Created by spalah on 24.02.2016.
 */
public class RouletteNumber implements Serializable {
    private int number;
    private String color;

    public RouletteNumber(int number, String color){
        this.number = number;
        this.color = color;
    }

    public int getNumber(){
        return number;
    }
    public  String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String toString(){
        return String.valueOf(number) + "-" + color;
    }
}

