package com.rxn1d.courses;

/**
 * Created by spalah on 24.02.2016.
 */
public class Player {
    
    private String name;
    private int balance;

    public Player(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
