package com.dashlexz.spring.pp_312.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "employees")
public class User implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "salary")
    private int salary;

    public User(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
