import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;

public class show_all_researches {
    public static int view_all_researches() {
        String[] a = {""};
        String[] columnNames = {"Research ID", "Research Name"};
        TableModelResearches research_table = new TableModelResearches();
        TableModelCompleteResearches research_table_complete = new TableModelCompleteResearches();
        JTable researchTable2 = new JTable(research_table);
        ResultSet result = null;
        ResultSet result_cmplt = null;
        PreparedStatement view;
        {
            try {
                view = JDBCPostgreSQL.connection.prepareStatement("SELECT * FROM research");// WHERE research_id=");
                result = view.executeQuery();
                view = JDBCPostgreSQL.connection.prepareStatement("SELECT * FROM research WHERE research_progress=100");
                result_cmplt = view.executeQuery();
            } catch (SQLException ex) {
            }
        }
        final JFrame frame = new JFrame("Просмотр всех исследовательских работ");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JButton buttonviewdoneresearch = new JButton("Вывести все работы");
        buttonviewdoneresearch.addActionListener(l -> {
            researchTable2.setModel(research_table);
        });
        JButton buttonvievcurrentresearch = new JButton("Вывести выполненные работы");
        buttonvievcurrentresearch.addActionListener(l -> {
        researchTable2.setModel(research_table_complete);

        });

        JButton buttonselectresearch = new JButton("Посмотреть работу");
        buttonselectresearch.addActionListener(l -> {
            select_research sr = new select_research();
            try {
                sr.select_current_research(a[0]);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JPanel panel = new JPanel(null);
        panel.add(buttonviewdoneresearch);
        panel.add(buttonvievcurrentresearch);
        panel.add(buttonselectresearch);
        buttonviewdoneresearch.setBounds(20, 10, 250, 50);
        buttonvievcurrentresearch.setBounds(300, 10, 250, 50);
        buttonselectresearch.setBounds(790, 10, 150, 50);
        researchTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                a[0]=researchTable2.getValueAt(researchTable2.getSelectedRow(), 0).toString();

            }
        });
        JScrollPane scrollableList = new JScrollPane(researchTable2);
        scrollableList.setBounds(20, 100, 960, 500);
        //panel.add(labelName);
        //panel.add(box);
        panel.add(scrollableList);

        frame.add(panel);
        frame.setVisible(true);

        return 0;


    }
}
