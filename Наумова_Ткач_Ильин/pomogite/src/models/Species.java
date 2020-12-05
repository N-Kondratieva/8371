package models;

import java.util.Date;

public class Species extends Identified<Species>{
    String name;

    Species(Id<Species> id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
