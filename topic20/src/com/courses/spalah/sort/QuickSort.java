package com.courses.spalah.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Denis on 01.05.2016.
 */
public class QuickSort extends Sort {
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
        int pivot = arrayList.get(start + (end - start) / 2);
        while (i <= j) {
            while (arrayList.get(i) < pivot) {
                i++;
                sleep(2);
                waitPause();
            }
            while (arrayList.get(j) > pivot) {
                j--;
                sleep(2);
                waitPause();
            }
            if (i <= j) {
                Collections.swap(arrayList, i, j);
                i++;
                j--;
            }
            sleep(2);
            waitPause();
        }
        if (start < j)
            doSort(start, j);
        if (i < end)
            doSort(i, end);
    }

    private void waitPause() {
        while (pause) {
            sleep(100);
        }
    }
}
