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
    public String aboutMe;
    public Date birthDate;

    public User(int id, String firstName, String lastName, String email, String password, String phoneNumber,  Date birthDate, String aboutMe) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.aboutMe = aboutMe;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getId() {
        return id;
    }
}
