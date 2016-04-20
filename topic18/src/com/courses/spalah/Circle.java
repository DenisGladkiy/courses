package com.courses.spalah;

import java.awt.*;

/**
 * Created by Денис on 4/18/16.
 */
public class Circle extends Shape {
    int x;
    int y;
    int size;

    public Circle(int color, int direction, int size, int speed) {
        super(color, direction, size, speed);
    }

    public Circle(int x, int y, int size){
        super();
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics g) {
        g.drawOval(x, y, size, size);
        g.setColor(Color.RED);
        g.fillOval(x, y, size, size);
    }
}
