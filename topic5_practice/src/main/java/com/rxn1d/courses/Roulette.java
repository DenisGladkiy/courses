package com.rxn1d.courses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by spalah on 24.02.2016.
 */
public class Roulette {

    private Random random = new Random();
    private int redNumber;
    private int blackNumber;
    private List<RouletteNumber> wheel = new ArrayList<>();

    public Roulette(){
        String color;
        for(int i = 0; i < 37; i++){
            if(i != 0){
                if(redNumber < 18 && blackNumber < 18){
                    color = getRndColor();
                }else if(redNumber == 18){
                    color = "BLACK";
                }else{
                    color = "RED";
                }
            }else{
                color = "GREEN";
            }
            RouletteNumber rNumber = new RouletteNumber(i, color);
            wheel.add(rNumber);
        }
    }

    private String getRndColor(){
        String color;
        int colorNumber = random.nextInt(2);
        if(colorNumber != 0){
            color = "BLACK";
            blackNumber++;
        }else{
            color = "RED";
            redNumber++;
        }
        return color;
    }

    public RouletteNumber getNumber(){
        int i = random.nextInt(37);
        return wheel.get(i);
    }

    public List<RouletteNumber> getWheel(){
        Collections.shuffle(wheel,random);
        return wheel;
    }
}
