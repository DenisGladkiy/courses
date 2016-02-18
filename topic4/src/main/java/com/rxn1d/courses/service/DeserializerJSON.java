package com.rxn1d.courses.service;

import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Denis on 18.02.2016.
 */
public class DeserializerJSON implements CarParkingDeserializer {
    @Override
    public CarParking deserialize(String serializedCarParking) {
        CarParking carParking = new CarParking();
        String regex = "\\s*(\"|:|,|\\{|\\}|\\[|\\])\\s*";
        String[] json = serializedCarParking.split(regex);
        List<String> jsonList = new ArrayList<>();
        for(String s : json){
            if(!s.equals("")){
                jsonList.add(s);
            }
        }
        //System.out.println(jsonList);
        List<Car> carsList = new ArrayList<>();
        int index = 0;
        for(String s : jsonList){
            if(s.equals("address")){
               carParking.setAddress(jsonList.get(index + 1));
            }
            if(s.equals("parkingName")){
                carParking.setParkingName(jsonList.get(index + 1));
            }
            if(s.equals("manufacturer")){
                //int index = jsonList.indexOf(s);
                Car car = new Car();
                car.setManufacturer(jsonList.get(index+1));
                car.setModelName(jsonList.get(index+3));
                car.setVin(jsonList.get(index+5));
                car.setLengthMillimeters(Integer.valueOf(jsonList.get(index+7)));
                car.setHeightMillimeters(Integer.valueOf(jsonList.get(index+9)));
                //System.out.println(car.toString());
                carsList.add(car);
            }
            index++;
        }
        carParking.setCars(carsList.toArray(new Car[carsList.size()]));
        return carParking;
    }
}
