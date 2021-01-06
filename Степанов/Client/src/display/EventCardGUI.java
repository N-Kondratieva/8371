package display;

import models.Event;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class EventCardGUI extends JPanel {
    public JLabel members = new JLabel("    ");
    public JLabel description = new JLabel("");
    public JButton info = new JButton("More info");

    public EventCardGUI(Event event, EventsGUI eventsGUI){
        this.setSize(900, 100);
        this.setLayout(new BorderLayout(100,0));
        Dimension dimension = new Dimension(100,100);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(new Color(0xECCE78));

        String members_temp = members.getText();

        members.setText(members_temp + event.membersRequired);
        description.setText(event.description);

        members.setMinimumSize(dimension);
        description.setSize(dimension);
        description.setAlignmentX(JButton.CENTER_ALIGNMENT);
        description.setFont(new Font("Montserrat", Font.BOLD, 14));
        members.setAlignmentX(JButton.CENTER_ALIGNMENT);
        members.setFont(new Font("Montserrat", Font.BOLD, 14));

        info.addActionListener(l -> {
            EventDetailGUI ED = new EventDetailGUI(event, eventsGUI);
            ED.setVisible(true);
            ED.setResizable(false);

        });

        this.add(members, BorderLayout.WEST);
        this.add(description, BorderLayout.CENTER);
        this.add(info, BorderLayout.EAST);
    }
}
