package com.courses.spalah.entity;

/**
 * Created by Денис on 3/25/16.
 */
public class CarEntity {
    private int carId;
    private int ownerId;
    private OwnerEntity owner;
    private int year;
    private String manufacturer;
    private String model;
    private String vin;
    private String description;

    public CarEntity() {
    }

    ;

    public CarEntity(int carId, OwnerEntity owner, int year, String manufacturer, String model, String vin, String description) {
        this.carId = carId;
        this.owner = owner;
        this.year = year;
        this.manufacturer = manufacturer;
        this.model = model;
        this.vin = vin;
        this.description = description;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
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

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "carId=" + carId +
                ", owner=" + owner +
                ", year=" + year +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
