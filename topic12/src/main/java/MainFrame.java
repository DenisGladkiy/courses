import javax.swing.*;
import java.awt.*;

/**
 * Created by Денис on 3/24/16.
 */
public class MainFrame extends JFrame {
    private JButton add, find, delete;
    private JTextField manufacturer, model, yearFrom, yearTo, priceFrom, priceTo;
    private JLabel year, price;
    private JTable table;

    public static void main(String[] args) {
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
        table = new JTable(18, 7);
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
}
