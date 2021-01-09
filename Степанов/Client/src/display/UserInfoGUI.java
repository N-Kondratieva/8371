package display;

import models.User;

import javax.swing.*;
import java.awt.*;

public class UserInfoGUI extends JDialog {
    private JLabel info = new JLabel();

    private JLabel LabelSouth = new JLabel("");
    private JLabel LabelWest = new JLabel("");
    private JLabel LabelEast = new JLabel("");
    private JLabel UserInfo = new JLabel("      User Info");

    public UserInfoGUI(User user, EventDetailGUI eventDetailGUI) {
        super(eventDetailGUI, "User info", true);
        this.setBounds(1000, 400, 600, 250);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(40, 0));


        info.setText("<html>Name: " + user.firstName + "<br>" +
                "Last name: " + user.lastName + "<br>" +
                "Email: " + user.email + "<br>" +
                "Phone number: " + user.phoneNumber + "<br>" +
                "Birth date: " + user.birthDate + "<br>" +
                "About me: " + user.aboutMe + "</html>");
        info.setFont(new Font("Montserrat", Font.PLAIN, 15));
        UserInfo.setFont(new Font("Montserrat", Font.BOLD, 20));

        container.add(info, BorderLayout.CENTER);
        container.add(LabelSouth, BorderLayout.SOUTH);
        container.add(LabelWest, BorderLayout.WEST);
        container.add(LabelEast, BorderLayout.EAST);
        container.add(UserInfo, BorderLayout.NORTH);

    }
}
