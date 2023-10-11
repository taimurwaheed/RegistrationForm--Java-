import java.awt.*;
import java.awt.event.*;

class Form extends Frame implements ActionListener {

    TextField TF;

    public Form() {
        Button b = new Button("Add your Name");
        b.setBounds(20, 50, 150, 40);
        add(b);
        b.addActionListener(this);

        TF = new TextField();
        TF.setBounds(20, 100, 250, 50);
        add(TF);

        setSize(300, 300);
        setTitle("Taimur's App");
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        TF.setText("This is my Event");
    }

    public static void main(String[] args) {
        new Form();
    }
}
