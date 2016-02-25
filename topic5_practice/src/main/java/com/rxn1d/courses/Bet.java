package com.rxn1d.courses;

/**
 * Created by Denis on 24.02.2016.
 */
public class Bet {

    private int value;
    private String playerName;
    private BetType type;
    private int betNumber;

    public Bet(int value,BetType type,String playerName){
        this.value = value;
        this.playerName = playerName;
        this.type = type;
    }

    public Bet(String[] input){
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
                    incorrect();
                    return;
                }
                break;
            default:
                incorrect();
                break;
        }
        try {
            value = Integer.valueOf(input[2]);
        }catch (Exception e){
            incorrect();
            return;
        }
        playerName = input[1];
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public void setType(BetType type){
        this.type = type;
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

    private void incorrect(){
            System.out.println("Incorrect input. Try again.");
    }
}
