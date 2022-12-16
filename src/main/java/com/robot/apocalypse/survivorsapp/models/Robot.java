package com.robot.apocalypse.survivorsapp.models;
import lombok.Builder;

import javax.persistence.*;


@Entity
@Builder
@Table(name = "robots")
public class Robot {
    @Column(name = "model")
    private String model;
    @Id
    @Column(name = "serialNumber")
    private String serialNumber;
    @Column(name = "manufacturedDate")
    private String manufacturedDate;
    @Column(name = "category")
    private String category;

    public Robot() {

    }

    public Robot(String model, String serialNumber, String manufacturedDate, String category) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.manufacturedDate = manufacturedDate;
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
