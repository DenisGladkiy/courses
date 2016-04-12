package com.courses.spalah;

import com.courses.spalah.annotations.*;

/**
 * Created by Денис on 4/11/16.
 */
public class Car {
    @OwnerId
    private int ownerId = 0;
    @Year
    private int year;
    @Manufacturer
    private String manufacturer;
    @ModelName
    private String model;
    @Vin
    private String vin;
    @Description
    private String description;

    public Car() {
    }

    public Car(int year, String manufacturer, String model, String vin, String description) {
        this.year = year;
        this.manufacturer = manufacturer;
        this.model = model;
        this.vin = vin;
        this.description = description;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                ", ownerId=" + ownerId +
                ", year=" + year +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

