package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.logging.Level;

public class App3 {
    public static  void  main(String[] args){
        final JFrame frame = new JFrame("Новое окно");
        frame.setSize (500, 500);//размер окна
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        JTextField textField = new   JTextField("Поле для ввода");
        JList list = new JList();
        JTextArea fileInfo = new JTextArea();
        JButton show = new JButton("Show");
        show.addActionListener(l->{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int i = fileChooser.showOpenDialog(null);
            if(i == JFileChooser.APPROVE_OPTION){
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());


            }
        });
        JButton showList = new JButton("Show List");
        showList.addActionListener(l->{
            String path = textField.getText();
            File file = new File(path);
            if (file.isDirectory()){
                String[] files = file.list();
                list.setListData(files);

            }
        });

        JButton showInfo = new JButton("Show Info");
        showInfo.addActionListener(l->{
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


        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(textField, BorderLayout.CENTER);
        topPanel.add(show,BorderLayout.EAST);
        topPanel.add(showList,BorderLayout.SOUTH);

        JPanel leftPanel = new JPanel(new BorderLayout());

        leftPanel.add(topPanel, BorderLayout.NORTH);
        leftPanel.add(list, BorderLayout.CENTER);
        leftPanel.add(showInfo,BorderLayout.SOUTH);


        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                leftPanel,
                fileInfo
        );
        splitPane.setDividerLocation(250);

        frame.add(splitPane);

        frame.setVisible(true);

    }
}
