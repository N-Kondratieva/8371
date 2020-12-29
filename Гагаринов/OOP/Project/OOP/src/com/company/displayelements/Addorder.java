package com.company.displayelements;

import com.company.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

public class Addorder extends JDialog {

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

    public Addorder(Orderframe orderframe){
        super(orderframe,"Добавить заказ",true);
        setSize (500, 200);
        setLocationRelativeTo(null);

        Date date = new Date();

        Database database = new Database();

        String[] service  = {"Сведение","Запись","Мастеринг"};
        ArrayList<User> users = database.getUsers();
        String[] empl = new String[users.size()];
        for (int i = 0;i< users.size();i++){
            empl[i] = users.get(i).getFio();
        }


        JButton openFile = new JButton("Открыть файл");
        JTextField path = new JTextField("Путь",10);
        openFile.addActionListener(l->{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int i = fileChooser.showOpenDialog(null);
            if(i == JFileChooser.APPROVE_OPTION){
                path.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        JPanel label = new JPanel(new BorderLayout());
        JPanel input = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new BorderLayout());



        label.setLayout(new BoxLayout(label,BoxLayout.Y_AXIS));
        label.add(new JLabel("Услуга"));
        label.add(Box.createHorizontalStrut(2));
        label.add(new JLabel("Сотрудник"));
        label.add(Box.createHorizontalStrut(2));
        label.add(new JLabel("ФИО покупателя"));
        label.add(Box.createHorizontalStrut(2));
        label.add(new JLabel("E-mail покупателя"));
        label.add(Box.createHorizontalStrut(2));
        label.add(new JLabel("Продолжительность материала"));
        label.add(Box.createHorizontalStrut(2));
        label.add(new JLabel("Входной материал"));
        JComboBox serv = new JComboBox(service);
        JComboBox employee = new JComboBox(empl);
        JTextField name = new JTextField("Введите имя");
        clearTextField(name);
        JTextField email = new JTextField("Введите E-mail");
        clearTextField(email);
        JTextField duration = new JTextField("Продолжительность материала");
        clearTextField(duration);

        input.setLayout(new BoxLayout(input,BoxLayout.Y_AXIS));
        input.add(serv);
        input.add(employee);
        input.add(name);
        input.add(email);
        input.add(duration);

        inputPanel.add(openFile,BorderLayout.WEST);
        inputPanel.add(path,BorderLayout.EAST);

        input.add(inputPanel);


        JButton fff = new JButton("Добавить");
        fff.addActionListener(l->{
            int cost = 0;
            switch (serv.getSelectedItem().toString()){
                case "Сведение" :
                    cost = Integer.parseInt(duration.getText())  * 10;
                    break;
                case "Запись" :
                    cost = Integer.parseInt(duration.getText())  * 6;
                    break;
                case "Мастеринг" :
                    cost = Integer.parseInt(duration.getText())  * 15;
                    break;
                default:
                    break;
            }
            database.saveOrder(serv.getSelectedItem().toString(),
                    employee.getSelectedItem().toString(),
                    name.getText(),
                    email.getText(),
                    Integer.parseInt(duration.getText()), cost,date.getTime(),date.getTime() + 432000000,
                    true,path.getText());

            System.out.println("Данные записаны");
            serv.setSelectedIndex(0);
            employee.setSelectedIndex(0);
            name.setText("Введите имя");
            email.setText("Введите e-mail");
            duration.setText("Введите продолжительность");
            path.setText("Путь");

            dispose();

        });
        add(label,BorderLayout.WEST);
        add(input,BorderLayout.EAST);
        add(fff, BorderLayout.SOUTH);
    }
}
