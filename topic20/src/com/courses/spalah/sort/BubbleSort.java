package com.courses.spalah.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Denis on 01.05.2016.
 */
public class BubbleSort implements Runnable {
    ArrayList<Integer> arrayList;

    public BubbleSort(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        for(int i = arrayList.size()-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if( arrayList.get(j) > arrayList.get(j+1) ){
                    Collections.swap(arrayList, j, j+1);
                }
            }
        }
    }

    public ArrayList<Integer> postArray(){
        return arrayList;
    }
}
