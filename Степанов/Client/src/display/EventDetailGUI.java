package display;

import models.Event;
import models.User;

import javax.swing.*;
import java.awt.*;

public class EventDetailGUI extends JDialog {

    private JLabel description = new JLabel();
    private JLabel address = new JLabel();

    private JLabel Users = new JLabel("Users");
    private JLabel LabelSouth = new JLabel("");
    private JLabel LabelWest = new JLabel("");
    private JLabel LabelEast = new JLabel("");

    private JPanel eventsPanel = new JPanel(new GridLayout(10, 1, 10, 10));

    public EventDetailGUI(Event event, EventsGUI eventsGUI){
        super(eventsGUI, "Event", true);
        this.setBounds(800, 100, 1000, 1000);

    }
}
