package com.rxn1d.courses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Denis on 16.02.2016.
 */
public class CalcHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == CalculatorUI.one){
            CalculatorUI.setTextField("1");
        }
        if(e.getSource() == CalculatorUI.two) {
            CalculatorUI.setTextField("2");
        }
        if(e.getSource() == CalculatorUI.three) {
            CalculatorUI.setTextField("3");
        }
        if(e.getSource() == CalculatorUI.four) {
            CalculatorUI.setTextField("4");
        }
        if(e.getSource() == CalculatorUI.five) {
            CalculatorUI.setTextField("5");
        }
        if(e.getSource() == CalculatorUI.six) {
            CalculatorUI.setTextField("6");
        }
        if(e.getSource() == CalculatorUI.seven) {
            CalculatorUI.setTextField("7");
        }
        if(e.getSource() == CalculatorUI.eight) {
            CalculatorUI.setTextField("8");
        }
        if(e.getSource() == CalculatorUI.nine) {
            CalculatorUI.setTextField("9");
        }
        if(e.getSource() == CalculatorUI.zero) {
            CalculatorUI.setTextField("0");
        }
        if(e.getSource() == CalculatorUI.equals) {
            String[] text = CalculatorUI.getText();
            if(text.length == 3) {
                calculateAndShow(text);
            }
        }
        if(e.getSource() == CalculatorUI.plus) {
            String[] text = CalculatorUI.getText();
            if(text.length > 1) {
                calculateAndShow(text);
                CalculatorUI.setTextField(" + ");
            }else{
                CalculatorUI.setTextField(" + ");
            }
        }
        if(e.getSource() == CalculatorUI.minus) {
            String[] text = CalculatorUI.getText();
            if(text.length > 1) {
                calculateAndShow(text);
                CalculatorUI.setTextField(" - ");
            }else{
                CalculatorUI.setTextField(" - ");
            }
        }
        if(e.getSource() == CalculatorUI.multiply) {
            String[] text = CalculatorUI.getText();
            if(text.length > 1) {
                calculateAndShow(text);
                CalculatorUI.setTextField(" * ");
            }else{
                CalculatorUI.setTextField(" * ");
            }
        }
        if(e.getSource() == CalculatorUI.divide) {
            String[] text = CalculatorUI.getText();
            if(text.length > 1) {
                calculateAndShow(text);
                CalculatorUI.setTextField(" / ");
            }else{
                CalculatorUI.setTextField(" / ");
            }
        }
        if(e.getSource() == CalculatorUI.clear) {
            CalculatorUI.clearText();
        }
    }

    private void calculateAndShow(String[] expression){
        double result = 0;
        double a = Double.valueOf(expression[0]);
        double b = Double.valueOf(expression[2]);
        switch (expression[1]){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }
        CalculatorUI.clearText();
        CalculatorUI.setTextField(String.valueOf(result));
        //return result;
    }
}
