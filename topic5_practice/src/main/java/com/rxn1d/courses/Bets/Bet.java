package com.rxn1d.courses.Bets;

import com.rxn1d.courses.RouletteNumber;

/**
 * Created by Denis on 24.02.2016.
 */
public class Bet {

    protected int value;
    protected String playerName;
    protected BetType type;
    protected int multiplier;

    public int getValue() {
        return value;
    }
    public String getPlayerName() {
        return playerName;
    }
    public BetType getType(){ return type; }
    public int getMultiplier(){ return multiplier; }

    public boolean isWon(RouletteNumber number){
        return false;
    }
}
