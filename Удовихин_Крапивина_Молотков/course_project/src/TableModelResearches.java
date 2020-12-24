import data.Research;

import javax.swing.table.AbstractTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableModelResearches extends AbstractTableModel {
    ResultSet result = null;
    int count=0;
    ArrayList<Research> Research_data = new ArrayList<Research>();
    PreparedStatement view;
    {
        try {
            view = JDBCPostgreSQL.connection.prepareStatement("SELECT * FROM research");
            result = view.executeQuery();
            while (result.next()) {

                Research buffResearch= new Research(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getInt(7));

                Research_data.add(buffResearch);
            }
        } catch (SQLException ex) {
        }
    }
    @Override
    public int getRowCount() {
        return Research_data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Research ID";
            case 1:
                return "Research Name";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Research_data.get(rowIndex).getResearchID();

            case 1:
                return Research_data.get(rowIndex).getResearchName();
            default:
                return "";
        }
    }
}
