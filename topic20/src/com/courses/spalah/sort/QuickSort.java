package com.courses.spalah.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Denis on 01.05.2016.
 */
public class QuickSort implements Runnable {
    ArrayList<Integer> arrayList;

    public QuickSort(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        int startIndex = 0;
        int endIndex = arrayList.size() - 1;
        doSort(startIndex, endIndex);
    }

    private void doSort(int start, int end) {
        int i = start;
        int j = end;
        int pivot = arrayList.get(start + (end-start)/2);
        while (i <= j) {
            while (arrayList.get(i) < pivot) {
                i++;
                sleep(2);
            }
            while (arrayList.get(j) > pivot) {
                j--;
                sleep(2);
            }
            if (i <= j) {
                Collections.swap(arrayList, i, j);
                i++;
                j--;
            }
            sleep(2);
        }
        if (start < j)
            doSort(start, j);
        if (i < end)
            doSort(i, end);
        sleep(2);
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
