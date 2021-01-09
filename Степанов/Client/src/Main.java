import display.CategoriesGUI;
import db.JDBCPostgreSQL;
import display.StartGUI;
import models.User;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        JDBCPostgreSQL db = new JDBCPostgreSQL();
        db.JDBC();

        StartGUI app = new StartGUI();
        app.setVisible(true);
        app.setResizable(false);

//        db.CreateAction("sport", "pool");
//        ArrayList<User> users = db.getUsers(1);
//        db.AddEventsUsersRelation(3,3);


    }
}
