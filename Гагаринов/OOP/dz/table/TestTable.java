package com.company.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class TestTable {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Окно");



        frame.setSize(600,600);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        TableModel model = new TableModel();

        JTextField textField = new   JTextField("Поле для ввода");

        JButton show = new JButton("Show");
        show.addActionListener(l->{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int i = fileChooser.showOpenDialog(null);
            if(i == JFileChooser.APPROVE_OPTION){
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                model.setData(fileChooser.getSelectedFile().listFiles());
            }
        });

        JTable table = new JTable(model);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()>1){
                    int selectedRow = table.getSelectedRow();
                    File file = model.getFile(selectedRow);

                    if (file.isDirectory()){
                        textField.setText(file.getAbsolutePath());
                        model.setData(file.listFiles());
                    }
                }
            }
        });
        table.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                String valueAt = (String) table.getValueAt(row,2);

                setText(value + "");

                switch (valueAt){
                    case ".exe":
                        setBackground(Color.ORANGE);
                        break;
                    case ".iso":
                        setBackground(Color.BLUE);
                        break;

                    case "":
                        setBackground(Color.YELLOW);
                        break;

                    default:
                        setBackground(Color.WHITE);
                }
                return this;
            }
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(textField, BorderLayout.CENTER);
        topPanel.add(show,BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(table,BorderLayout.CENTER);
        frame.setVisible(true);

    }
}
