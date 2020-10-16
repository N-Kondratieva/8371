package com.company;
import layout.TableLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import static layout.TableLayout.*;
public class Main {
    final private static String singleCordMask = "%d,%d";
    private static final JTextArea folderField = new JTextArea();
    private static final TestTableModel fileModel = new TestTableModel();
    final private static double [][] cellSizes = new double[][]{
            {.90,.10},
            {.10,.90}
    };
    private static String makeCordString(int x, int y)
    {
        return String.format(singleCordMask,x,y);
    }
    private static void changeCurrentFolder(String path)
    {
            File f = new File(path);
            if (f.exists() && f.isDirectory())
            {
                System.out.println("path valid");
                currentFolder = path;
                folderField.setText(path);
                fileModel.setFiles(f.listFiles());
                System.out.println("");
            }
            else {
                folderField.setText(currentFolder);
            }
    }
    private static String currentFolder = "/home/zloooy/";
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(600,500);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setLayout(new TableLayout(
                cellSizes
        ));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        folderField.setText(currentFolder);
        JTable fileTable = new JTable();
        changeCurrentFolder("/home/zloooy/");
        fileTable.setModel(fileModel);
        JButton updatePathButton = new JButton("FC");
        updatePathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("BTN pressed");
                changeCurrentFolder(folderField.getText());
            }
        });
        fileTable.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    String s = (String) value;
                    Color fColor = Color.green;
                    if (s.equals("-")){
                        fColor = Color.red;
                    }
                    setForeground(fColor);
                return this;
            }
        });
        mainFrame.add(folderField, "0,0");
        mainFrame.add(updatePathButton,"1,0");
        mainFrame.add(new JScrollPane(fileTable), "0,1, 1,1");
        mainFrame.setVisible(true);
    }
}
