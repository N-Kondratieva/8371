import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewingOrders {
    public static int Order() {

        ResultSet result = null;

        String[] columnNames = {"ID заказа"};
        String[] a={""};

        JPanel panel = new JPanel(null);
        final JTable[] orderTable = {null};
        final JScrollPane[] scrollableList = {new JScrollPane(orderTable[0])};
        panel.add(scrollableList[0]);

        final JFrame frame = new JFrame("Просмотр всех заказов");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JButton buttonviewdoneorder = new JButton("Просмотр выполненных заказов");
        buttonviewdoneorder.addActionListener(l -> {
            ResultSet resultDoneOrders = null;
            PreparedStatement view;
            {
                try {
                    view = JDBCPostgreSQL.connection.prepareStatement("SELECT * FROM orders where not issue_date = '1900-01-01'");
                    resultDoneOrders = view.executeQuery();
                }
                catch(SQLException ex){
                }
            }
            try {
                orderTable[0] = new JTable(BuildTableModel.buildTableModel(resultDoneOrders,columnNames));
            } catch(SQLException ex){
            }
            scrollableList[0] = new JScrollPane(orderTable[0]);
            panel.remove(scrollableList[0]);
            panel.add(scrollableList[0]);
            scrollableList[0].setBounds(20,100,960, 500);
        });
        JButton buttonvievcurrentorder = new JButton("Просмотр текущих заказов");
        buttonvievcurrentorder.addActionListener(l -> {
            ResultSet resultCurrentOrders = null;
            PreparedStatement view;
            {
                try {
                    view = JDBCPostgreSQL.connection.prepareStatement("SELECT * FROM orders where issue_date = '1900-01-01'");
                    resultCurrentOrders = view.executeQuery();
                }
                catch(SQLException ex){
                }
            }
            try {
                orderTable[0] = new JTable(BuildTableModel.buildTableModel(resultCurrentOrders,columnNames));
            } catch(SQLException ex){
            }
            scrollableList[0] = new JScrollPane(orderTable[0]);
            panel.remove(scrollableList[0]);
            panel.add(scrollableList[0]);
            scrollableList[0].setBounds(20,100,960, 500);


        });
        JButton buttonselectorder = new JButton("Посмотреть заказ");
        buttonselectorder.addActionListener(l -> {
            ViewingSingleOrder sr = new ViewingSingleOrder();
            try {
                sr.ViewOrder(a[0]);
            } catch(SQLException ex){
            }
        });


        panel.add(buttonviewdoneorder);
        panel.add(buttonvievcurrentorder);
        panel.add(buttonselectorder);
        buttonviewdoneorder.setBounds(20,10,250,50);
        buttonvievcurrentorder.setBounds(300,10,250,50);
        buttonselectorder.setBounds(790,10,150,50);

        scrollableList[0].setBounds(20,100,960, 500);

        /*
        JTable finalorderTable = orderTable[0];
        orderTable[0].getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                a[0]=finalorderTable.getValueAt(finalorderTable.getSelectedRow(), 0).toString();
            }
        });*/


        frame.add(panel);
        frame.setVisible(true);

        return 0;

    }
}
