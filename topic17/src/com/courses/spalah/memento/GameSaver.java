package com.courses.spalah.memento;

import com.courses.spalah.Casino;
import com.courses.spalah.Roulette;
import com.courses.spalah.RouletteTable;

/**
 * Created by Денис on 4/14/16.
 */
public class GameSaver {
    private static CasinoMemento casinoMemento;
    private static RouletteMemento rouletteMemento;
    private static TableMemento tableMemento;

    public static void saveGame(Roulette wheel, RouletteTable table){
        tableMemento = (TableMemento) table.saveState();
        rouletteMemento = (RouletteMemento) wheel.saveState();
        casinoMemento = Casino.saveState();
    }

    public static void loadGame(Roulette wheel, RouletteTable table){
        table.loadState(tableMemento);
        wheel.loadState(rouletteMemento);
        Casino.loadState(casinoMemento);
    }
}
