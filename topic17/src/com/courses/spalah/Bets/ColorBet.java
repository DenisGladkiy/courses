package com.courses.spalah.Bets;

import com.courses.spalah.RouletteNumber;

/**
 * Created by Denis on 01.03.2016.
 */
public class ColorBet extends Bet {

    public ColorBet(BetType type, String playerName, int value){
        this.type = type;
        this.playerName = playerName;
        this.value = value;
        multiplier = 1;
    }

    public boolean isWon(RouletteNumber number){
        if(number.getColor().equals(type.toString())){
            return true;
        }
        return false;
    }
}
