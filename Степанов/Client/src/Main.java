import display.CategoriesGUI;
import db.JDBCPostgreSQL;
import models.User;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        JDBCPostgreSQL db = new JDBCPostgreSQL();
        db.JDBC();


        CategoriesGUI app = new CategoriesGUI();
//        UserGUI app = new UserGUI();
        app.setVisible(true);
        app.setResizable(false);

//        db.CreateAction("sport", "pool");
//        ArrayList<User> users = db.getUsers(1);


    }
}
