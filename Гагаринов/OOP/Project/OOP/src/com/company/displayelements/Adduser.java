package com.company.displayelements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Adduser extends JDialog {
    public void clearTextField(JTextField textField){
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.isControlDown()){
                    textField.setText("");
                }

            }
        });
    }
    Adduser(Orderframe orderframe){
        super(orderframe,"Добавить пользователя",true);
        setSize (500, 175);
        setLocationRelativeTo(null);

        Database database = new Database();

        String[] roles = {"DIRECTOR","RECEPTION","MASTER"};
        JPanel label = new JPanel(new BorderLayout());
        JPanel input = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new BorderLayout());



        label.setLayout(new BoxLayout(label,BoxLayout.Y_AXIS));
        label.add(Box.createHorizontalStrut(2));
        label.add(new JLabel("Логин пользователя"));
        label.add(Box.createHorizontalStrut(2));
        label.add(new JLabel("Пароль пользователя"));
        label.add(Box.createHorizontalStrut(2));
        label.add(new JLabel("ФИО пользователя"));
        label.add(Box.createHorizontalStrut(2));
        label.add(new JLabel("Роль пользователя"));

        JComboBox role = new JComboBox(roles);
        JTextField login = new JTextField("Логин");
        clearTextField(login);
        JTextField password = new JTextField("Пароль");
        clearTextField(password);
        JTextField fio = new JTextField("ФИО");
        clearTextField(fio);

        input.setLayout(new BoxLayout(input,BoxLayout.Y_AXIS));

        input.add(login);
        input.add(password);
        input.add(fio);
        input.add(role);

        input.add(inputPanel);
// role.getSelectedIndex()+1 ID Роли
        JButton fff = new JButton("Добавить");
        fff.addActionListener(l->{
            database.saveUser(login.getText(),password.getText(),fio.getText(),role.getSelectedItem().toString());
            System.out.println("Данные записаны");
            dispose();
        });
        add(label,BorderLayout.WEST);
        add(input,BorderLayout.EAST);
        add(fff, BorderLayout.SOUTH);
    }
}
