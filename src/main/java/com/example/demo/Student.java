package com.example.demo;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "student")
public class Student {
    @Id
    public Integer id;
    private String fullname;
    private Double mark;
    private boolean gender;
    private Date birthday ;
    @ManyToOne
    @JoinColumn(name = "majorID")
    private Major major;
    public Student(Integer id, String fullname, Double mark, boolean gender, Date birthday,Major major) {
        this.id = id;
        this.fullname = fullname;
        this.mark = mark;
        this.gender = gender;
        this.birthday = birthday;
        this.major= major;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
