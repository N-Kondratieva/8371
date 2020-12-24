
import java.sql.*;

public class JDBCPostgreSQL {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/lab_database?currentSchema=public";
    static final String USER = "postgres";
    static final String PASS = "admin";
    public static Connection connection = null;

    public static void JDBC() {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");


        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        /*
        PreparedStatement updateSales = null;
        try {
            updateSales = connection.prepareStatement("SELECT stock_quantity FROM drugs");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet n = null;
        try {
            n = updateSales.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            while(n.next()) {
                System.out.println(n.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        */
    }

}