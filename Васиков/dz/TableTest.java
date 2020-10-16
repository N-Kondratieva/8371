package ru.eltech.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class TableTest {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Таблица");
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ArrayList<Object[]> list = new ArrayList<>();
        JTable table = new JTable();
        TestTableModel dataModel = new TestTableModel(list);
        table.setModel(dataModel);

        table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setText(value + "");
                if (row % 2 == 0) {
                    setForeground(Color.GREEN);
                } else {
                    setForeground(Color.BLACK);
                }
                if (isSelected) {
                    setBackground(Color.ORANGE);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });

        table.setDefaultRenderer(String.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setText(value + "");
                setForeground(Color.RED);
                return this;
            }
        });

//        table.setDefaultRenderer(Integer.class, new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                setText(value + "");
//                if (row % 2 == 0) {
//                    setForeground(Color.GREEN);
//                    setBackground(Color.ORANGE);
//                } else {
//                    setForeground(Color.BLACK);
//                }
//                return this;
//            }
//        });


        JButton button = new JButton("Add");
        button.addActionListener(l -> {
            list.add(new Object[]{"Вася", 8832, 6});
            dataModel.fireTableDataChanged();
        });

        frame.add(button, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
