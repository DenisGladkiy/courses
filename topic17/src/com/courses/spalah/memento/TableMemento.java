package com.courses.spalah.memento;

import com.courses.spalah.Bets.Bet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Денис on 4/14/16.
 */
public class TableMemento {
    private Map<String, Integer> players = new HashMap<>();
    private List<Bet> bets = new ArrayList<>();

    public TableMemento(Map<String, Integer> players, List<Bet> bets) {
        this.players = players;
        this.bets = bets;
    }

    public Map<String, Integer> getPlayers() {
        return players;
    }

    public List<Bet> getBets() {
        return bets;
    }
}
