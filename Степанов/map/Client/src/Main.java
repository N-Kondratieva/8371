import models.*;


public class Main {
    public static void main(String[] args) {

        JDBCPostgreSQL a = new JDBCPostgreSQL();
        a.JDBC();

        CategoriesGUI app = new CategoriesGUI();
        app.setVisible(true);
        app.setResizable(false);


    }
}
