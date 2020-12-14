package models;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Event {
    private int id;
    public User creator;
    public Text description;
    public String address;
    public int membersRequired;
    public Date date;
    public Time time;

    public List<User> users;

    public int getId() {
        return id;
    }

}
