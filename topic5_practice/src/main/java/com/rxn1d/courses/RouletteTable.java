package com.rxn1d.courses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Denis on 24.02.2016.
 */
public class RouletteTable {
    private Map<String, Integer> players = new HashMap<>();
    private List<Bet> bets = new ArrayList<>();
    private String name;
    private int value;

    public void addPlayer(Player player){
        players.put(player.getName(),player.getBalance());
    }

    public Map<String, Integer> getPlayers(){
        return players;
    }

    public void addBet(Bet bet){
        if(bets.size() == 0){
            checkBalance(bet);
        }else{
            for(Bet b : bets){
                if(b.getPlayerName().equalsIgnoreCase(bet.getPlayerName())){
                    System.out.println("BET NOT ACCEPTED");
                    return;
                }
            }
            checkBalance(bet);
        }
    }

    private void checkBalance(Bet b){
        if(players.containsKey(b.getPlayerName()) && players.get(b.getPlayerName()) >= b.getValue()){
            bets.add(b);
            Casino.addBetStatistics(b);
            System.out.println("BET ACCEPTED");
        }else{
            System.out.println("BET NOT ACCEPTED");
        }
    }

    public void calculateGame(RouletteNumber number){
        Casino.addNumberStatistics(number);
        String color = number.getColor();
        int digit = number.getNumber();
        for(Bet bet : bets){
            name = bet.getPlayerName();
            value = bet.getValue();
            switch (bet.getType()){
                case RED:
                    balanceReview(color.equals("RED"));
                    break;
                case BLACK:
                    balanceReview(color.equals("BLACK"));
                    break;
                case ODD:
                    balanceReview(digit%2 != 0);
                    break;
                case EVEN:
                    balanceReview(digit%2 == 0);
                    break;
                case SMALL:
                    balanceReview(digit > 0 && digit < 19);
                    break;
                case BIG:
                    balanceReview(digit > 18);
                    break;
                case STRAIGHT_UP:
                    if(digit == bet.getBetNumber()){
                        players.put(name, players.get(name) + (value*35));
                        Casino.addToCasinoBalance(-value*35);
                        System.out.println("Player " + name + " +" + (value*35));
                    }else{
                        players.put(name, players.get(name) - value);
                        if(players.get(name) == 0){
                            players.remove(name);
                            System.out.println(name + " quit the game with 0 balance");
                        }
                        Casino.addToCasinoBalance(value);
                        System.out.println("Player " + name + " -" + value);
                    }
                    break;

            }
        }
        bets.clear();
    }

    private void balanceReview(boolean isWinner){
        if(isWinner){
            players.put(name, players.get(name) + value);
            Casino.addToCasinoBalance(-value);
            System.out.println("Player " + name + " +" + value);
        }else{
            players.put(name, players.get(name) - value);
            if(players.get(name) == 0){
                players.remove(name);
                System.out.println(name + " quit the game with 0 balance");
            }
            Casino.addToCasinoBalance(value);
            System.out.println("Player " + name + " -" + value);
        }
    }
}
