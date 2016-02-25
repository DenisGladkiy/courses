package com.rxn1d.courses;

/**
 * Created by spalah on 24.02.2016.
 */
public class RouletteNumber {
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
    public String toString(){
        return String.valueOf(number) + "-" + color;
    }
}

