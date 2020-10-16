package ru.eltech.table;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

class TestTableModel extends AbstractTableModel {
    private ArrayList<Object[]> list;

//    private Object[][] data = new Object[][]{
//            {"Вася", 8832, 6},
//            {"Миша", 8832, 6},
//            {"Костя", 8832, 6},
//            {"Дима", 8832, 6},
//    };

    public TestTableModel(ArrayList<Object[]> list) {
        this.list = list;
    }


    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "№";
            case 1:
                return "ФИО";
            case 2:
                return "Группа";
            case 3:
                return "Курс";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
//                return Integer.class;
            case 2:
//                return Integer.class;
            case 3:
                return Integer.class;
//            case 1:
//                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            default:
                return list.get(rowIndex)[columnIndex - 1];
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Object[] objects = list.get(rowIndex);
        switch (columnIndex) {
            case 1:
                objects[1] = aValue;
                break;
            case 2:
                objects[2] = aValue;
                break;
            case 3:
                objects[3] = aValue;
                break;
        }
    }
}
