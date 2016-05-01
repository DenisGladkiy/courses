package com.courses.spalah.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Денис on 4/28/16.
 */
public class RandomArray {
    ArrayList arrayList;

    public static void main(String[] args) {
        RandomArray array = new RandomArray();
    }

    public RandomArray(){
        arrayList = new ArrayList();
        fillArray();
    }

    private void fillArray() {
        for(int i = 1; i < 101; i++){
            arrayList.add(i);
        }
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
    }
}
