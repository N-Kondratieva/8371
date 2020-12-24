import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewingOrders {
    public static int Order() {
        String[] a={""};
        final JFrame frame = new JFrame("Просмотр всех заказов");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JButton buttonviewdoneorder = new JButton("Просмотр выполненных заказов");
        buttonviewdoneorder.addActionListener(l -> {
            //
        });
        JButton buttonvievcurrentorder = new JButton("Просмотр текущих заказов");
        buttonvievcurrentorder.addActionListener(l -> {
            //
        });
        JButton buttonselectorder = new JButton("Посмотреть заказ");
        buttonselectorder.addActionListener(l -> {
            select_research sr = new select_research();
            try {
                sr.select_current_research(a[0]);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JPanel panel = new JPanel(null);
        panel.add(buttonviewdoneorder);
        panel.add(buttonvievcurrentorder);
        panel.add(buttonselectorder);
        buttonviewdoneorder.setBounds(20,10,250,50);
        buttonvievcurrentorder.setBounds(300,10,250,50);
        buttonselectorder.setBounds(790,10,150,50);
        String[] columnNames = { "ID заказа"}; //, "Research Description", "Research Begin", "Research End", "Laboratory Id", "Research Progress" };

        ResultSet result = null;
        PreparedStatement view;
        {
            try {
                view = JDBCPostgreSQL.connection.prepareStatement("SELECT order_id FROM orders");
                result = view.executeQuery();
            }
            catch(SQLException ex){
            }
        }
        JTable researchTable = null;
        try {
            researchTable = new JTable(BuildTableModel.buildTableModel(result,columnNames));
        } catch(SQLException ex){
        }
        JTable finalresearchTable = researchTable;
        researchTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                a[0]=finalresearchTable.getValueAt(finalresearchTable.getSelectedRow(), 0).toString();

            }
        });
        JScrollPane scrollableList = new JScrollPane(researchTable);
        scrollableList.setBounds(20,100,960, 500);
        panel.add(scrollableList);

        frame.add(panel);
        frame.setVisible(true);

        return 0;

    }
}
