package com.rxn1d.courses.model;

import java.util.Arrays;

/**
 * Данный класс представляет собой щусность автомобильной парковки
 *
 * @author Ievgen Tararaka
 */
public class CarParking {
    private String address;
    private String parkingName;
    private Car[] cars;

    public CarParking() {
    }

    public CarParking(String address, String parkingName, Car[] cars) {
        this.address = address;
        this.parkingName = parkingName;
        this.cars = cars;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarParking{" +
                "address='" + address + '\'' +
                ", parkingName='" + parkingName + '\'' +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }
}
