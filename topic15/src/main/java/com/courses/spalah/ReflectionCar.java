package com.courses.spalah;

/**
 * Created by Денис on 4/11/16.
 */
public class ReflectionCar {

    public static void main(String[] args) {
        Car car = new Car(2010, "BMW", "M3", "derss4", "red");
        store("car", car);
    }

    public static void store(String table, Car car){
        Class clazz = car.getClass();

    }
}
