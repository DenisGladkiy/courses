package com.rxn1d.courses.service;

import com.rxn1d.courses.common.Format;
import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;

/**
 * Created by Denis on 19.02.2016.
 */
public class XMLserializationTest {


    public static void main(String[] args){
        Car car1 = new Car("Mazda","Mazda3","ABC123456",4555,3000);
        Car car2 = new Car("Volvo","V40","CBE99999",5300,3155);
        Car[] cars = {car1,car2};
        CarParking parking = new CarParking("Gagarina avenue 1","Parking #1",cars);
        CarParkingSerializer serializer = SerializationFactory.getSerializer(Format.XML);
        String serialized = serializer.serialize(parking);
        System.out.println(serialized);



    }
}
