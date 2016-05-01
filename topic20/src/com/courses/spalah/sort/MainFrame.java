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
    static Thread mainThread;
    static ArrayList<Integer> arrayList;
    static ArrayList<Integer> arrayList1;
    BubbleSort bubbleSort;
    InsertionSort insertionSort;

    public MainFrame(String s) {
        super(s);
        init();
        MainThread mThread = new MainThread();
        mainThread = new Thread(mThread);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("Sort");
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 600);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainThread.start();
        BubbleThread.start();
        InsertionThread.start();

    }

    private void init(){
        RandomArray randomArray = new RandomArray();
        arrayList = randomArray.getArray();
        arrayList1 = randomArray.getArray();
        bubbleSort = new BubbleSort(arrayList);
        BubbleThread = new Thread(bubbleSort);
        insertionSort = new InsertionSort(arrayList1);
        InsertionThread = new Thread(insertionSort);
    }

    private class MainThread implements Runnable{
        @Override
        public void run() {
            arrayList = bubbleSort.postArray();
            arrayList1 = insertionSort.postArray();
            ArrayPainter arrayPainter1 = new ArrayPainter(arrayList);
            ArrayPainter arrayPainter2 = new ArrayPainter(arrayList1);
            add(arrayPainter1);
            add(arrayPainter2);
            arrayPainter1.setPreferredSize(new Dimension(750, 110));
            arrayPainter2.setPreferredSize(new Dimension(750, 110));
            while(BubbleThread.isAlive()) {
                arrayPainter1.setArrayList(arrayList);
                arrayPainter2.setArrayList(arrayList1);
                repaint();
            }
        }
    }


}
