import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewingWarehouseDrugs {
    public static int ViewWarehouseDrugs() {
        final JFrame frame = new JFrame("Просмотр текущих препаратов на складе");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        JLabel labelName = new JLabel("Склад:");
        labelName.setBounds(20,20,70,40);

        String [] warehouseNames = {"1", "2", "3"};
        JComboBox box = new JComboBox(warehouseNames);
        box.setBounds(95, 20, 60, 40);

        frame.add(labelName);
        frame.add(box);

        //JList list = new JList();


        String[] columnNames = { "Drug ID", "Type ID", "Stock Quantity", "Storage ID", "Drug Name", "Drug description" };

        ResultSet result = null;
        PreparedStatement view;
        {
            try {
                view = JDBCPostgreSQL.connection.prepareStatement("SELECT * FROM drugs");
                result = view.executeQuery();
            }
            catch(SQLException ex){
            }
        }
        JTable drugsTable = null;
        try {
            drugsTable = new JTable(BuildTableModel.buildTableModel(result,columnNames));
        } catch(SQLException ex){
        }
        JScrollPane scrollableList = new JScrollPane(drugsTable);
        scrollableList.setBounds(20,100,960, 500);
        panel.add(labelName);
        panel.add(box);
        panel.add(scrollableList);

        frame.add(panel);
        frame.setVisible(true);

        return 0;

    }
}
