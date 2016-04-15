package com.courses.spalah.Bets;

import com.courses.spalah.RouletteNumber;

/**
 * Created by Denis on 01.03.2016.
 */
public class OddEvenBet extends Bet {

    public OddEvenBet(BetType type, String playerName, int value){
        this.type = type;
        this.playerName = playerName;
        this.value = value;
        multiplier = 1;
    }

    public boolean isWon(RouletteNumber number){
        int digit = number.getNumber();
        if(digit == 0){
            return false;
        }else if(digit % 2 == 0 && type == BetType.EVEN){
            return true;
        }else if(digit % 2 != 0 && type == BetType.ODD){
            return true;
        }else{
            return false;
        }
    }
}
