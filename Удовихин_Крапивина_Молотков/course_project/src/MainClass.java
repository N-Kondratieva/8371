import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class MainClass{

    public static void main(String[] args) {

        JDBCPostgreSQL a = new JDBCPostgreSQL();
        a.JDBC();

        final JFrame frame = new JFrame("Главное окно");
        frame.setSize(670, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton buttonLabControl = new JButton("Управление лабораторией");
        buttonLabControl.addActionListener(l -> {
            LabControl sc= new LabControl();
            sc.Control();
            frame.setVisible(false);
        });
        JButton buttonWareHouseControl = new JButton("Управление складом");
        buttonWareHouseControl.addActionListener(l -> {
            WareHouseControl sc= new WareHouseControl();
            sc.Control();
            //ViewingSingleOrder sc = new ViewingSingleOrder();
            //sc.ViewOrder();
            frame.setVisible(false);

        });


        JPanel panelButtons = new JPanel(null);
        panelButtons.add(buttonLabControl);
        panelButtons.add(buttonWareHouseControl);
        buttonLabControl.setBounds(50,70,250,100);
        buttonWareHouseControl.setBounds(350,70,250,100);

        frame.add(panelButtons);
        frame.setVisible(true);

        PreparedStatement update;
        {
            try {
                update = JDBCPostgreSQL.connection.prepareStatement("SELECT stock_quantity FROM drugs");
                ResultSet n = update.executeQuery();
                while (n.next()) {
                    System.out.println(n.getString(1));
                }
            }
            catch(SQLException ex){
            }
        }
    }


}
