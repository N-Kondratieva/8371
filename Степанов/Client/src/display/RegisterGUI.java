package display;

import db.JDBCPostgreSQL;
import models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class RegisterGUI extends JDialog {

    private JLabel Title = new JLabel("Enter your information");
    private JLabel S = new JLabel(" ");
    private JLabel E = new JLabel("");
    private JLabel W = new JLabel("");

    private JLabel firstNameLabel = new JLabel("First name: ");
    private JLabel lastNameLabel = new JLabel("Last name: ");
    private JLabel phoneNumberLabel = new JLabel("Phone number: ");
    private JLabel birthDateLabel = new JLabel("Birth date: ");
    private JLabel aboutMeLabel = new JLabel("About me: ");
    private JLabel emailLabel = new JLabel("Email: ");
    private JLabel passwordLabel = new JLabel("Password: ");

    private JTextField firstNameField = new JTextField();
    private JTextField lastNameField = new JTextField();
    private JTextField phoneNumberField = new JTextField();
    private JTextField birthDateField = new JTextField();
    private JTextField aboutMeField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField passwordField = new JTextField();

    private JPanel contentPanel = new JPanel(new GridLayout(15, 1, 10, 10));

    private JButton submitButton = new JButton("Submit");

    public RegisterGUI(StartGUI startGUI) {
        super(startGUI, "Register", true);
        this.setBounds(800, 100, 1000, 800);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(20, 10));

        contentPanel.add(firstNameLabel);
        contentPanel.add(firstNameField);

        contentPanel.add(lastNameLabel);
        contentPanel.add(lastNameField);

        contentPanel.add(phoneNumberLabel);
        contentPanel.add(phoneNumberField);

        contentPanel.add(birthDateLabel);
        contentPanel.add(birthDateField);

        contentPanel.add(aboutMeLabel);
        contentPanel.add(aboutMeField);

        contentPanel.add(emailLabel);
        contentPanel.add(emailField);

        contentPanel.add(passwordLabel);
        contentPanel.add(passwordField);

        contentPanel.add(submitButton);

        Title.setSize(1000, 30);
        Title.setFont(new Font("Montserrat", Font.BOLD, 25));
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setVerticalAlignment(JLabel.CENTER);

        submitButton.addActionListener(l -> {
            if((emailField.getText()!=null)&&(firstNameField.getText()!=null)&&(lastNameField.getText()!=null)&&(passwordField.getText()!=null)){
                JDBCPostgreSQL db = new JDBCPostgreSQL();
                db.createUser(firstNameField.getText(),
                        lastNameField.getText(),
                        emailField.getText(),
                        passwordField.getText(),
                        phoneNumberField.getText(),
                        birthDateField.getText(),
                        aboutMeField.getText());
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }


        });

        container.add(contentPanel, BorderLayout.CENTER);
        container.add(Title, BorderLayout.NORTH);
        container.add(S, BorderLayout.SOUTH);
        container.add(W, BorderLayout.WEST);
        container.add(E, BorderLayout.EAST);
    }
}

