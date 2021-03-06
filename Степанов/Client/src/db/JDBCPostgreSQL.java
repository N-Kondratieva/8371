package db;

import models.Action;
import models.Event;
import models.User;

import java.sql.*;
import java.util.ArrayList;

public class JDBCPostgreSQL {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/map?currentSchema=public";
    static final String USER = "postgres";
    static final String PASS = "admin";
    public static Connection connection = null;

    public static User current_user;

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

    }

    public ArrayList<Action> getActions(String category) {
        ArrayList<Action> actions = new ArrayList<Action>();
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM public." + category);

            result = statement.executeQuery();
            while (result.next()) {
                Action buffAction = new Action(result.getInt(1), result.getString(2));
                actions.add(buffAction);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return actions;
    }


    public void createEvent(int creator_id, String description, String address, int membersRequired, String date, String action_title){
        String insert = "INSERT INTO public.events (creator_id, description, address, members_required, date, action_title) VALUES" +
                "('" + creator_id + "','" + description + "','" + address + "','" + membersRequired + "','" + date + "','" + action_title + "')";
        try {
            Statement statement = null;
            statement = connection.createStatement();
            statement.executeUpdate(insert);
            System.out.println("Event created");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Event> getEvents(String actionTitle) {
        ArrayList<Event> events = new ArrayList<Event>();
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM public.events WHERE action_title = '" + actionTitle + "'");
            result = statement.executeQuery();

            while (result.next()) {
                Event buffEvent = new Event(result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getString(6),
                        result.getString(7));
                events.add(buffEvent);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return events;
    }

    public ArrayList<User> getUsers(int event_id) {
        ArrayList<User> users = new ArrayList<User>();
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM public.users INNER JOIN (SELECT user_id FROM" +
                    " public.events_users WHERE event_id = " + event_id + ")" +
                    " AS table2 ON public.users.id = table2.user_id");
            result = statement.executeQuery();

            while (result.next()) {
                users.add(new User(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public User getUser(String email, String password) {
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM public.users WHERE password = '" + password + "' and email = '" + email + "'");
            result = statement.executeQuery();

            while (result.next()) {
                User user = new User(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7),
                        result.getString(8));
                current_user = user;
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void createUser(String firstName, String lastName, String email, String password, String
            phoneNumber, String birthDate, String aboutMe) {
        String insert = "INSERT INTO public.users (first_name,last_name,email, password, phone_number, birth_date," +
                " about_me) VALUES ('" + firstName + "','" + lastName + "','" + email + "','" + password + "','" + phoneNumber + "','" + birthDate + "','" + aboutMe + "')";
        try {
            Statement statement = null;
            statement = connection.createStatement();
            statement.executeUpdate(insert);
            System.out.println("User created");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void AddEventsUsersRelation(int event_id, int user_id) {
        String insert = "INSERT INTO public.events_users (event_id,user_id) VALUES ('" + event_id + "','" + user_id + "')";
        try {
            Statement statement = null;
            statement = connection.createStatement();
            statement.executeUpdate(insert);
            System.out.println("Relationship is created");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void CreateCategory(String categoryName) {
        try {
            String query = "create table " + categoryName + "(id SERIAL primary key, title varchar(200))";
            Statement statement = null;
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table " + categoryName + " created");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void CreateAction(String categoryName, String title) {
        String insert = "INSERT INTO public." + categoryName + " (title) VALUES ('" + title + "')";
        try {
            Statement statement = null;
            statement = connection.createStatement();
            statement.executeUpdate(insert);
            System.out.println("Action " + title + " created");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
