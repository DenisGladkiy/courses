package com.rxn1d.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by spalah on 24.02.2016.
 */
public class Roulette {

    Random random = new Random();
    int redNumber;
    int blackNumber;
    List<RouletteNumber> wheel = new ArrayList<>();

    public Roulette(){
        String color;
        for(int i = 0; i < 37; i++){
            if(i != 0){
                if(redNumber < 18 && blackNumber < 18){
                    color = getRndColor();
                    System.out.println( color);
                }else if(redNumber == 18){
                    System.out.println("black");
                    color = "black";
                }else{
                    System.out.println("red");
                    color = "red";
                }
            }else{
                color = "green";
            }
            RouletteNumber rNumber = new RouletteNumber(i, color);
            wheel.add(rNumber);
        }
    }

    private String getRndColor(){
        String color = new String();
        int colorNumber = random.nextInt(2);
        System.out.println(colorNumber);
        if(colorNumber != 0){
            color = "black";
            blackNumber++;
        }else{
            color = "red";
            redNumber++;
        }
        return color;
    }

    public RouletteNumber getNumber(){
        int i = random.nextInt(37);
        return wheel.get(i);
    }

    public List<RouletteNumber> getWheel(){
        return wheel;
    }




}
