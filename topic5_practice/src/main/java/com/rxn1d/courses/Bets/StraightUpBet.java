package com.rxn1d.courses.Bets;

import com.rxn1d.courses.RouletteNumber;

/**
 * Created by Denis on 01.03.2016.
 */
public class StraightUpBet extends Bet {
    private int number;

    public StraightUpBet(BetType type, String playerName, int value, int number){
        this.number = number;
        this.playerName = playerName;
        this.value = value;
        this.type = type;
        multiplier = 35;
    }

    public boolean isWon(RouletteNumber rNumber){
        int digit = rNumber.getNumber();
        if(digit == number){
            return true;
        }else{
            return false;
        }
    }
}
