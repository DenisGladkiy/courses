package com.rxn1d.courses.model;

/**
 * Данный класс представляет собой сущность автомобиля
 *
 * @author Ievgen Tararaka
 */
public class Car {
    private String manufacturer;
    private String modelName;
    private String vin;
    private int lengthMillimeters;
    private int heightMillimeters;

    public Car() {
    }

    public Car(String manufacturer, String modelName, String vin, int lengthMillimeters, int heightMillimeters) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.vin = vin;
        this.lengthMillimeters = lengthMillimeters;
        this.heightMillimeters = heightMillimeters;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getLengthMillimeters() {
        return lengthMillimeters;
    }

    public void setLengthMillimeters(int lengthMillimeters) {
        this.lengthMillimeters = lengthMillimeters;
    }

    public int getHeightMillimeters() {
        return heightMillimeters;
    }

    public void setHeightMillimeters(int heightMillimeters) {
        this.heightMillimeters = heightMillimeters;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", vin='" + vin + '\'' +
                ", lengthMillimeters=" + lengthMillimeters +
                ", heightMillimeters=" + heightMillimeters +
                '}';
    }
}
