package models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class ActionsGUI extends JFrame {

    private JLabel Title = new JLabel("Actions");
    private JLabel LabelSouth = new JLabel("");
    private JLabel LabelWest = new JLabel("");
    private JLabel LabelEast = new JLabel("");

    private JPanel actionsPanel = new JPanel(new GridLayout(6, 6, 20, 20));

    public ActionsGUI() {
        super("Actions");
        this.setBounds(800, 100, 1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDBCPostgreSQL db = new JDBCPostgreSQL();
        ArrayList<Action> actions = db.getActions("new_table");
//        System.out.println(actions.get(1).getTitle());

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(50, 50));

        JButton[] actionsButtons = new JButton[actions.size()];
        Dimension size = new Dimension(20,20);


        for (int i = 0; i < actions.size(); i++) {

            JLabel actionLabel = new JLabel(actions.get(i).getTitle());
            actionsButtons[i] = new JButton();

            actionsButtons[i].setSize(size);
            actionsButtons[i].setMinimumSize(size);
            actionsButtons[i].setMaximumSize(size);
            actionsButtons[i].setPreferredSize(size);
            actionLabel.setSize(size);
            actionLabel.setAlignmentX(JButton.CENTER_ALIGNMENT);
            actionLabel.setFont(new Font("Montserrat", Font.BOLD, 20));

            actionsButtons[i].add(actionLabel);
            actionsButtons[i].addActionListener(new ActionButtonEventListener());
            actionsPanel.add(actionsButtons[i]);
        }

        container.add(actionsPanel, BorderLayout.CENTER);

        Title.setSize(1000, 30);
        Title.setFont(new Font("Montserrat", Font.BOLD, 25));
        container.add(Title, BorderLayout.NORTH);
        container.add(LabelEast, BorderLayout.EAST);
        container.add(LabelSouth, BorderLayout.SOUTH);
        container.add(LabelWest, BorderLayout.WEST);
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setVerticalAlignment(JLabel.CENTER);

    }


    class ActionButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ActionsGUI AC = new ActionsGUI();
            AC.setVisible(true);
            AC.setResizable(false);
        }
    }

}
