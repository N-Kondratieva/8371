package models;

public class Gender extends Identified<Gender>{
    boolean value;//0 = F; 1 = M


    Gender(Id<Gender> id, boolean value) {
        super(id);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}

