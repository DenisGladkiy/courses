import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by Денис on 3/27/16.
 */
public class AddRowFrame extends JFrame {
    private JTextField manufacturer, model, year, vin, price, name, surname, phone;
    private JTextArea description;
    private JButton add;

    public AddRowFrame(String s) {
        super(s);
        gui();
    }

    private void gui() {
        setLayout(new FlowLayout());
        manufacturer = new JTextField("manufacturer      ");
        model = new JTextField("model              ");
        year = new JTextField("year                ");
        vin = new JTextField("vin                      ");
        price = new JTextField("price                     ");
        name = new JTextField("name              ");
        surname = new JTextField("surname        ");
        phone = new JTextField("phone              ");
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
                String[] advert = readForm();
                System.out.println("add button");
                System.out.println(Arrays.asList(advert));
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

    private String[] readForm() {
        String[] formText = null;
        try {
            String man = read(manufacturer);
            String mod = read(model);
            String y = read(year);
            String v = read(vin);
            String pr = read(price);
            String n = read(name);
            String s = read(surname);
            String ph = read(phone);
            String desc = read(description);
            formText = new String[]{man, mod, y, v, pr, n, s, ph, desc};
            this.dispose();
            this.setVisible(false);
        }catch (IncorrectInputException e){
            JOptionPane.showMessageDialog(null, "Please, check input data");
            e.printStackTrace();
        }
        return formText;
    }

    private String read(JTextComponent textComponent) throws IncorrectInputException {
        String text = textComponent.getText();
        System.out.println(text);
        if (Character.isLetter(text.charAt(0)) || Character.isDigit(text.charAt(0))) {
            return text;
        } else {
            throw new IncorrectInputException("wrong input");
        }
    }

}
