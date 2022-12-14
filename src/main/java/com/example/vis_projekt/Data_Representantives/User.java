package com.example.vis_projekt.Data_Representantives;

public class User {
    private int user_id;
    private String name;
    private String surname;
    private String email;

    public User(int user_id, String name, String surname, String email) {
        this.user_id = user_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
