package com.courses.spalah.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Denis on 01.05.2016.
 */
public class BogoSort implements Runnable {
    private ArrayList<Integer> arrayList;
    private Random generator = new Random();

    public BogoSort(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }


    @Override
    public void run() {
        while (!isSorted(arrayList)) {
            for (int i = 0; i < arrayList.size(); i++){
                int randomPosition = generator.nextInt(arrayList.size());
                Collections.swap(arrayList, i, randomPosition);
            }
        }

    }

    private boolean isSorted(ArrayList<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); i++){
            if (arrayList.get(i) < arrayList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> postArray(){
        return arrayList;
    }

    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
