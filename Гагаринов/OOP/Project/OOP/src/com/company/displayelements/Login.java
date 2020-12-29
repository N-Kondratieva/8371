package com.company.displayelements;

import com.company.Role;
import com.company.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Login extends JDialog {
    private final JLabel username = new JLabel("Логин");
    private final JLabel password = new JLabel("Пароль");

    private final JTextField usernameIn = new JTextField(15);
    private final JPasswordField passwordIn = new JPasswordField();

    private final JButton login = new JButton("Войти");
    private final JButton cancel = new JButton("Выйти");

    private final JLabel status = new JLabel(" ");



    public Login(Orderframe orderframe) {
        super(orderframe, "Вход в систему", false);

        Database database = new Database();




        JPanel p3 = new JPanel(new GridLayout(2, 1));
        p3.add(username);
        p3.add(password);

        JPanel p4 = new JPanel(new GridLayout(2, 1));
        p4.add(usernameIn);
        p4.add(passwordIn);

        JPanel p1 = new JPanel();
        p1.add(p3);
        p1.add(p4);

        JPanel p2 = new JPanel();
        p2.add(login);
        p2.add(cancel);

        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(p2, BorderLayout.CENTER);
        p5.add(status, BorderLayout.NORTH);
        status.setForeground(Color.RED);
        status.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p5, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<User> users = database.getUsers();
                for (int i = 0;i< users.size();i++){
                    if (Arrays.equals(users.get(i).getPassword().toCharArray(), passwordIn.getPassword())
                            && users.get(i).getLogin().equals(usernameIn.getText())) {

                        orderframe.employee.setText("Сотрудник: " + users.get(i).getFio());

                        switch (users.get(i).getRole()){
                            case "DIRECTOR":
                                orderframe.tabs.setEnabledAt(1,true);
                                break;
                            case "RECEPTION":

                                orderframe.addUserButton.setVisible(false);
                                orderframe.tabs.setSelectedIndex(0);
                                orderframe.tabs.setEnabledAt(1,false);
                                break;
                            case "MASTER":
                                orderframe.addOrderButton.setVisible(false);
                                orderframe.addUserButton.setVisible(false);
                                orderframe.tabs.setSelectedIndex(0);
                                orderframe.tabs.setEnabledAt(1,false);
                                break;
                            default: break;

                        }
                        orderframe.setVisible(true);
                        setVisible(false);
                        break;
                    } else {
                        status.setText("Неверный логин или пароль");
                    }
                }

            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                orderframe.dispose();
                System.exit(0);
            }
        });
    }
}
