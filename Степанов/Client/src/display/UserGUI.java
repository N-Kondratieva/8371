package display;

import models.User;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class UserGUI extends JFrame {
//    private JLabel id = new JLabel("id");
//    private JLabel fullName = new JLabel("full name");
//    private JLabel email = new JLabel("email");
//    private JLabel phoneNumber = new JLabel("phoneNumber");
//    private JLabel birthDate = new JLabel("birthDate");
//    private JTextField aboutMe = new JTextField("aboutMe");
//    private JLabel createdAt = new JLabel("createdAt");


    private JLabel info = new JLabel();

    public UserGUI(){
        super("User");
        this.setBounds(1100, 300, 400, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());


        container.add(info);
//        container.add(id);
//        container.add(fullName);
//        container.add(email);
//        container.add(phoneNumber);
//        container.add(birthDate);
//        container.add(aboutMe);
//        container.add(createdAt);

    }
}
