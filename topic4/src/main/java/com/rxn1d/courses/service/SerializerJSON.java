package com.rxn1d.courses.service;

import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;

/**
 * Created by Denis on 18.02.2016.
 */
public class SerializerJSON implements CarParkingSerializer {
    @Override
    public String serialize(CarParking carParking) {
        String json = new String();
        json = "{"+"\n"+"\"address\": "+"\""+carParking.getAddress()+"\", "+"\n"+
        "\"parkingName\": "+"\""+carParking.getParkingName()+"\", "+"\n"+
        "\"cars\" : "+getCarsString(carParking.getCars())+"}";
        return json;
    }

    private String getCarsString(Car[] cars){
        String car = "[";
        int index = 0;
        for(Car c : cars){
            index++;
            car += "\n"+"{"+"\"manufacturer\": "+"\""+c.getManufacturer()+"\","+"\n"+
                    "\"modelName\": "+"\""+c.getModelName()+"\","+"\n"+
                    "\"vin\": "+"\""+c.getVin()+"\","+"\n"+
                    "\"lengthMillimeters\": "+c.getLengthMillimeters()+","+"\n"+
                    "\"heightMillimeters\": "+c.getHeightMillimeters()+"\n"+"}";
            if(index!=cars.length){
                car +=",";
            }

        }
        car +="]";

        return car;
    }
}
