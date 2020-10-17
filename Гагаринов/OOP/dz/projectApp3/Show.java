package com.company.projectApp3;

import javax.swing.*;

public class Show extends JButton {
    public Show(JTextField textField){
        super("Show");


        addActionListener(l->{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int i = fileChooser.showOpenDialog(null);
            if(i == JFileChooser.APPROVE_OPTION){
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
    }
}
