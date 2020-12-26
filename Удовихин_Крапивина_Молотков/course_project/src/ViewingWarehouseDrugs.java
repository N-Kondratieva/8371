import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewingWarehouseDrugs {
    public static int ViewWarehouseDrugs() {
        final JFrame frame = new JFrame("Просмотр текущих препаратов на складе");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);
        JLabel labelName = new JLabel("Склад:");
        labelName.setBounds(20,20,70,40);

        String [] warehouseNames = {"1", "2", "3"};
        JComboBox box = new JComboBox(warehouseNames);
        box.setBounds(95, 20, 60, 40);

        frame.add(labelName);
        frame.add(box);

        String[] columnNames = { "Drug ID", "Type ID", "Stock Quantity", "Storage ID", "Drug Name", "Drug description" };

        frame.add(panel);
        frame.setVisible(true);

        box.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int storage = box.getSelectedIndex() + 1;
                ResultSet result = null;
                PreparedStatement view;
                {
                    try {
                        view = JDBCPostgreSQL.connection.prepareStatement("SELECT * FROM drugs  where storage_id = "+storage);
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
                panel.removeAll();
                JScrollPane scrollableList = new JScrollPane(drugsTable);
                scrollableList.setBounds(20,100,960, 500);
                panel.add(scrollableList);
            }
        });

        return 0;

    }
}
