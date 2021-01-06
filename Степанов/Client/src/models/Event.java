package models;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import db.JDBCPostgreSQL;

public class Event {
    private int id;
    public int creator_id;
    public String description = null;
    public String address = null;
    public int membersRequired;
    public Date date = null;
    public Time time = null;

    public List<User> users;


    public Event(int id, int creator_id, String description, String address, int membersRequired, Date date, Time time) {
        this.id = id;
        this.creator_id = creator_id;
        this.description = description;
        this.address = address;
        this.membersRequired = membersRequired;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public int getMembersRequired() {
        return membersRequired;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public List<User> getUsers() {
        return users;
    }
}
