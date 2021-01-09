package models;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import db.JDBCPostgreSQL;

public class Event {
    private int id;
    public int creatorId;
    public String description = null;
    public String address = null;
    public int membersRequired;
    public String date = null;
    public String actionTitle = null;

    public List<User> users;


    public Event(int id, int creator_id, String description, String address, int membersRequired, String date,String actionTitle) {
        this.id = id;
        this.creatorId = creator_id;
        this.description = description;
        this.address = address;
        this.membersRequired = membersRequired;
        this.date = date;
        this.actionTitle = actionTitle;
    }

    public int getId() {
        return id;
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

    public int getCreatorId() {
        return creatorId;
    }

    public String getActionTitle() {
        return actionTitle;
    }

    public String getDate() {
        return date;
    }

    public List<User> getUsers() {
        return users;
    }
}
