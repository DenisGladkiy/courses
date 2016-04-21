package com.courses.spalah;

import java.awt.*;
import java.util.Random;

/**
 * Created by Денис on 4/18/16.
 */
public class Circle extends Shape {
    int x;
    int y;
    int deltaX;
    int deltaY;
    int size;
    Color color;
    Random random;

    public Circle(int color, int direction, int size, int speed) {
        super(color, direction, size, speed);
    }

    public Circle(int x, int y, int size, Color color){
        super();
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        random = new Random();
        initializeDirection();
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void move(Graphics g){
        x = x - 2 + deltaX;
        y = y - 2 + deltaY;
        draw(g);
    }

    private void initializeDirection(){
        do {
            deltaX = random.nextInt(5);
            deltaY = random.nextInt(5);
        }while (deltaX == 2 && deltaY == 2);
    }
}
