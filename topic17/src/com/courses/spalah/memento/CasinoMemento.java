package com.courses.spalah.memento;

import com.courses.spalah.Bets.BetType;
import com.courses.spalah.RouletteNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Денис on 4/14/16.
 */
public class CasinoMemento {
    private int casinoBalance;
    private int betCounter;
    private Map<BetType, Integer> bets = new HashMap<>();
    private Map<RouletteNumber, Integer> numbers = new HashMap<>();

    public CasinoMemento(int casinoBalance, int betCounter, Map<BetType, Integer> bets,
                         Map<RouletteNumber, Integer> numbers){
        this.casinoBalance = casinoBalance;
        this.betCounter = betCounter;
        this.bets = bets;
        this.numbers = numbers;
    }

    public int getCasinoBalance(){
        return casinoBalance;
    }
    public int getBetCounter(){
        return betCounter;
    }
    public Map<BetType, Integer> getBets(){
        return bets;
    }
    public Map<RouletteNumber, Integer> getNumbers(){
        return numbers;
    }

}
