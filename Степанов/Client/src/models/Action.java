package models;

import java.util.List;

public class Action {
    private int id;
    public String title;
    public List<Event> events;

    public Action(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Event> getEvents() {
        return events;
    }

    public int getId() {
        return id;
    }

}
