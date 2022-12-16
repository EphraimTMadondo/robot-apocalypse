package com.robot.apocalypse.survivorsapp.models;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "survivors")
public class Survivor {
    @Column(name = "survivorName")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Id
    @Column(name = "ID", nullable = false)
    private long ID;
    @Column(name = "infection", nullable = false)
    private long infection;
    @Column(name = "lastLocation")
    private String lastLocation;

    @Column(name = "resources")
    private String resources;
    public Survivor() {

    }

    public Survivor(String name, int age, Gender gender, long ID, long infection, String lastLocation, String resources) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.ID = ID;
        this.infection = infection;
        this.lastLocation = lastLocation;
        this.resources = resources;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(String lastLocation) {
        this.lastLocation = lastLocation;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public long getInfection() {
        return infection;
    }

    public void setInfection(long infected) {
        this.infection = infected;
    }
}