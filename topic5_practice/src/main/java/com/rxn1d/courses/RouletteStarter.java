package com.rxn1d.courses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Входная точка в игру
 *
 * @author Ievgen Tararaka
 */
public class RouletteStarter {
    private static String[] input;
    private static Roulette wheel = new Roulette();
    private static RouletteTable table = new RouletteTable();

    public static void main(String[] args) {
        System.out.println("Game Started");
        List<RouletteNumber> roulette = wheel.getWheel();
        System.out.println("Generated Roulette : "+roulette);
        while(true) {
            input = ConsoleReader.readFromConsole();
            if(input[0].equals("file")){
                String[][] commandFile = new String[0][];
                try {
                    commandFile = CommandFileReader.readFromFile();
                    for(String[] input : commandFile){
                        printStringArr(input);
                        play(input);
                    }
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(!input[0].equals("exit")){
                play(input);
            }else{
                break;
            }
        }
        System.out.println("Game over");
    }

    private static void play(String[] in){
        switch (in[0].toLowerCase()){
            case "play_game":
                RouletteNumber number = wheel.getNumber();
                System.out.println("Winning number = " + number);
                table.calculateGame(number);
                break;
            case "new_user":
                addNewUser(in);
                break;
            case "bet":
                addNewBet(in);
                break;
            case "stats":
                Casino.showStats(table.getPlayers());
                break;
            default:
                System.out.println("Unknown input"+"\n");
                break;
        }
    }

    private static void addNewUser(String[] in){
        if(table.getPlayers().size() < 5) {
            if (in.length == 3) {
                int balance = 0;
                try {
                    balance = Integer.valueOf(in[2]);
                } catch (Exception e) {
                    incorrect();
                    return;
                }
                Player player = new Player(in[1], balance);
                table.addPlayer(player);
                System.out.println("New user with name = " + player.getName() + " and balance = " + player.getBalance() +
                        " is added to table"+"\n");

            } else {
                incorrect();
            }
        }else{
            System.out.println("No place at the table"+"\n");
        }
    }

    private static void addNewBet(String[] in){
        if(in.length >= 4){
            Bet bet = new Bet(in);
            if(null != bet){
                table.addBet(bet);
            }else{
                incorrect();
            }
        }else{
            incorrect();
        }
    }

    private static void incorrect(){
        System.out.println("Incorrect input. Try again.");
    }

    private static void printStringArr(String[] arr){
        for(String s : arr) System.out.print(s + " ");
        System.out.print("\n");
    }

}
