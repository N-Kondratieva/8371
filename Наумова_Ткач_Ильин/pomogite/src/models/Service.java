package models;

public class Service extends Identified<Service>{
    boolean value;//0 = вязка; 1 = продажа


    Service(Id<Service> id, boolean value) {
        super(id);
        this.value = value;
    }
    public boolean getValue() {
        return value;
    }
}
