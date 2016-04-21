package com.courses.spalah;

import java.awt.*;
import java.util.Random;

/**
 * Created by Денис on 4/20/16.
 */
public class RandomColor {

    public Color getRandomColor(){
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        Color color = new Color(r, g, b);
        return color;
    }

}
