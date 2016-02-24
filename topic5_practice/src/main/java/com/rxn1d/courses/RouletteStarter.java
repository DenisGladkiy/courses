package com.rxn1d.courses;

import java.util.List;

/**
 * Входная точка в игру
 *
 * @author Ievgen Tararaka
 */
public class RouletteStarter {

    public static void main(String[] args) {
        System.out.println("Game Started");
        Roulette wheel = new Roulette();
        List<RouletteNumber> test = wheel.getWheel();
        RouletteNumber winNumber = wheel.getNumber();
        System.out.println(test);
        System.out.println(winNumber);



    }
}
