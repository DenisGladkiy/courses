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
            formText = new String[][]{{pr},{man, mod, y, v, desc},{n, s, ph}};
            this.dispose();
            this.setVisible(false);
        }catch (IncorrectInputException e){
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
