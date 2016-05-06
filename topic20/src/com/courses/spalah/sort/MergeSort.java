package com.courses.spalah.sort;

import java.util.ArrayList;

/**
 * Created by Denis on 01.05.2016.
 */
public class MergeSort extends Sort {
    private ArrayList<Integer> tempArray;
    private int length;

    public MergeSort(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
        this.length = arrayList.size();
    }

    @Override
    public void run() {
        doSort(0, length - 1);
    }

    private void doSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            doSort(low, middle);
            doSort(middle + 1, high);
            mergeParts(low, middle, high);
        }
    }

    private void mergeParts(int low, int middle, int high) {
        tempArray = new ArrayList<>(arrayList);
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (tempArray.get(i) <= tempArray.get(j)) {
                arrayList.set(k, tempArray.get(i));
                i++;
            } else {
                arrayList.set(k, tempArray.get(j));
                j++;
            }
            k++;
            sleep(2);
            waitPause();
        }
        while (i <= middle) {
            arrayList.set(k, tempArray.get(i));
            k++;
            i++;
            sleep(2);
            waitPause();
        }
    }

    private void waitPause() {
        while (pause) {
            sleep(100);
        }
    }
}
