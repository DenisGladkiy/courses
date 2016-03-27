import dao.DaoFactory;
import dao.OwnerDao;
import entity.OwnerEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Денис on 3/24/16.
 */
public class MainFrame extends JFrame {
    private JButton add, find, delete;
    private JTextField manufacturer, model, yearFrom, yearTo, priceFrom, priceTo;
    private JLabel year, price;
    private JTable table;

    public static void main(String[] args) {
        //Connection con = null;
        MainFrame mf = new MainFrame("Car Marketplace");
        mf.setVisible(true);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setSize(600, 400);
    }

    public MainFrame(String s){
        super(s);
        gui();
    }

    private void gui() {
        setLayout(new FlowLayout());
        add = new JButton("Add car");
        buttonAddListener();
        find = new JButton("Find car");
        delete = new JButton("Delete selected");
        manufacturer = new JTextField("Manufacturer");
        model = new JTextField("     Model     ");
        yearFrom = new JTextField("From");
        yearTo = new JTextField("   To   ");
        priceFrom = new JTextField("From");
        priceTo = new JTextField("   To   ");
        year = new JLabel("Year");
        price = new JLabel("Price");
        table = createTable();
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
        add(table);
        add(delete);

    }

    private JTable createTable() {
        Object[][] tableData = null;
        String[] columnNames = {"Manufacturer", "Model", "Year", "VIN", "Description", "Price", "Contact"};
        TableRow tableRow = new TableRow();
        tableData = tableRow.getAllRows();
        table = new JTable(tableData, columnNames);
        table.setAutoscrolls(true);
        return table;
    }

    private void buttonAddListener(){
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddRowFrame addRowFrame = new AddRowFrame("Add advert");
                addRowFrame.setVisible(true);
                addRowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addRowFrame.setSize(400, 160);
            }
        });
    }
}
