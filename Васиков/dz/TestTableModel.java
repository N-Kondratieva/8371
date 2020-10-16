package com.company;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.io.File;

public class TestTableModel extends AbstractTableModel
{
    private static final String[] columnLabels = {"№", "name", "ext", "size"};
    private static final Class<?>[] columnClasses ={Integer.class, String.class, String.class, String.class};
    private File[] files = {};
    private static String getExtension(File file)
    {
        return file.isDirectory() ? "-" : file.getName().substring(file.getName().indexOf("."));
    }
    public void setFiles(File[] files)
    {
        this.files = files;
        fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return files.length;
    }

    @Override
    public int getColumnCount() {
        return columnLabels.length;
    }

    @Override
    public String getColumnName(int i) {
        return columnLabels[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return columnClasses[i];
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int y, int x) {
        File currentFile = files[y];
        switch(x)
        {
            case 0:
                return y+1;
            case 1:
                return currentFile.getName();
            case 2:
                return getExtension(currentFile);
            case 3:
                return currentFile.getFreeSpace();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {

    }

}
