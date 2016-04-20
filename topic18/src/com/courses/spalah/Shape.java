package com.courses.spalah;

import javax.swing.*;

/**
 * Created by Денис on 4/18/16.
 */
public class Shape extends JComponent {
    int color;
    int direction;
    int size;
    int speed;

    public Shape(){}

    public Shape(int color, int direction, int size, int speed){
        this.color = color;
        this.direction = direction;
        this.size = size;
        this.speed = speed;
    }
}
