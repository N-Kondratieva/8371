package com.company.table;


import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.net.FileNameMap;
import java.util.Optional;

class TableModel extends AbstractTableModel {
    private File[] data = new File[0];
    private String ext(File file){
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1){
            return "";
        }
        return name.substring(lastIndexOf);
    }

    @Override
    public int getRowCount() {
        return data.length;
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
                return "Name";
            case 2:
                return "Ext";
            case 3:
                return "Size";
            default:
                return "";
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        File file =  data[rowIndex];
        switch (columnIndex){
            case 0:
                return rowIndex +1;
            case 1:
                return file.getName();
            case 2:
                return ext(file);
            case 3:
                return file.length();
            default:
                return "";
        }
    }

    public void setData(File[] data) {
        this.data = data;
        fireTableDataChanged();
    }

    public File getFile(int getIndeOf) {
        return data[getIndeOf];
    }
}
