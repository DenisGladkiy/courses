package com.rxn1d.courses;

import com.rxn1d.courses.Bets.Bet;

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
                    System.out.println("BET NOT ACCEPTED"+"\n");
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
            System.out.println("BET ACCEPTED"+"\n");
        }else{
            System.out.println("BET NOT ACCEPTED"+"\n");
        }
    }

    public void calculateGame(RouletteNumber number){
        Casino.addNumberStatistics(number);
        //String color = number.getColor();
        //int digit = number.getNumber();
        for(Bet bet : bets){
            name = bet.getPlayerName();
            value = bet.getValue();
            int multiplier = bet.getMultiplier();
            int balance = players.get(name);
            if(bet.isWon(number)){
                players.put(name, (balance+(value*multiplier)));
                Casino.addToCasinoBalance(-value);
                System.out.println("Player " + name + " +" + value);
            }else{
                players.put(name, (balance - value));
                Casino.addToCasinoBalance(value);
                System.out.println("Player " + name + " -" + value);
                if(players.get(name) == 0){
                    players.remove(name);
                    System.out.println(name + " quit the game with 0 balance");
                }
            }
        }
        bets.clear();
    }
}
