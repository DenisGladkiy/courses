package com.courses.spalah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Денис on 4/18/16.
 */
public class MainFrame extends JFrame {
    private JPanel mainScreen;
    private static MainFrame mainFrame;

    public MainFrame(String s){
        super(s);
        mainScreen = new JPanel();
        add(mainScreen);
        mainScreen.setVisible(true);
        panelClickListener();
    }

    public static void main(String[] args) {
        mainFrame = new MainFrame("Circles");
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void panelClickListener(){
        mainScreen.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {}
                                        @Override
                                        public void mousePressed(MouseEvent e) {
                                            int x = e.getX();
                                            int y = e.getY();
                                            Graphics graphics = getGraphics();
                                            Circle circle = new Circle(x, y, 50);
                                            circle.draw(graphics);
                                        }
                                        @Override
                                        public void mouseReleased(MouseEvent e) {}
                                        @Override
                                        public void mouseEntered(MouseEvent e) {}
                                        @Override
                                        public void mouseExited(MouseEvent e) {}
                                    }
        );
    }
}
