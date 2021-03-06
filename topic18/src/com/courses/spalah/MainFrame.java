package com.courses.spalah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Денис on 4/18/16.
 */
public class MainFrame extends JFrame {
    private JPanel mainScreen;
    private static MainFrame mainFrame;
    private RandomColor randomColor;
    private volatile ArrayList<Circle> container;
    private Random size;

    public MainFrame(String s) {
        super(s);
        mainScreen = new JPanel();
        add(mainScreen);
        mainScreen.setVisible(true);
        panelClickListener();
        randomColor = new RandomColor();
        container = new ArrayList<>();
        size = new Random();
    }

    public static void main(String[] args) {
        mainFrame = new MainFrame("Circles");
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.play();
    }

    private void play() {
        Graphics graphics = getGraphics();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (Circle circle : container) {
                        circle.draw(graphics);
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    graphics.clearRect(0, 0, 800, 600);
                }
            }
        }).start();
    }

    private void panelClickListener() {
        mainScreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int x = e.getX();
                int y = e.getY();
                int diameter = size.nextInt(121) + 30;
                Color color = randomColor.getRandomColor();
                if (container.size() < 20) {
                    Circle circle = new Circle(x - diameter / 2, y, diameter, color);
                    container.add(circle);
                }
            }
        });
    }
}
