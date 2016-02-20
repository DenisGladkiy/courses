package com.rxn1d.courses.service;

import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Denis on 19.02.2016.
 */
public class DeserializerXML implements CarParkingDeserializer {
    @Override
    public CarParking deserialize(String serializedCarParking) {
        String regex = "\\s*(<|>|\n)\\s*";
        String[] parking = serializedCarParking.split(regex);
        //System.out.println(Arrays.asList(parking));
        List<Car> cars = new ArrayList<>();
        CarParking carParking = new CarParking();
        for(int i = 0; i < parking.length; i++){
            if(parking[i].equals("address")){
                carParking.setAddress(parking[i + 1]);
            }
            if(parking[i].equals("parkingName")){
                carParking.setParkingName(parking[i + 1]);
            }
            if(parking[i].equals("manufacturer")){
                Car car = new Car(parking[i + 1],parking[i + 5],parking[i + 9],Integer.valueOf(parking[i+13]),
                        Integer.valueOf(parking[i + 17]));
                cars.add(car);
            }
            carParking.setCars(cars.toArray(new Car[cars.size()]));
        }
        return carParking;
    }
}
