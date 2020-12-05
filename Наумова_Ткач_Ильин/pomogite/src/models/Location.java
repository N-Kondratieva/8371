package models;

public class Location extends Identified<Location>{
    String name;

    Location(Id<Location> id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
