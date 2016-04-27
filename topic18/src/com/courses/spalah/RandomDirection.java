package com.courses.spalah;

import java.util.Random;

/**
 * Created by Денис on 4/27/16.
 */
public class RandomDirection implements Runnable {
    private int x;
    private int y;
    int circleSize;
    private int deltaX;
    private int deltaY;
    private Random random;

    public RandomDirection(int x, int y, int circleSize) {
        this.x = x;
        this.y = y;
        this.circleSize = circleSize;
        initializeDirection();
    }

    @Override
    public void run() {
        while (true) {
            x = x + deltaX;
            y = y + deltaY;
            if (0 > x || (800 - circleSize) < x) {
                deltaX = deltaX * -1;
            }
            if (0 > y || (600 - circleSize) < y) {
                deltaY = deltaY * -1;
            }
            sleep(10);
        }
    }

    private void initializeDirection() {
        random = new Random();
        do {
            deltaX = random.nextInt(9) - 4;
            deltaY = random.nextInt(9) - 4;
        } while (deltaX == 4 && deltaY == 4);
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
