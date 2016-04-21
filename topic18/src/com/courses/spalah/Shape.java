package com.courses.spalah;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Денис on 4/18/16.
 */
public class Shape extends JComponent {
    private int x;
    private int y;
    private int size;
    private Color color;

    public Shape(){}

    public Shape(int x, int y, int size, Color color){
        this.color = color;
        this.x = x;
        this.size = size;
        this.y = y;
    }
}
