package display;

import db.JDBCPostgreSQL;
import models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class LoginGUI extends JDialog {
    private JLabel Title = new JLabel("Sign in");
    private JLabel S = new JLabel(" ");
    private JLabel E = new JLabel("");
    private JLabel W = new JLabel("");


    private JLabel emailLabel = new JLabel("Email: ");
    private JLabel passwordLabel = new JLabel("Password: ");

    private JTextField emailField = new JTextField();
    private JTextField passwordField = new JTextField();

    private JPanel contentPanel = new JPanel(new GridLayout(15, 1, 10, 10));

    private JButton submitButton = new JButton("Submit");

    public LoginGUI(StartGUI startGUI) {
        super(startGUI, "Register", true);
        this.setBounds(800, 100, 1000, 800);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(20, 10));

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
            if ((emailField.getText() != null) && (passwordField.getText() != null)) {
                JDBCPostgreSQL db = new JDBCPostgreSQL();
                User user = db.getUser(emailField.getText(), passwordField.getText());
                if (user!=null) {
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                    CategoriesGUI CG = new CategoriesGUI();
                    CG.setVisible(true);
                    CG.setResizable(false);
                } else {
                    JLabel error = new JLabel("Whoops... Wrong email or password");
                    ErrorGUI EG = new ErrorGUI(error,this);
                    EG.setVisible(true);
                    EG.setResizable(false);
                }

            }


        });

        container.add(contentPanel, BorderLayout.CENTER);
        container.add(Title, BorderLayout.NORTH);
        container.add(S, BorderLayout.SOUTH);
        container.add(W, BorderLayout.WEST);
        container.add(E, BorderLayout.EAST);
    }
}
