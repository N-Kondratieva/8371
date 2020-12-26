import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewingOrders {
    static JTable orderTable = null;
    public static int Order() {
        String[] a={""};
        final JFrame frame = new JFrame("Просмотр всех заказов");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        String[] columnNames = { "ID заказа"};

        JPanel panel = new JPanel(null);


        JButton buttonviewdoneorder = new JButton("Просмотр выполненных заказов");
        buttonviewdoneorder.addActionListener(l -> {
            ResultSet result = null;
            PreparedStatement view;
            {
                try {
                    view = JDBCPostgreSQL.connection.prepareStatement("SELECT order_id FROM orders where not issue_date = '1900-01-01' ");
                    result = view.executeQuery();
                }
                catch(SQLException ex){
                }
            }

            try {
                orderTable = new JTable(BuildTableModel.buildTableModel(result,columnNames));
            } catch(SQLException ex){
            }
            panel.removeAll();
            JScrollPane scrollableList = new JScrollPane(orderTable);
            scrollableList.setBounds(20,100,960, 500);
            panel.add(scrollableList);
        });
        JButton buttonvievcurrentorder = new JButton("Просмотр текущих заказов");
        buttonvievcurrentorder.addActionListener(l -> {
            ResultSet result = null;
            PreparedStatement view;
            {
                try {
                    view = JDBCPostgreSQL.connection.prepareStatement("SELECT order_id FROM orders where issue_date = '1900-01-01' ");
                    result = view.executeQuery();
                }
                catch(SQLException ex){
                }
            }

            try {
                orderTable = new JTable(BuildTableModel.buildTableModel(result,columnNames));
            } catch(SQLException ex){
            }
            panel.removeAll();
            JScrollPane scrollableList = new JScrollPane(orderTable);
            scrollableList.setBounds(20,100,960, 500);
            panel.add(scrollableList);
        });

        JButton buttonselectorder = new JButton("Посмотреть заказ");
        buttonselectorder.addActionListener(l -> {
            a[0] = orderTable.getValueAt(orderTable.getSelectedRow(), 0).toString();
            System.out.println(a[0]);
            ViewingSingleOrder sr = new ViewingSingleOrder();
            try {
                sr.ViewOrder(a[0]);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        frame.add(buttonviewdoneorder);
        frame.add(buttonvievcurrentorder);
        frame.add(buttonselectorder);
        buttonviewdoneorder.setBounds(20,10,250,50);
        buttonvievcurrentorder.setBounds(300,10,250,50);
        buttonselectorder.setBounds(790,10,150,50);

/*
        JTable finalresearchTable = researchTable;
        researchTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                a[0]=finalresearchTable.getValueAt(finalresearchTable.getSelectedRow(), 0).toString();
            }
        });*/


        frame.add(panel);
        frame.setVisible(true);

        return 0;

    }
}
