package com.courses.spalah;

import java.awt.*;
import java.util.Random;

/**
 * Created by Денис on 4/18/16.
 */
public class Circle extends Shape {
    private int x;
    private int y;
    private int deltaX;
    private int deltaY;
    private int size;
    private Color color;
    private Random random;

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
        x = x + deltaX;
        y = y + deltaY;
        if(0 > x || (800-size) < x){
            deltaX = deltaX * -1;
        }
        if(0 > y || (600-size) < y){
            deltaY = deltaY * -1;
        }
        draw(g);
    }

    private void initializeDirection(){
        do {
            deltaX = random.nextInt(9) - 4;
            deltaY = random.nextInt(9) - 4;
        }while (deltaX == 4 && deltaY == 4);
    }
}
