package display;

import db.JDBCPostgreSQL;
import models.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

import static db.JDBCPostgreSQL.current_user;

public class NewEventGUI extends JDialog{
    private JLabel Title = new JLabel("Enter your Event information");
    private JLabel S = new JLabel("");
    private JLabel E = new JLabel("");
    private JLabel W = new JLabel("");

    private JLabel descriptionLabel = new JLabel("Description: ");
    private JLabel addressLabel = new JLabel("Address: ");
    private JLabel membersRequiredLabel = new JLabel("Members required: ");
    private JLabel dateLabel = new JLabel("Date: ");

    private JTextField descriptionField = new JTextField("");
    private JTextField addressField = new JTextField("");
    private JTextField membersRequiredField = new JTextField("");
    private JTextField dateField = new JTextField("");


    private JPanel contentPanel = new JPanel(new GridLayout(15, 1, 10, 10));

    private JButton submitButton = new JButton("Submit");

    public NewEventGUI(EventsGUI eventsGUI, String action_title) {
        super(eventsGUI, "New event", true);
        this.setBounds(800, 100, 1000, 800);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(20, 10));

        contentPanel.add(descriptionLabel);
        contentPanel.add(descriptionField);

        contentPanel.add(addressLabel);
        contentPanel.add(addressField);

        contentPanel.add(membersRequiredLabel);
        contentPanel.add(membersRequiredField);

        contentPanel.add(dateLabel);
        contentPanel.add(dateField);

        contentPanel.add(submitButton);

        Title.setSize(1000, 30);
        Title.setFont(new Font("Montserrat", Font.BOLD, 25));
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setVerticalAlignment(JLabel.CENTER);

        submitButton.addActionListener(l -> {
            if(descriptionField.getText()!=null){
                int i ;
                try {
                    i = Integer.parseInt(membersRequiredField.getText());
                }
                catch (NumberFormatException e)
                {
                    i = 0;
                }
                JDBCPostgreSQL db = new JDBCPostgreSQL();
                db.createEvent(current_user.getId(),descriptionField.getText(),
                        addressField.getText(),
                        i,
                        dateField.getText(),
                        action_title);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            } else {
                JLabel error = new JLabel("Please add description");
                ErrorGUI EG = new ErrorGUI(error,this);
                EG.setVisible(true);
                EG.setResizable(false);
            }
        });

        container.add(contentPanel, BorderLayout.CENTER);
        container.add(Title, BorderLayout.NORTH);
        container.add(S, BorderLayout.SOUTH);
        container.add(W, BorderLayout.WEST);
        container.add(E, BorderLayout.EAST);
    }
}
