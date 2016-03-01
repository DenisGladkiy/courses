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
    private List<RouletteNumber> wheel = new ArrayList<>();

    public Roulette(){
        String color;
        RouletteNumber rNumber = new RouletteNumber(0, "GREEN");
        wheel.add(rNumber);
        for(int i = 1; i < 37; i++){
            color = "BLACK";
            rNumber = new RouletteNumber(i, color);
            wheel.add(rNumber);
        }
        for(int i = 0; i < 18; i++){
            rNumber = wheel.get((random.nextInt(36))+1);
            while(!rNumber.getColor().equals("BLACK")){
                rNumber = wheel.get((random.nextInt(36))+1);
            }
            rNumber.setColor("RED");
        }
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
