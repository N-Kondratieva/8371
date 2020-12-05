package models;

import java.util.ArrayList;

public class Owner extends Identified<Owner>{
    String name;
    String contacts;
    String location;
    String login;
    String password;
    ArrayList<Id<Pet>> pets;

    Owner(Id<Owner> id, String name, String contacts, String location, ArrayList<Id<Pet>> pets, String login, String password) {
        super(id);
        this.name = name;
        this.contacts = contacts;
        this.location = location;
        this.pets = pets;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getContacts() {
        return contacts;
    }
    public String getLocation() {
        return location;
    }
    public ArrayList<Id<Pet>> getPets() {
        return pets;
    }
    public String setName() {
        return name;
    }
    public String setContacts() {
        return contacts;
    }
    public String setLocation() {
        return location;
    }
    public ArrayList<Id<Pet>> setPets() {
        return pets;
    }
    public String getLogin() {
        return login;
    }
    public String setLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String setPassword() {
        return password;
    }
}
