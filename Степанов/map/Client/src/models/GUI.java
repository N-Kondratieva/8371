package models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton button = new JButton("Press");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input:");
    private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Select that");
    private JCheckBox check = new JCheckBox("Check", false);
    private JButton[] myButtons = new JButton[9];
    private JPanel panel = new JPanel(new GridLayout(3, 3, 30, 30));

    public GUI() {
        super("Simple example");
        this.setBounds(600, 100, 1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
//        Container page = this.getContentPane();
        container.setLayout(new BorderLayout(100, 100));
//        page.setLayout(new BorderLayout());

        for (int i = 0; i < 9; i++) {
            myButtons[i] = new JButton(Integer.toString(i + 1));
            myButtons[i].setSize(50, 50);
            myButtons[i].addActionListener(new ButtonEventListener());

            panel.add(myButtons[i]);
        }
        container.add(panel, BorderLayout.CENTER);


//        container.add(label);
//        container.add(input);
//
//        ButtonGroup group = new ButtonGroup();
//        group.add(radio1);
//        group.add(radio2);
//        container.add(radio1);
//        radio1.setSelected(true);
//        container.add(radio2);
//        container.add(check);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "Detail of  " + "  category";
//            message += "Button was pressed\n";
//            message += "Text is "+ input.getText() + "\n";
//            message += (radio1.isSelected() ? "Radio1" : "Radio2") + " is selected!\n";
//            message += "Checkbox is " + ((check.isSelected()) ? "checked" : "unchecked");

            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }


    }
}
