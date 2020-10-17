package com.company.projectApp3;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {



    public Frame() throws HeadlessException {
        super("Project");

        JTextField textField = new   JTextField("Поле для ввода");
        JList list = new JList();
        JTextArea fileInfo = new JTextArea();

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(textField, BorderLayout.CENTER);
        topPanel.add(new Show(textField),BorderLayout.EAST);
        topPanel.add(new ShowList(textField,list), BorderLayout.SOUTH);

        JPanel leftPanel = new JPanel(new BorderLayout());

        leftPanel.add(topPanel, BorderLayout.NORTH);
        leftPanel.add(list, BorderLayout.CENTER);
        leftPanel.add(new ShowInfo(list,textField,fileInfo),BorderLayout.SOUTH);


        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                leftPanel,
                fileInfo
        );
        splitPane.setDividerLocation(250);

        add(splitPane);



    }
}
