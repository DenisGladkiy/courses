package com.courses.spalah.gui;

import com.courses.spalah.exception.IncorrectInputException;
import com.courses.spalah.stuff.InsertData;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Денис on 3/27/16.
 */
public class AddRowFrame extends JFrame {
    private JTextArea description, manufacturer, model, year, vin, price, name, surname, phone;
    private JButton add;

    public AddRowFrame(String s) {
        super(s);
        gui();
    }

    private void gui() {
        setLayout(new FlowLayout());
        manufacturer = new JTextArea("manufacturer", 1, 8);
        model = new JTextArea("model", 1, 8);
        year = new JTextArea("year", 1, 8);
        vin = new JTextArea("vin", 1, 8);
        price = new JTextArea("price", 1, 8);
        name = new JTextArea("name", 1, 8);
        surname = new JTextArea("surname", 1, 8);
        phone = new JTextArea("phone", 1, 8);
        description = new JTextArea("description", 2, 32);
        add = new JButton("Add advert");
        buttonAddListener();
        add(manufacturer);
        add(model);
        add(year);
        add(vin);
        add(price);
        add(name);
        add(surname);
        add(phone);
        add(description);
        add(add);
    }

    private void buttonAddListener() {
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[][] advert = readForm();
                try {
                    InsertData.insertData(advert);
                    MainFrame mainFrame = MainFrame.getInstance();
                    mainFrame.refreshTable();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private String[][] readForm() {
        String[][] formText = null;
        try {
            String man = readString(manufacturer);
            String mod = readString(model);
            String y = readInt(year);
            String v = readString(vin);
            String pr = readInt(price);
            String n = readString(name);
            String s = readString(surname);
            String ph = readInt(phone);
            String desc = readString(description);
            formText = new String[][]{{pr}, {man, mod, y, v, desc}, {n, s, ph}};
            this.dispose();
            this.setVisible(false);
        } catch (IncorrectInputException e) {
            JOptionPane.showMessageDialog(null, "Please, check input data");
            e.printStackTrace();
        }
        return formText;
    }

    private String readString(JTextComponent textComponent) throws IncorrectInputException {
        String text = textComponent.getText();
        if (Character.isLetter(text.charAt(0)) || Character.isDigit(text.charAt(0))) {
            return text;
        } else {
            throw new IncorrectInputException("wrong input");
        }
    }

    private String readInt(JTextComponent textComponent) throws IncorrectInputException {
        String text = textComponent.getText();
        if (Character.isDigit(text.charAt(0))) {
            return text;
        } else {
            throw new IncorrectInputException("wrong input");
        }
    }
}
