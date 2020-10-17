package com.company.projectApp3;

import javax.swing.*;
import java.io.File;

public class ShowInfo extends JButton {
    public ShowInfo(JList list,JTextField textField,JTextArea fileInfo){
        super("Show Info");

        addActionListener(l->{
            if(list.getSelectedIndex()> -1){
                list.getSelectedValue();
                File selctFile = new File(textField.getText(),list.getSelectedValue() + "");
                String fileInf = "";
                fileInf += "Имя: " + selctFile.getName() + "\n";
                fileInf += "Полный путь: " + selctFile.getAbsolutePath() + "\n";
                fileInf += "Размер: " + selctFile.length() + "\n";
                fileInfo.setText(fileInf);
            }
        });
    }
}
