package com.courses.spalah.sort;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Denis on 01.05.2016.
 */
public class ArrayPainter extends JPanel {
    ArrayList<Integer> arrayList;

    public ArrayPainter(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public void paint(Graphics g) {
        int x = 5;
        int y = 60;
        int width = 6;
        g.setColor(Color.BLUE);
        if (arrayList != null) {
            for (Integer element : arrayList) {
                int height = element / 2;
                g.fillRect(x, y - height, width, height);
                x += width + 1;
            }
        }
    }

    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }
}
