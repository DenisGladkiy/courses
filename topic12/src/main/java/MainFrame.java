import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Денис on 3/24/16.
 */
public class MainFrame extends JFrame {
    private JButton add, find, delete;
    private JTextField manufacturer, model, yearFrom, yearTo, priceFrom, priceTo;
    private JLabel year, price;
    private JTable table;
    private JScrollPane scrollPane;
    private static volatile MainFrame mainFrame = new MainFrame("Car Marketplace");

    public static void main(String[] args) {
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
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

    private JTable createTable() {
        String[] columnNames = {"Manufacturer", "Model", "Year", "VIN", "Description", "Price", "Contact"};
        TableRows tableRows = new TableRows();
        String[][] tableData = tableRows.getAllRows();
        TableModel tableModel = new DefaultTableModel(tableData, columnNames);
        table = new JTable(tableModel);
        tableListener();
        return table;
    }

    private void tableListener(){
        table.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                System.out.println("row "+row);
                int col = table.columnAtPoint(evt.getPoint());
                System.out.println("col "+col);
            }
        });
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

    public static MainFrame getInstance() {
        if (mainFrame == null ) {
            mainFrame = new MainFrame("Car marketplace");
        }
        return mainFrame;
    }

    public void refreshTable(){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        remove(delete);
        table = createTable();
        scrollPane.getViewport().add(table);
        scrollPane.revalidate();
        scrollPane.repaint();
        add(delete);
    }
}
