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
    private JTextField manufacturer, model, year, vin, price, name, surname, phone;
    private JTextArea description;
    private JButton add;

    public AddRowFrame(String s){
        super(s);
        gui();
    }

    private void gui() {
        setLayout(new FlowLayout());
        manufacturer = new JTextField("   manufacturer   ");
        model = new JTextField("       model       ");
        year = new JTextField("        year        ");
        vin = new JTextField("           vin           ");
        price = new JTextField("           price          ");
        name = new JTextField("       name       ");
        surname = new JTextField("    surname    ");
        phone = new JTextField("       phone       ");
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

    private void buttonAddListener(){
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] advert = readForm();
                System.out.println("add button");
                System.out.println(advert[0]);


                try {
                    InsertData.insertData(advert);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private String[] readForm() {
        String[] formText = new String[9];
        formText[0] = read(manufacturer);

        return formText;
    }

    private String read(JTextComponent textComponent) {
        String text = textComponent.getText();
        System.out.println(text);
        if(!Character.isLetter(text.charAt(0))){
            JOptionPane.showMessageDialog(null, "Please, check input data");
            return null;
        }
        return text;
    }

}
