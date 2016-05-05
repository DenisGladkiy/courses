package com.courses.spalah.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Denis on 01.05.2016.
 */
public class HeapSort implements Runnable {
    ArrayList<Integer> arrayList;

    public HeapSort(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        heapSort(arrayList);
    }

    private void heapSort(ArrayList<Integer> list)
    {
        int i;
        int middle = list.size() / 2 - 1;

        for (i = middle; i >= 0; i--)
        {
            shiftDown(list, i, list.size());
        }

        for (i = list.size() - 1; i >= 1; i--)
        {
            Collections.swap(list, 0, i);
            shiftDown(list, 0, i);
        }
    }

    private void shiftDown(ArrayList<Integer> list, int i, int j)
    {
        boolean done = false;
        int maxChild;

        while ((i * 2 + 1 < j) && (!done))
        {
            if (i * 2 + 1 == j - 1) {
                maxChild = i * 2 + 1;
            }
            else if (list.get(i * 2 + 1) > list.get(i * 2 + 2)) {
                maxChild = i * 2 + 1;
            }
            else {
                maxChild = i * 2 + 2;
            }
            if (list.get(i) < list.get(maxChild))
            {
                Collections.swap(list, i, maxChild);
                i = maxChild;
            }
            else
            {
                done = true;
            }
            sleep(2);
        }
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
