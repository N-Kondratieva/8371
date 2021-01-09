package display;

import javax.swing.*;
import java.awt.*;

public class ErrorGUI extends JDialog {
    public ErrorGUI(JLabel errorLabel, JDialog jDialog){
        super(jDialog, "Error", true);
        this.setBounds(1000, 400, 600, 250);
        errorLabel.setFont(new Font("Montserrat", Font.BOLD,25));
        errorLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(errorLabel);
    }
}
