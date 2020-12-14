package models;

import org.w3c.dom.Text;

import java.util.Date;

public class User {
    private int id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phoneNumber;
    public Text aboutMe;
    public Date birthDate;
    public Date createdAt;

    public int getId() {
        return id;
    }
}
