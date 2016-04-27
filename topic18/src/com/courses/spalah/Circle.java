package com.courses.spalah;

import java.awt.*;

/**
 * Created by Денис on 4/18/16.
 */
public class Circle extends Shape {
    private int x;
    private int y;
    private int size;
    private Color color;
    RandomColor randomColor;
    RandomDirection randomDirection;

    public Circle(int x, int y, int size, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        startColorThread();
        startDirectionThread();
    }

    private void startColorThread() {
        randomColor = new RandomColor();
        Thread colorThread = new Thread(randomColor);
        colorThread.start();
    }

    private void startDirectionThread() {
        randomDirection = new RandomDirection(x, y, size);
        Thread directionThread = new Thread(randomDirection);
        directionThread.start();
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
        color = randomColor.getRandomColor();
        x = randomDirection.getX();
        y = randomDirection.getY();
    }
}
