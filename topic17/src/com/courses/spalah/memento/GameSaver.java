package com.courses.spalah.memento;

import com.courses.spalah.Casino;
import com.courses.spalah.Roulette;
import com.courses.spalah.RouletteTable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Денис on 4/14/16.
 */
public class GameSaver {
    private static CasinoMemento casinoMemento;
    private static RouletteMemento rouletteMemento;
    private static TableMemento tableMemento;
    private static Map<String, Memento> memento;

    public static void saveGame(Roulette wheel, RouletteTable table) {
        memento = new HashMap<>();
        tableMemento = table.saveState();
        memento.put("tableMemento", tableMemento);
        rouletteMemento = wheel.saveState();
        memento.put("rouletteMemento", rouletteMemento);
        casinoMemento = Casino.saveState();
        memento.put("casinoMemento", casinoMemento);
        serializeMemento();
        System.out.println("Game saved");
    }

    public static void loadGame(Roulette wheel, RouletteTable table) {
        deserializeMemento();
        tableMemento = (TableMemento) memento.get("tableMemento");
        rouletteMemento = (RouletteMemento) memento.get("rouletteMemento");
        casinoMemento = (CasinoMemento) memento.get("casinoMemento");
        table.loadState(tableMemento);
        wheel.loadState(rouletteMemento);
        Casino.loadState(casinoMemento);
        System.out.println("Game loaded");
    }

    private static void serializeMemento() {
        try {
            FileOutputStream outputStream = new FileOutputStream("casino.mem");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(memento);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeMemento() {
        try {
            FileInputStream inputStream = new FileInputStream("casino.mem");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            memento = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
