package com.company.displayelements;

import com.company.Order;
import com.company.Role;
import com.company.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Orderframe extends JFrame {
    public JLabel employee = new JLabel("");
    public JButton exit = new JButton("Выход");
    public JLabel role = new JLabel("");
    public JButton addUserButton = new JButton("Добавить пользователя");
    public JButton addOrderButton = new JButton("Добавить заказ");
    public JTabbedPane tabs = new JTabbedPane();
    public Orderframe() throws HeadlessException {
        super("Приложение учета");
        Addorder addOrder = new Addorder(this);
        Adduser adduser = new Adduser(this);
        TableModel tableModel = new TableModel();
        UserTableModel userTableModel = new UserTableModel();

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new BorderLayout());
        JTable table = new JTable(tableModel);
        JTable userTable = new JTable(userTableModel);

        addOrderButton.addActionListener(l->{
            addOrder.setVisible(true);
            TableModel tableModelUpdate = new TableModel();

            table.setModel(tableModelUpdate);
        });
        addUserButton.addActionListener(l->{
            adduser.setVisible(true);
            UserTableModel UserTableModelUpdate = new UserTableModel();
            userTable.setModel(UserTableModelUpdate);
        });
        tabs.addTab("Заказы",new JScrollPane(table));
        tabs.addTab("Пользователи",new JScrollPane(userTable));
        topPanel.add(employee, BorderLayout.WEST);
        topPanel.add(role, BorderLayout.EAST);
        mainPanel.add(tabs,BorderLayout.NORTH);
        rightPanel.add(exit,BorderLayout.SOUTH);

        buttonPanel.add(addOrderButton,BorderLayout.NORTH);
        buttonPanel.add(addUserButton,BorderLayout.SOUTH);
        rightPanel.add(buttonPanel,BorderLayout.NORTH);

        add(topPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);



    }
}
