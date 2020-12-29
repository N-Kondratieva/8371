package com.company.displayelements;

import com.company.Order;
import com.company.User;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class UserTableModel extends AbstractTableModel {
    Database database = new Database();
    ArrayList<User> users = database.getUsers();

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "№";
            case 1:
                return "Логин";
            case 2:
                return "Пароль";
            case 3:
                return "ФИО";
            case 4:
                return "Роль";

            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return users.get(rowIndex).getId();
            case 1:
                return users.get(rowIndex).getLogin();
            case 2:
                return users.get(rowIndex).getPassword();
            case 3:
                return users.get(rowIndex).getFio();
            case 4:
                return users.get(rowIndex).getRole();

            default:
                return "";
        }
    }
}
