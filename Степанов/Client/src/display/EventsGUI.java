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
    private JPanel contentPanel = new JPanel(new FlowLayout());

    private JPanel newEventPanel = new JPanel(new BorderLayout(100,0));
    private JLabel newEventLabel1 = new JLabel("");
    private JLabel newEventLabel2 = new JLabel("");
    private JButton newEventButton = new JButton();
    private JLabel newEventLabel = new JLabel("+ New event");

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

        newEventLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
        newEventButton.add(newEventLabel);
        newEventButton.addActionListener(l -> {
            NewEventGUI NE = new NewEventGUI(this,action);
            NE.setVisible(true);
            NE.setResizable(false);

        });

        newEventPanel.add(newEventLabel1, BorderLayout.WEST);
        newEventPanel.add(newEventLabel2, BorderLayout.CENTER);
        newEventPanel.add(newEventButton, BorderLayout.EAST);

        eventsPanel.add(newEventPanel);

        container.add(eventsPanel, BorderLayout.CENTER);
        container.add(Title, BorderLayout.NORTH);
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setVerticalAlignment(JLabel.CENTER);
        container.add(LabelEast, BorderLayout.EAST);
        container.add(LabelWest, BorderLayout.WEST);
        container.add(LabelSouth, BorderLayout.SOUTH);


    }
}
