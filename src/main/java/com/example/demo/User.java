package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    private int id;
    private String password;
    private String fullname;
    private String photo;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(int id, String password, String fullname, String photo, String email) {
        this.id = id;
        this.password = password;
        this.fullname = fullname;
        this.photo = photo;
        this.email = email;
    }
}
