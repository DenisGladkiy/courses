package com.courses.spalah.sort;

import java.util.ArrayList;

/**
 * Created by Денис on 5/6/16.
 */
public class Sort implements Runnable {
    ArrayList<Integer> arrayList;
    boolean pause = false;

    @Override
    public void run() {
    }

    public ArrayList<Integer> postArray() {
        return arrayList;
    }


    public void pause() {
        if (pause == false) pause = true;
        else pause = false;
    }

    void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
