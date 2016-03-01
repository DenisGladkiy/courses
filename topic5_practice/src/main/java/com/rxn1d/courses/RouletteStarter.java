package com.rxn1d.courses;

import com.rxn1d.courses.Bets.Bet;
import com.rxn1d.courses.Bets.BetFactory;
import com.rxn1d.courses.myExceptions.TableIsFullException;
import com.rxn1d.courses.myExceptions.IncorrectInputException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
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
        String[][] commandFile;
        System.out.println("Generated Roulette : "+roulette);
        while(true) {
                input = ConsoleReader.readFromConsole();
                if (input[0].equals("file")) {
                    try {
                        commandFile = CommandFileReader.readFromFile();
                        for (String[] input : commandFile) {
                            printStringArr(input);
                            play(input);
                        }
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                } else if (!input[0].equals("exit")) {
                    play(input);
                } else {
                    System.out.println("Game over");
                    break;
                }
        }
    }

    private static void play(String[] in) {
        try {
            switch (in[0].toLowerCase()) {
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
                    incorrect(in);
                    break;
            }
        }catch (TableIsFullException e){
            e.printStackTrace();
        }catch (IncorrectInputException e){
            e.printStackTrace();
        }
    }

    private static void addNewUser(String[] in) throws TableIsFullException, IncorrectInputException {
        //System.out.println("addNewUser "+ table.getPlayers().size());
        if(table.getPlayers().size() < 5 && !table.getPlayers().containsKey(in[1])) {
            if (in.length == 3) {
                int balance = 0;
                try {
                    balance = Integer.valueOf(in[2]);
                } catch (Exception e) {
                    incorrect(in);
                    return;
                }
                Player player = new Player(in[1], balance);
                table.addPlayer(player);
                System.out.println("New user with name = " + player.getName() + " and balance = " + player.getBalance() +
                        " is added to table"+"\n");

            } else {
                incorrect(in);
            }
        }else{
            throw new TableIsFullException("No free place at the table");
        }
    }

    private static void addNewBet(String[] in) throws IncorrectInputException {
        if(in.length >= 4){
            Bet bet = BetFactory.getBet(in);
            table.addBet(bet);
        }else{
            incorrect(in);
        }
    }

    private static void incorrect(String[] in) throws IncorrectInputException {
        throw new IncorrectInputException(Arrays.toString(in));
    }

    private static void printStringArr(String[] arr){
        for(String s : arr) System.out.print(s + " ");
        System.out.print("\n");
    }

}
