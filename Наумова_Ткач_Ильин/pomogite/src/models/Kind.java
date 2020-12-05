package models;

public class Kind extends Identified<Kind>{
    String name;

    Kind(Id<Kind> id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
