package com.example.demo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "major")
public class Major {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "major", fetch = FetchType.EAGER)
    private Collection<Student> students;

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public Major(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Major() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
