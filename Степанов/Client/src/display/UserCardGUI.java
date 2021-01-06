package display;

import models.User;

import javax.swing.*;
import java.awt.*;

public class UserCardGUI extends JPanel {

    public JLabel fullname = new JLabel("    ");
    public JLabel email = new JLabel("");
    public JButton info = new JButton("More info");

    public UserCardGUI(User user, EventsGUI eventsGUI){
        this.setSize(900, 100);
        this.setLayout(new BorderLayout(100,0));
        Dimension dimension = new Dimension(100,100);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(new Color(0xC3FFAB));

        String fullname_temp = fullname.getText();

        email.setText(user.email);
        fullname.setText(fullname_temp +
                user.firstName + " " +user.lastName);

        email.setSize(dimension);
        email.setAlignmentX(JButton.CENTER_ALIGNMENT);
        email.setFont(new Font("Montserrat", Font.BOLD, 14));
        fullname.setMinimumSize(dimension);
        fullname.setAlignmentX(JButton.CENTER_ALIGNMENT);
        fullname.setFont(new Font("Montserrat", Font.BOLD, 14));

        info.addActionListener(l -> {
            UserInfoGUI UI = new UserInfoGUI(user, eventsGUI);
            UI.setVisible(true);
            UI.setResizable(false);
        });

        this.add(fullname, BorderLayout.WEST);
        this.add(email, BorderLayout.CENTER);
        this.add(info, BorderLayout.EAST);
    }
}
