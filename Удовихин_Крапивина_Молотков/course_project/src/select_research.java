import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class select_research {
    public static int select_current_research(String current_research_id) throws SQLException {

        ResultSet rs=null;
        PreparedStatement view;
        {
            try {
                view = JDBCPostgreSQL.connection.prepareStatement("SELECT * FROM research WHERE research_id="+current_research_id);
                rs = view.executeQuery();
            }
            catch(SQLException ex){
            }
        }

        System.out.println(120);
        final JFrame frame = new JFrame("Исследование№"+current_research_id); //Приделать номер заказа
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        while(rs.next()) {
            String research_id = rs.getString("research_id").toString();
            String research_name = rs.getString("research_name").toString();
            String research_description = rs.getString("research_description").toString();
            String research_begin=rs.getString("research_date_begin").toString();
            String research_end=rs.getString("research_date_end").toString();
            String laboratory_id=rs.getString("laboratory_id").toString();
            String research_progress=rs.getString("research_progress").toString();

            JPanel panel = new JPanel(null);
            JLabel research_id_lbl = new JLabel("Номер \n исследования");
            JLabel research_name_lbl = new JLabel("Название исследования");
            JLabel research_begin_lbl = new JLabel("Дата начала");
            JLabel research_end_lbl = new JLabel("Дата окончания");
            JLabel research_description_lbl = new JLabel("Описание работы");
            JLabel research_lab_lbl = new JLabel("Лаборатория №");
            JLabel research_progress_lbl = new JLabel("Прогресс");
            JTextField research_id_txt = new JTextField(research_id);
            JTextField research_name_txt = new JTextField(research_name);
            JTextField research_begin_txt = new JTextField(research_begin);
            JTextField research_end_txt = new JTextField(research_end);
            JTextField research_description_txt = new JTextField(research_description);
            JTextField research_lab_txt = new JTextField(laboratory_id);
            JTextField research_progress_txt = new JTextField(research_progress);
            research_id_txt.setEditable(false);
            research_name_txt.setEditable(false);
            research_begin_txt.setEditable(false);
            research_end_txt.setEditable(false);
            research_description_txt.setEditable(false);
            research_lab_txt.setEditable(false);
            research_progress_txt.setEditable(false);

            research_id_lbl.setBounds(20, 20, 100, 50);
            research_id_txt.setBounds(130, 20, 70, 50);
            research_name_lbl.setBounds(220, 20, 100, 50);
            research_name_txt.setBounds(340, 20, 200, 50);
            research_begin_lbl.setBounds(580, 20, 100, 50);
            research_begin_txt.setBounds(700, 20, 70, 50);
            research_end_lbl.setBounds(800, 20, 100, 50);
            research_end_txt.setBounds(900, 20, 70, 50);
            research_description_lbl.setBounds(20, 100, 150, 50);
            research_description_txt.setBounds(20, 150, 500, 150);
            research_lab_lbl.setBounds(20, 330, 150, 50);
            research_lab_txt.setBounds(130, 330, 150, 50);
            research_progress_lbl.setBounds(580, 330, 150, 50);
            research_progress_txt.setBounds(700, 330, 150, 50);

            panel.add(research_id_lbl);
            panel.add(research_id_txt);
            panel.add(research_name_lbl);
            panel.add(research_name_txt);
            panel.add(research_begin_lbl);
            panel.add(research_begin_txt);
            panel.add(research_end_lbl);
            panel.add(research_end_txt);
            panel.add(research_description_lbl);
            panel.add(research_description_txt);
            panel.add(research_lab_lbl);
            panel.add(research_lab_txt);
            panel.add(research_progress_lbl);
            panel.add(research_progress_txt);

            frame.add(panel);
            frame.setVisible(true);
        };

        return 0;




    }
}
