package com.courses.spalah.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Denis on 01.05.2016.
 */
public class InsertionSort implements Runnable {
    ArrayList<Integer> arrayList;

    public InsertionSort(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public void run() {

        int temp;
        for (int i = 1; i < arrayList.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(arrayList.get(j) < arrayList.get(j-1)){
                    temp = arrayList.get(j);
                    Collections.swap(arrayList, j, j-1);
                    arrayList.set(j-1, temp);
                }
            }
        }
    }

    public ArrayList<Integer> postArray(){
        return arrayList;
    }
}
