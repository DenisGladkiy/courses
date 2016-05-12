package com.courses.spalah.entity;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

/**
 * Created by Денис on 3/25/16.
 */


public class AdvertEntity {
    private int idadvert;
    private int carId;
    private CarEntity car;
    private int price;

    public AdvertEntity() {
    }

    public AdvertEntity(CarEntity car, int price) {
        this.car = car;
        this.price = price;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdadvert() {
        return idadvert;
    }

    public void setIdadvert(int idadvert) {
        this.idadvert = idadvert;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "AdvertEntity{" +
                ", carId=" + car +
                ", price=" + price +
                '}';
    }
}
