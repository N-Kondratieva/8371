package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class StartGUI extends JFrame {
    private JButton registerButton = new JButton();
    private JButton loginButton = new JButton();

    private JLabel Title1 = new JLabel("Register");
    private JLabel Title2 = new JLabel("Log in");

    private JLabel LabelSouth = new JLabel("");
    private JLabel LabelWest = new JLabel("");
    private JLabel LabelEast = new JLabel("");
    private JLabel HelloLabel = new JLabel("Hello! Sign in to the service!");
    private JPanel panel = new JPanel(new GridLayout(1,2, 30,20));

    public StartGUI(){
        super("Sign in");
        this.setBounds(1000, 400, 600, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout(50,50));

        registerButton.setSize(50,50);
        registerButton.addActionListener(l -> {
            RegisterGUI R = new RegisterGUI(this);
            R.setVisible(true);
            R.setResizable(false);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        });
        registerButton.add(Title1);
        Title1.setAlignmentX(JButton.CENTER_ALIGNMENT);
        Title1.setFont(new Font("Montserrat", Font.BOLD, 20));
        Title1.setSize(50,50);

        loginButton.setSize(50,50);
        loginButton.addActionListener(l -> {
            LoginGUI L = new LoginGUI(this);
            L.setVisible(true);
            L.setResizable(false);
        });
        loginButton.add(Title2);
        Title2.setAlignmentX(JButton.CENTER_ALIGNMENT);
        Title2.setFont(new Font("Montserrat", Font.BOLD, 20));
        Title2.setSize(50,50);

        panel.add(registerButton);
        panel.add(loginButton);

        HelloLabel.setFont(new Font("Montserrat", Font.BOLD, 25));
        HelloLabel.setHorizontalAlignment(JLabel.CENTER);

        container.add(panel, BorderLayout.CENTER);
        container.add(LabelSouth, BorderLayout.SOUTH);
        container.add(LabelWest, BorderLayout.WEST);
        container.add(LabelEast, BorderLayout.EAST);
        container.add(HelloLabel, BorderLayout.NORTH);

    }

}
