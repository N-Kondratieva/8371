package models;

import java.util.List;

public class Category {
    private int id;
    public String title;
    public List<Action> actions;

    public Category(int id, String title, List<Action> actions){
        this.id = id;
        this.title = title;
        if (actions.isEmpty()){
            this.actions = null;
        } else {
            this.actions = actions;
        }
    }

    public String getTitle() {
        return title;
    }

    public List<Action> getActions() {
        return actions;
    }

    public int getId() {
        return id;
    }

}
