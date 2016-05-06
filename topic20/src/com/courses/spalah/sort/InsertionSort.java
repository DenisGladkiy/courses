package com.courses.spalah.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Denis on 01.05.2016.
 */
public class InsertionSort extends Sort {

    public InsertionSort(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {

        for (int i = 1; i < arrayList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (arrayList.get(j) < arrayList.get(j - 1)) {
                    Collections.swap(arrayList, j, j - 1);
                }
                sleep(2);
                while (pause) {
                    sleep(100);
                }
            }
        }
    }
}
