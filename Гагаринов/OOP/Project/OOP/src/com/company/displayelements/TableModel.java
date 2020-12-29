package com.company.displayelements;

import com.company.Order;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class TableModel extends AbstractTableModel {
    Database database = new Database();
    ArrayList<Order> orders = database.getOrders();
    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "№";
            case 1:
                return "Услуга";
            case 2:
                return "Сотрудник";
            case 3:
                return "Заказчик";
            case 4:
                return "E-mail заказчика";
            case 5:
                return "Длительность";
            case 6:
                return "Стоимость";
            case 7:
                return "Дата";
            case 8:
                return "Дата выполнения";
            case 9:
                return "Статус";
            case 10:
                return "Путь";
            default:
                return "";
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                    return orders.get(rowIndex).getId();
            case 1:
                return orders.get(rowIndex).getServiceId();
            case 2:
                return orders.get(rowIndex).getEmployeeId();
            case 3:
                return orders.get(rowIndex).getCustomerFIO();
            case 4:
                return orders.get(rowIndex).getCustomerEmail();
            case 5:
                return orders.get(rowIndex).getDurationMaterial();
            case 6:
                return orders.get(rowIndex).getCost();
            case 7:
                return new Date(orders.get(rowIndex).getInDate()).toString();
            case 8:
                return new Date(orders.get(rowIndex).getApproximateDate()).toString();
            case 9:
                return orders.get(rowIndex).isStatus();
            case 10:
                return orders.get(rowIndex).getInputMaterial();

            default:
                return "";
        }
    }


}
