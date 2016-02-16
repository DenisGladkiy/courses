package com.rxn1d.courses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by Denis on 16.02.2016.
 */
public class CalculatorUI extends JFrame {

    private JTextField textField;
    private JButton plus, minus, divide, multiply, equals;
    private JButton one, two, three, four, five, six, seven, eight, nine, zero;
    private JButton empty1, empty2;
    Handler handler = new Handler();

    public CalculatorUI(String s){
        super(s);
        setLayout(new FlowLayout());
        textField = new JTextField(15);
        add(textField);
        one = new JButton("1");
        add(one);
        two = new JButton("2");
        add(two);
        three = new JButton("3");
        add(three);
        plus = new JButton("+");
        add(plus);
        four = new JButton("4");
        add(four);
        five = new JButton("5");
        add(five);
        six = new JButton("6");
        add(six);
        minus = new JButton("- ");
        add(minus);
        seven = new JButton("7");
        add(seven);
        eight = new JButton("8");
        add(eight);
        nine = new JButton("9");
        add(nine);
        multiply = new JButton("*");
        add(multiply);
        empty1 = new JButton("  ");
        add(empty1);
        zero = new JButton("0");
        add(zero);
        equals = new JButton("=");
        add(equals);
        divide = new JButton("/ ");
        add(divide);
        one.addActionListener(handler);
        two.addActionListener(handler);

    }

    public static  void main(String[] args) {
        CalculatorUI gui = new CalculatorUI("Calculator");
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(220,200);

    }

    private class Handler implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

                if(e.getSource() == one){
                    System.out.println("One click");
                }
                if(e.getSource() == two) {
                    System.out.println("Two click");
                }

        }
    }





}
