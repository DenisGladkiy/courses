package com.courses.spalah.gui;

import com.courses.spalah.entity.AdvertEntity;
import com.courses.spalah.exception.IncorrectInputException;
import com.courses.spalah.hibernate.HibernateUtil;
import com.courses.spalah.stuff.SortRows;
import com.courses.spalah.stuff.TableRows;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Денис on 3/24/16.
 */
public class MainFrame extends JFrame {
    private JButton add, find, delete;
    private JTextArea manufacturer, model, yearFrom, yearTo, priceFrom, priceTo;
    private JLabel year, price;
    private JTable table;
    private JScrollPane scrollPane;
    private static volatile MainFrame mainFrame = new MainFrame("Car Marketplace");
    private int selectedRow = -1;
    Session session;


    public static void main(String[] args) {
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
    }

    public MainFrame(String s) {
        super(s);
        gui();
    }

    private void gui() {
        setLayout(new FlowLayout());
        add = new JButton("Add car");
        buttonAddListener();
        find = new JButton("Find car");
        buttonFindListener();
        delete = new JButton("Delete selected");
        buttonDeleteListener();
        manufacturer = new JTextArea("Manufacturer", 1, 6);
        model = new JTextArea("Model", 1, 6);
        yearFrom = new JTextArea("From", 1, 4);
        yearTo = new JTextArea("To", 1, 4);
        priceFrom = new JTextArea("From", 1, 4);
        priceTo = new JTextArea("To", 1, 4);
        year = new JLabel("Year");
        price = new JLabel("Price");
        table = createTable(new TableRows().getAllRows());
        Dimension d = new Dimension(550, 290);
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(d);
        add(add);
        add(find);
        add(manufacturer);
        add(model);
        add(year);
        add(yearFrom);
        add(yearTo);
        add(price);
        add(priceFrom);
        add(priceTo);
        add(scrollPane);
        add(delete);
    }

    private JTable createTable(String[][] tableData) {
        String[] columnNames = {"Manufacturer", "Model", "Year", "VIN", "Description", "Price", "Contact"};
        TableModel tableModel = new DefaultTableModel(tableData, columnNames);
        table = new JTable(tableModel);
        tableListener();
        return table;
    }

    private void tableListener() {
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedRow = table.rowAtPoint(evt.getPoint());
            }
        });
    }

    private void buttonFindListener() {
        find.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] selection = readSelection();
                SortRows sortRows = new SortRows();
                String[][] selectedData = sortRows.sortTable(selection);
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);
                table = createTable(selectedData);
                scrollPane.getViewport().add(table);
            }
        });
    }

    private void buttonAddListener() {
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddRowFrame addRowFrame = new AddRowFrame("Add advert");
                addRowFrame.setVisible(true);
                addRowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addRowFrame.setSize(400, 160);
            }
        });
    }

    private void buttonDeleteListener() {
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow >= 0) {
                    session = HibernateUtil.getSessionFactory().openSession();
                    String hql = makeDeleteStatement();
                    Query query = session.createQuery(hql);
                    query.executeUpdate();
                    session.close();
                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                    tableModel.setRowCount(0);
                    table = createTable(new TableRows().getAllRows());
                    scrollPane.getViewport().add(table);
                }
            }
        });
    }

    public static MainFrame getInstance() {
        if (mainFrame == null) {
            mainFrame = new MainFrame("Car marketplace");
        }
        return mainFrame;
    }

    public void refreshTable() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        remove(delete);
        table = createTable(new TableRows().getAllRows());
        scrollPane.getViewport().add(table);
        scrollPane.revalidate();
        scrollPane.repaint();
        add(delete);
    }

    private String makeDeleteStatement() {
        String manufacturer = table.getValueAt(selectedRow, 0).toString();
        String model = table.getValueAt(selectedRow, 1).toString();
        String year = table.getValueAt(selectedRow, 2).toString();
        String vin = table.getValueAt(selectedRow, 3).toString();
        String description = table.getValueAt(selectedRow, 4).toString();
        String price = table.getValueAt(selectedRow, 5).toString();
        String hql_select = "from AdvertEntity WHERE price = " + Integer.parseInt(price) + " and car.year = " +
                Integer.parseInt(year) + " and car.manufacturer = '" + manufacturer + "' and car.model = '" + model
                + "' and car.vin = '" + vin + "' and car.description = '" + description + "'";
        Query query = session.createQuery(hql_select);
        List<AdvertEntity> adverts = query.list();
        int ownerId = adverts.get(0).getCar().getOwner().getIdowner();
        String deleteOwner = "delete from OwnerEntity where idowner = " + ownerId;
        return deleteOwner;
    }

    private String readString(JTextComponent textComponent) throws IncorrectInputException {
        String text = textComponent.getText();
        if (!text.equals("")) {
            if (Character.isLetter(text.charAt(0)) || Character.isDigit(text.charAt(0))) {
                return text;
            } else {
                throw new IncorrectInputException("wrong input");
            }
        } else {
            return text;
        }
    }

    private String[] readSelection() {
        String[] selection = null;
        try {
            String man = readString(manufacturer);
            String mod = readString(model);
            String yFrom = readString(yearFrom);
            String yTo = readString(yearTo);
            String pFrom = readString(priceFrom);
            String pTo = readString(priceTo);
            selection = new String[]{man, mod, yFrom, yTo, pFrom, pTo};
        } catch (IncorrectInputException e1) {
            e1.printStackTrace();
        }
        return selection;
    }
}
