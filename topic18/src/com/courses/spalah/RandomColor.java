package com.courses.spalah;

import java.awt.*;
import java.util.Random;

/**
 * Created by Денис on 4/20/16.
 */
public class RandomColor implements Runnable {
    Color color;
    Random random;

    public RandomColor() {
        random = new Random();
        this.color = makeRandomColor();
    }

    @Override
    public void run() {
        while (true) {
            this.color = makeRandomColor();
            sleep(10);
        }
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Color makeRandomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        color = new Color(r, g, b);
        return color;
    }

    public Color getRandomColor() {
        return color;
    }
}
