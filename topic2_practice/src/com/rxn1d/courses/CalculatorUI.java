package com.rxn1d.courses;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Created by Denis on 16.02.2016.
 */
public class CalculatorUI extends JFrame {

    static JTextField textField;
    static JButton plus, minus, divide, multiply, equals, clear;
    static JButton one, two, three, four, five, six, seven, eight, nine, zero;
    ArrayList<JButton> keyboard = new ArrayList<>();
    CalcHandler handler = new CalcHandler();


    public CalculatorUI(String s){
        super(s);
        setLayout(new FlowLayout());
        textField = new JTextField(15);
        add(textField);
        one = new JButton("1");
        keyboard.add(one);
        two = new JButton("2");
        keyboard.add(two);
        three = new JButton("3");
        keyboard.add(three);
        plus = new JButton("+");
        keyboard.add(plus);
        four = new JButton("4");
        keyboard.add(four);
        five = new JButton("5");
        keyboard.add(five);
        six = new JButton("6");
        keyboard.add(six);
        minus = new JButton("- ");
        keyboard.add(minus);
        seven = new JButton("7");
        keyboard.add(seven);
        eight = new JButton("8");
        keyboard.add(eight);
        nine = new JButton("9");
        keyboard.add(nine);
        multiply = new JButton("*");
        keyboard.add(multiply);
        clear = new JButton("C");
        keyboard.add(clear);
        zero = new JButton("0");
        keyboard.add(zero);
        equals = new JButton("=");
        keyboard.add(equals);
        divide = new JButton("/ ");
        keyboard.add(divide);
        showKeys();
        addListenerToButtons();
    }

    public static  void main(String[] args) {
        CalculatorUI gui = new CalculatorUI("Calculator");
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(220,200);

    }

    private void addListenerToButtons() {
        for(JButton b : keyboard){
            b.addActionListener(handler);
        }
    }

    private void showKeys() {
        for(JButton b : keyboard){
            add(b);
        }
    }

    public static void setTextField(String s){
        textField.setText(textField.getText() + s);
    }

    public static String[] getText(){
        String[] input;
        input = textField.getText().split(" ");
        return input;
    }

    public static void clearText(){
        textField.setText("");
    }
}
