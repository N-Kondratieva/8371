package com.company.projectApp3;

import javax.swing.*;
import java.io.File;

public class ShowList extends JButton {
    public ShowList(JTextField textField,JList list){
        super("Show List");

        addActionListener(l->{
            String path = textField.getText();
            File file = new File(path);
            if (file.isDirectory()){
                String[] files = file.list();
                list.setListData(files);

            }
        });
    }

}
