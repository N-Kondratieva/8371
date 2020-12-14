package models;

import java.util.List;

public class Action {
    private int id;
    public String title;
    public List<Event> events;

    public int getId() {
        return id;
    }

}
