package display;

import db.JDBCPostgreSQL;
import models.Event;
import models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import static db.JDBCPostgreSQL.current_user;

public class EventDetailGUI extends JDialog {

    private JLabel description = new JLabel();

    private JLabel Users = new JLabel("Users");
    private JLabel DescriptionTitle = new JLabel("Event description");

    private JLabel LabelSouth = new JLabel("");
    private JLabel LabelWest = new JLabel("");
    private JLabel LabelEast = new JLabel("");

    private JPanel usersPanel = new JPanel(new GridLayout(15, 1, 10, 10));
    private JPanel contentPanel = new JPanel(new GridLayout(4,1,0,0));

    private JLabel W = new JLabel("");
    private JLabel S = new JLabel("");
    private JPanel joinPannel = new JPanel(new BorderLayout(10,10));
    private JLabel joinLabel = new JLabel("Join event");
    private JButton joinButton = new JButton();

    public EventDetailGUI(Event event, EventsGUI eventsGUI){
        super(eventsGUI, "Event", true);
        this.setBounds(800, 100, 1000, 1000);

        JDBCPostgreSQL db = new JDBCPostgreSQL();
        ArrayList<User> users = db.getUsers(event.getId());

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(50, 10));

        for (int i = 0; i<users.size(); i++){
            UserCardGUI userCard = new UserCardGUI(users.get(i), this);
            usersPanel.add(userCard);
        }

        usersPanel.setPreferredSize(new Dimension( 700,800));
        JScrollPane scrollFrame = new JScrollPane(usersPanel);
        usersPanel.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension( 800,300));

        Users.setFont(new Font("Montserrat", Font.BOLD, 25));
        Users.setHorizontalAlignment(JLabel.CENTER);
        Users.setVerticalAlignment(JLabel.CENTER);


        description.setFont(new Font("Montserrat", Font.PLAIN, 20));
        description.setText("<html>Address: "+ event.address+"<br>" + "Members required: " + event.membersRequired + "<br>" + event.description+ "</html>");

        joinButton.add(joinLabel);
        joinButton.addActionListener(l->{
            db.AddEventsUsersRelation(event.getId(),current_user.getId());
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
        joinLabel.setFont(new Font("Montserrat", Font.BOLD, 25));
        joinLabel.setAlignmentX(JButton.CENTER_ALIGNMENT);

        joinPannel.add(joinButton, BorderLayout.CENTER);

        contentPanel.add(scrollFrame);
        contentPanel.add(description);
        contentPanel.add(joinPannel);

        container.add(Users, BorderLayout.NORTH);
        container.add(LabelEast, BorderLayout.EAST);
        container.add(LabelSouth, BorderLayout.SOUTH);
        container.add(LabelWest, BorderLayout.WEST);
        container.add(contentPanel, BorderLayout.CENTER);

    }
}
