package com.courses.spalah.memento;

import com.courses.spalah.RouletteNumber;

import java.util.List;

/**
 * Created by Денис on 4/14/16.
 */
public class RouletteMemento implements Memento {
    private List<RouletteNumber> wheel;

    public RouletteMemento(List<RouletteNumber> wheel){
        this.wheel = wheel;
    }

    public List<RouletteNumber> getWheel(){
        return wheel;
    }
}
