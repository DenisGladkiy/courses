package com.rxn1d.courses;

import com.rxn1d.courses.myExceptions.IncorrectInputException;

import java.util.Arrays;

/**
 * Created by Denis on 24.02.2016.
 */
public class Bet {

    private int value;
    private String playerName;
    private BetType type;
    private int betNumber;

    public Bet(String[] input) throws IncorrectInputException {
        try {
            int test = Integer.valueOf(input[2]);
            if(test > 500){
                System.out.println("Max bet is 500");
                return;
            }else{
                value = test;
            }
        }catch (Exception e){
            incorrect(input);
            return;
        }
        switch (input[3].toLowerCase()){
            case "red":
                type = BetType.RED;
                break;
            case "black":
                type = BetType.BLACK;
                break;
            case "big":
                type = BetType.BIG;
                break;
            case "small":
                type = BetType.SMALL;
                break;
            case "odd":
                type = BetType.ODD;
                break;
            case "even":
                type = BetType.EVEN;
                break;
            case "straight_up":
                type = BetType.STRAIGHT_UP;
                try {
                    betNumber = Integer.valueOf(input[4]);
                }catch (Exception e){
                    incorrect(input);
                    return;
                }
                break;
            default:
                incorrect(input);
                break;
        }
        playerName = input[1];
    }

    public int getValue() {
        return value;
    }

    public String getPlayerName() {
        return playerName;
    }

    public BetType getType(){
        return type;
    }

    public int getBetNumber(){
        return betNumber;
    }

    private void incorrect(String[] in) throws IncorrectInputException {
        throw new IncorrectInputException(Arrays.toString(in));
        //System.out.println("Incorrect input. Try again.");
    }
}
