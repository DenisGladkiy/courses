package com.courses.spalah.sort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    static Thread HeapThread;
    static Thread mainThread;
    JButton generate, start, pause, clear;
    JLabel initial, bubble, insertion, quick, merge, bogo, heap;
    ArrayList<Integer> initArrayList;
    ArrayList<Integer> arrayList;
    ArrayList<Integer> arrayList1;
    ArrayList<Integer> arrayList2;
    ArrayList<Integer> arrayList3;
    ArrayList<Integer> arrayList4;
    ArrayList<Integer> arrayList5;
    BubbleSort bubbleSort;
    InsertionSort insertionSort;
    QuickSort quickSort;
    MergeSort mergeSort;
    BogoSort bogoSort;
    HeapSort heapSort;
    Dimension arrayDim;
    ActionListener listener;
    ArrayPainter arrayPainter;
    ArrayPainter arrayPainter1;
    ArrayPainter arrayPainter2;
    ArrayPainter arrayPainter3;
    ArrayPainter arrayPainter4;
    ArrayPainter arrayPainter5;
    ArrayPainter initArrayPainter;
    RandomArray randomArray;

    public MainFrame(String s) {
        super(s);
        gui();
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("Sort");
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 750);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        MainThread mThread = new MainThread();
        mainThread = new Thread(mThread);
        initArrays();
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
        heapSort = new HeapSort(arrayList5);
        HeapThread = new Thread(heapSort);
        initArrayPainter.setArrayList(initArrayList);
        refreshArrays();
        repaint();
    }

    private void initActionListener() {
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == generate) {
                    init();
                }
                if (e.getSource() == start) {
                    if (mainThread != null && !mainThread.isAlive()) {
                        startThreads();
                    }
                }
                if (e.getSource() == pause) {
                    pauseThreads();
                }
                if (e.getSource() == clear) {
                    mainThread = null;
                    clearAll();
                    repaint();
                }
            }
        };
    }

    private void startThreads() {
        mainThread.start();
        BubbleThread.start();
        InsertionThread.start();
        QuickThread.start();
        MergeThread.start();
        BogoThread.start();
        HeapThread.start();
    }

    private void pauseThreads() {
        bogoSort.pause();
        bubbleSort.pause();
        heapSort.pause();
        insertionSort.pause();
        mergeSort.pause();
        quickSort.pause();
    }


    private void gui() {
        arrayDim = new Dimension(750, 60);
        initActionListener();
        initArrayPainter = new ArrayPainter(initArrayList);
        arrayPainter = new ArrayPainter(arrayList);
        arrayPainter1 = new ArrayPainter(arrayList1);
        arrayPainter2 = new ArrayPainter(arrayList2);
        arrayPainter3 = new ArrayPainter(arrayList3);
        arrayPainter4 = new ArrayPainter(arrayList4);
        arrayPainter5 = new ArrayPainter(arrayList5);
        initArrayPainter.setPreferredSize(arrayDim);
        arrayPainter.setPreferredSize(arrayDim);
        arrayPainter1.setPreferredSize(arrayDim);
        arrayPainter2.setPreferredSize(arrayDim);
        arrayPainter3.setPreferredSize(arrayDim);
        arrayPainter4.setPreferredSize(arrayDim);
        arrayPainter5.setPreferredSize(arrayDim);
        initial = new JLabel("Initial array");
        bubble = new JLabel("Bubble sort");
        insertion = new JLabel("Insertion sort");
        quick = new JLabel("Quick sort");
        merge = new JLabel("Merge sort");
        bogo = new JLabel("Bogosort");
        heap = new JLabel("Heap sort");
        generate = new JButton("Generate");
        generate.addActionListener(listener);
        start = new JButton("Start");
        start.addActionListener(listener);
        pause = new JButton("Pause");
        pause.addActionListener(listener);
        clear = new JButton("Clear");
        clear.addActionListener(listener);
        add(initial);
        add(initArrayPainter);
        add(bubble);
        add(arrayPainter);
        add(insertion);
        add(arrayPainter1);
        add(quick);
        add(arrayPainter2);
        add(merge);
        add(arrayPainter3);
        add(bogo);
        add(arrayPainter4);
        add(heap);
        add(arrayPainter5);
        add(generate);
        add(start);
        add(pause);
        add(clear);
    }

    private void initArrays() {
        randomArray = new RandomArray();
        initArrayList = randomArray.getArray();
        arrayList = randomArray.getArray();
        arrayList1 = randomArray.getArray();
        arrayList2 = randomArray.getArray();
        arrayList3 = randomArray.getArray();
        arrayList4 = randomArray.getArray();
        arrayList5 = randomArray.getArray();
    }

    private void refreshArrays() {
        arrayPainter.setArrayList(arrayList);
        arrayPainter1.setArrayList(arrayList1);
        arrayPainter2.setArrayList(arrayList2);
        arrayPainter3.setArrayList(arrayList3);
        arrayPainter4.setArrayList(arrayList4);
        arrayPainter5.setArrayList(arrayList5);
    }

    private void clearAll() {
        initArrayList = null;
        arrayList = null;
        arrayList1 = null;
        arrayList2 = null;
        arrayList3 = null;
        arrayList4 = null;
        arrayList5 = null;
        initArrayPainter.setArrayList(initArrayList);
        refreshArrays();
    }


    private class MainThread implements Runnable {
        @Override
        public void run() {

            arrayList = bubbleSort.postArray();
            arrayList1 = insertionSort.postArray();
            arrayList2 = quickSort.postArray();
            arrayList3 = mergeSort.postArray();
            arrayList4 = bogoSort.postArray();
            arrayList5 = heapSort.postArray();

            while (BubbleThread.isAlive() || InsertionThread.isAlive()) {
                refreshArrays();
                repaint();
            }
        }
    }
}
