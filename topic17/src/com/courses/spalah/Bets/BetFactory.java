package com.courses.spalah.Bets;

import com.courses.spalah.myExceptions.IncorrectInputException;

import java.util.Arrays;

/**
 * Created by Denis on 01.03.2016.
 */
public class BetFactory {
    private static int value;
    private static int number;
    private static String betType;
    private static String playerName;
    private static Bet bet;


    public static Bet getBet(String[] input) throws IncorrectInputException {
        try {
            value = Integer.valueOf(input[2]);
            if(input.length == 5){
                number = Integer.valueOf(input[4]);
            }
        }catch (NumberFormatException e){
            incorrect(input);
        }
        betType = input[3];
        playerName = input[1];
        switch (betType.toLowerCase()){
            case "red":
                bet = new ColorBet(BetType.RED, playerName, value);
                break;
            case "black":
                bet = new ColorBet(BetType.BLACK, playerName, value);
                break;
            case "big":
                bet = new SmallBigBet(BetType.BIG, playerName, value);
                break;
            case "small":
                bet = new SmallBigBet(BetType.SMALL, playerName, value);
                break;
            case "odd":
                bet = new OddEvenBet(BetType.ODD, playerName, value);
                break;
            case "even":
                bet = new OddEvenBet(BetType.EVEN, playerName, value);
                break;
            case "straight_up":
                bet = new StraightUpBet(BetType.STRAIGHT_UP, playerName, value, number);
                break;
            default:
                incorrect(input);
                break;
        }
        return bet;
    }

    private static void incorrect(String[] in) throws IncorrectInputException {
        throw new IncorrectInputException(Arrays.toString(in));
    }
}
