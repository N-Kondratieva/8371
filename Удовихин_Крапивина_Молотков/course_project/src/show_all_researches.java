import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class show_all_researches {
    public static int view_all_researches() {
        String[] a={""};
        final JFrame frame = new JFrame("Просмотр всех исследовательских работ");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton buttonviewdoneresearch = new JButton("Вывести выполненные работы");
        buttonviewdoneresearch.addActionListener(l -> {
            //
        });
        JButton buttonvievcurrentresearch = new JButton("Вывести текущие работы");
        buttonvievcurrentresearch.addActionListener(l -> {
            //
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
        buttonviewdoneresearch.setBounds(20,10,250,50);
        buttonvievcurrentresearch.setBounds(300,10,250,50);
        buttonselectresearch.setBounds(790,10,150,50);
        String[] columnNames = { "Research ID", "Research Name"}; //, "Research Description", "Research Begin", "Research End", "Laboratory Id", "Research Progress" };

        ResultSet result = null;
        PreparedStatement view;
        {
            try {
                view = JDBCPostgreSQL.connection.prepareStatement("SELECT * FROM research");// WHERE research_id=");
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
        //panel.add(labelName);
        //panel.add(box);
        panel.add(scrollableList);

        frame.add(panel);
        frame.setVisible(true);

        return 0;



    }
}
