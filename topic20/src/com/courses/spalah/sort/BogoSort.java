package com.courses.spalah.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Denis on 01.05.2016.
 */

public class BogoSort extends Sort {

    public BogoSort(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        while (!isSorted(arrayList)) {
            while (!pause)
                Collections.shuffle(arrayList);
        }
    }

    private boolean isSorted(ArrayList<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < arrayList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
