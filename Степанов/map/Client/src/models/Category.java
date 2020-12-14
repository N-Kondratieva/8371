package models;

import java.util.List;

public class Category {
    private int id;
    public String title;
    public List<Action> actions;

    public int getId() {
        return id;
    }

}
