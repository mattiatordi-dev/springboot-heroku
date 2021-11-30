package com.example.demo.model;

import javax.persistence.*;
import java.util.Comparator;

@Entity
@Table(name = "test")
public class test{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    String type;

    public test() {}

    public test(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "test{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }


}
