package com.courses.spalah.sort;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Denis on 01.05.2016.
 */
public class MainFrame extends JFrame {
    static Thread BubbleThread;
    static Thread InsertionThread;
    static Thread QuickThread;
    static Thread MergeThread;
    static Thread BogoThread;
    static Thread mainThread;
    static ArrayList<Integer> arrayList;
    static ArrayList<Integer> arrayList1;
    static ArrayList<Integer> arrayList2;
    static ArrayList<Integer> arrayList3;
    static ArrayList<Integer> arrayList4;
    BubbleSort bubbleSort;
    InsertionSort insertionSort;
    QuickSort quickSort;
    MergeSort mergeSort;
    BogoSort bogoSort;

    public MainFrame(String s) {
        super(s);
        init();
        MainThread mThread = new MainThread();
        mainThread = new Thread(mThread);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("Sort");
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 620);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainThread.start();
        BubbleThread.start();
        InsertionThread.start();
        QuickThread.start();
        MergeThread.start();
        BogoThread.start();
    }

    private void init(){
        RandomArray randomArray = new RandomArray();
        arrayList = randomArray.getArray();
        arrayList1 = randomArray.getArray();
        arrayList2 = randomArray.getArray();
        arrayList3 = randomArray.getArray();
        arrayList4 = randomArray.getArray();
        bubbleSort = new BubbleSort(arrayList);
        BubbleThread = new Thread(bubbleSort);
        insertionSort = new InsertionSort(arrayList1);
        InsertionThread = new Thread(insertionSort);
        quickSort = new QuickSort(arrayList2);
        QuickThread = new Thread(quickSort);
        mergeSort = new MergeSort(arrayList3);
        MergeThread = new Thread(mergeSort);
        bogoSort = new BogoSort(arrayList4);
        BogoThread = new Thread(bogoSort);
    }

    private class MainThread implements Runnable{
        @Override
        public void run() {
            arrayList = bubbleSort.postArray();
            arrayList1 = insertionSort.postArray();
            arrayList2 = quickSort.postArray();
            arrayList3 = mergeSort.postArray();
            arrayList4 = bogoSort.postArray();
            ArrayPainter arrayPainter = new ArrayPainter(arrayList);
            ArrayPainter arrayPainter1 = new ArrayPainter(arrayList1);
            ArrayPainter arrayPainter2 = new ArrayPainter(arrayList2);
            ArrayPainter arrayPainter3 = new ArrayPainter(arrayList3);
            ArrayPainter arrayPainter4 = new ArrayPainter(arrayList4);
            add(arrayPainter);
            add(arrayPainter1);
            add(arrayPainter2);
            add(arrayPainter3);
            add(arrayPainter4);
            arrayPainter.setPreferredSize(new Dimension(750, 110));
            arrayPainter1.setPreferredSize(new Dimension(750, 110));
            arrayPainter2.setPreferredSize(new Dimension(750, 110));
            arrayPainter3.setPreferredSize(new Dimension(750, 110));
            arrayPainter4.setPreferredSize(new Dimension(750, 110));
            while(BubbleThread.isAlive() || InsertionThread.isAlive()) {
                arrayPainter.setArrayList(arrayList);
                arrayPainter1.setArrayList(arrayList1);
                arrayPainter2.setArrayList(arrayList2);
                arrayPainter3.setArrayList(arrayList3);
                arrayPainter4.setArrayList(arrayList4);
                repaint();
            }
        }
    }


}
