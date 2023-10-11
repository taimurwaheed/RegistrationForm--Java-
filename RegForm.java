import javax.swing.*;
import java.awt.event.*;

class Form extends JFrame implements ActionListener {

    JTextField TF1, TF2, TF3;
    JLabel l1, l2, l3, l4, l5, heading;
    JComboBox<String> day, month, year;
    JButton submit, reset;
    JLabel msg;
    JTextArea screen;
    JCheckBox terms;
    JRadioButton RB1, RB2;

    Form() {

        JFrame f = new JFrame("Registration Form");

        heading = new JLabel("Registration Form");
        heading.setBounds(250, 10, 300, 30);
        heading.setForeground(java.awt.Color.BLUE);
        heading.setOpaque(true);
        heading.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));

        l1 = new JLabel("Name");
        l1.setBounds(50, 50, 100, 30);  

        TF1 = new JTextField();
        TF1.setBounds(150, 50, 200, 20);

        l2 = new JLabel("Mobile");
        l2.setBounds(50, 100, 100, 30);

        TF2 = new JTextField();
        TF2.setBounds(150, 100, 200, 20);

        l3 = new JLabel("Gender");
        l3.setBounds(50, 150, 100, 30);

        RB1 = new JRadioButton("Male");
        RB1.setBounds(150, 150, 80, 30);

        RB2 = new JRadioButton("Female");
        RB2.setBounds(250, 150, 80, 30);

        l4 = new JLabel("DOB");
        l4.setBounds(50, 200, 100, 30);

        String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] months = {"Jan", "Feb", "March", "April", "May", "June", "July", "August", "Sep", "Oct", "Nov", "Dec"};
        String[] years = {"2000", "2001", "2002", "2003", "2004", "2005"};

        day = new JComboBox<>(days);
        day.setBounds(150, 200, 50, 20);

        month = new JComboBox<>(months);
        month.setBounds(200, 200, 80, 20);

        year = new JComboBox<>(years);
        year.setBounds(290, 200, 60, 20);

        l5 = new JLabel("Address");
        l5.setBounds(50, 250, 100, 30);

        TF3 = new JTextField();
        TF3.setBounds(150, 250, 200, 100);

        terms = new JCheckBox("Accept Terms & Conditions");
        terms.setBounds(150, 350, 250, 30);

        submit = new JButton("Submit");
        submit.setBounds(130, 400, 100, 30);
        submit.addActionListener(this);

        reset = new JButton("Reset");
        reset.setBounds(260, 400, 100, 30);
        reset.addActionListener(this);

        msg = new JLabel("");
        msg.setBounds(400, 25, 250, 50);

        screen = new JTextArea("");
        screen.setBounds(400, 60, 250, 300);

        ButtonGroup BG = new ButtonGroup();
        BG.add(RB1);
        BG.add(RB2);

        f.add(heading);
        f.add(l1);
        f.add(TF1);
        f.add(l2);
        f.add(TF2);
        f.add(l3);
        f.add(RB1);
        f.add(RB2);
        f.add(l4);
        f.add(l5);
        f.add(TF3);
        f.add(day);
        f.add(month);
        f.add(year);
        f.add(terms);
        f.add(submit);
        f.add(reset);
        f.add(msg);
        f.add(screen);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            // Handle Submit button click
            if (terms.isSelected()) {
                msg.setText("Registration Successfully..");

                String name = TF1.getText();
                String mobile = TF2.getText();
                String address = TF3.getText();

                String gender = "Female";
                if (RB1.isSelected()) {
                    gender = "Male";
                }

                String dob = day.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem();
                screen.setText("Name: " + name + "\n" + "Mobile: " + mobile + "\n" + "Gender: " + gender + "\n" + "DOB: " + dob
                        + "\n" + "Address: " + address);
            } else {
                msg.setText("Accept Terms and Conditions To Submit");
                screen.setText("");
            }
        } else if (e.getSource() == reset) {
            // Handle Reset button click
            TF1.setText("");
            TF2.setText("");
            TF3.setText("");
            RB1.setSelected(false);
            RB2.setSelected(false);
            day.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            screen.setText("");
            terms.setSelected(false);
            msg.setText(" ");
        }
    }
}

public class RegForm {

    public static void main(String[] args) {
        new Form();
    }
}
