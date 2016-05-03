package com.courses.spalah.sort;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Denis on 01.05.2016.
 */
public class ArrayPainter extends JPanel {
    ArrayList<Integer> arrayList;

    public ArrayPainter(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
    }

    public void paint(Graphics g){
        int x = 5;
        int y = 110;
        int width = 6;
        g.setColor(Color.BLUE);
        for(Integer element: arrayList) {
            g.fillRect(x, y - element, width, element);
            x += width + 1;
        }
    }

    public void setArrayList(ArrayList<Integer> arrayList){
        this.arrayList = arrayList;
    }


}
