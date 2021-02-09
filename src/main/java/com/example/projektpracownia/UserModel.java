package com.example.projektpracownia;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/

//@Entity
public class UserModel {

    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //private long id;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String login;
    //private boolean isDeleted;

    public UserModel(){}

    public UserModel(String name, String surname, String dateOfBirth, String login){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.login = login;
    }

    /*public long getId(){
        return id;
    }*/

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getLogin(){
        return login;
    }
}
