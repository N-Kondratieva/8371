package display;

import models.Event;
import db.JDBCPostgreSQL;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventsGUI extends JDialog {

    private JLabel Title = new JLabel("Events");
    private JLabel LabelSouth = new JLabel("");
    private JLabel LabelWest = new JLabel("");
    private JLabel LabelEast = new JLabel("");

    private JPanel eventsPanel = new JPanel(new GridLayout(10, 1, 10, 10));

    public EventsGUI(String action, ActionsGUI actionsGUI) {
        super(actionsGUI, "Events", true);
        this.setBounds(800, 100, 1000, 1000);
        this.setResizable(false);

        JDBCPostgreSQL db = new JDBCPostgreSQL();
        ArrayList<Event> events = db.getEvents(action);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(50,10));

        Title.setSize(1000, 30);
        Title.setFont(new Font("Montserrat", Font.BOLD, 25));

        if (events.size() == 0) {
            Title.setText("Whoops... there is no any events yet");

        } else {
            container.add(Title, BorderLayout.NORTH);
            for (int i = 0; i < events.size(); i++) {
                EventCardGUI event = new EventCardGUI(events.get(i), this);
                eventsPanel.add(event);
            }
        }

        container.add(eventsPanel, BorderLayout.CENTER);
        container.add(Title, BorderLayout.NORTH);
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setVerticalAlignment(JLabel.CENTER);
        container.add(LabelEast, BorderLayout.EAST);
        container.add(LabelWest, BorderLayout.WEST);
        container.add(LabelSouth, BorderLayout.SOUTH);


    }
}
