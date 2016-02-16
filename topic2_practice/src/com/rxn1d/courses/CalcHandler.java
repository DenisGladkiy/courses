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
            CalculatorUI.setText("1");
        }
        if(e.getSource() == CalculatorUI.two) {
            CalculatorUI.setText("2");
        }
        if(e.getSource() == CalculatorUI.three) {
            CalculatorUI.setText("3");
        }
        if(e.getSource() == CalculatorUI.four) {
            CalculatorUI.setText("4");
        }
        if(e.getSource() == CalculatorUI.five) {
            CalculatorUI.setText("5");
        }
        if(e.getSource() == CalculatorUI.six) {
            CalculatorUI.setText("6");
        }
        if(e.getSource() == CalculatorUI.seven) {
            CalculatorUI.setText("7");
        }
        if(e.getSource() == CalculatorUI.eight) {
            CalculatorUI.setText("8");
        }
        if(e.getSource() == CalculatorUI.nine) {
            CalculatorUI.setText("9");
        }
        if(e.getSource() == CalculatorUI.zero) {
            CalculatorUI.setText("0");
        }
        if(e.getSource() == CalculatorUI.equals) {
            System.out.println(CalculatorUI.getText()[0]);
        }
    }
}
