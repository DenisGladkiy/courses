package com.courses.spalah;

import com.courses.spalah.Bets.Bet;
import com.courses.spalah.memento.TableMemento;
import com.courses.spalah.myExceptions.IncorrectInputException;
import com.courses.spalah.myExceptions.TableIsFullException;

import java.util.*;

/**
 * Created by Denis on 24.02.2016.
 */
public class RouletteTable {
    private Map<String, Integer> players = new HashMap<>();
    private List<Bet> bets = new ArrayList<>();
    private String name;
    private int value;

    public Map<String, Integer> getPlayers() {
        return players;
    }

    public void addBet(Bet bet) {
        if (bets.size() == 0) {
            checkBalance(bet);
        } else {
            for (Bet b : bets) {
                if (b.getPlayerName().equalsIgnoreCase(bet.getPlayerName())) {
                    System.out.println("BET NOT ACCEPTED" + "\n");
                    return;
                }
            }
            checkBalance(bet);
        }
    }

    public void addPlayer(String[] input) throws TableIsFullException, IncorrectInputException {
        if (players.size() < 5) {
            if (!players.containsKey(input[1])) {
                int balance;
                try {
                    balance = Integer.valueOf(input[2]);
                } catch (NumberFormatException e) {
                    throw new IncorrectInputException(Arrays.toString(input));
                }
                players.put(input[1], balance);
                System.out.println("New user with name = " + input[1] + " and balance = " + balance +
                        " is added to table" + "\n");
            } else {
                System.out.println("Player " + input[1] + " already at the table");
            }
        } else {
            throw new TableIsFullException("No free place at the table");
        }
    }

    private void checkBalance(Bet b) {
        if (players.containsKey(b.getPlayerName()) && players.get(b.getPlayerName()) >= b.getValue()) {
            bets.add(b);
            Casino.addBetStatistics(b);
            System.out.println("BET ACCEPTED" + "\n");
        } else {
            System.out.println("BET NOT ACCEPTED" + "\n");
        }
    }

    public void calculateGame(RouletteNumber number) {
        Casino.addNumberStatistics(number);
        for (Bet bet : bets) {
            name = bet.getPlayerName();
            value = bet.getValue();
            int multiplier = bet.getMultiplier();
            int balance = players.get(name);
            if (bet.isWon(number)) {
                players.put(name, (balance + (value * multiplier)));
                Casino.addToCasinoBalance(-value);
                System.out.println("Player " + name + " +" + value);
            } else {
                players.put(name, (balance - value));
                Casino.addToCasinoBalance(value);
                System.out.println("Player " + name + " -" + value);
                if (players.get(name) == 0) {
                    players.remove(name);
                    System.out.println(name + " quit the game with 0 balance");
                }
            }
        }
        bets.clear();
    }

    public void loadState(TableMemento memento) {
        players = memento.getPlayers();
        bets = memento.getBets();
    }

    public TableMemento saveState() {
        Map<String, Integer> savedPlayers = new HashMap<>(players);
        List<Bet> savedBets = new ArrayList<>();
        for (Bet bet : bets) {
            savedBets.add(bet);
        }
        return new TableMemento(savedPlayers, savedBets);
    }
}
