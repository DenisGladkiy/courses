package com.rxn1d.courses.service;

import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;

/**
 * Created by Denis on 19.02.2016.
 */
public class SerializerXML implements CarParkingSerializer {
    @Override
    public String serialize(CarParking carParking) {
        String xml = new String();
        xml += "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<carParking>\n" +
                "   <address>" + carParking.getAddress() + "</address>\n" +
                "   <parkingName>" + carParking.getParkingName() + "</parkingName>\n" +
                getCarString(carParking.getCars()) + "</carParking>";

        return xml;
    }
    private String getCarString(Car[] cars){
        String car = new String();
        for(Car c : cars){
            car += "   <cars>\n" + "      <manufacturer>" + c.getManufacturer() + "</manufacturer>\n" +
                    "      <modelName>" + c.getModelName() + "</modelName>\n" + "      <vin>" + c.getVin() + "</vin>\n" +
                    "      <lengthMillimeters>" + c.getLengthMillimeters() + "</lengthMillimeters>\n" +
                    "      <heightMillimeters>" + c.getHeightMillimeters() + "</heightMillimeters>\n" + "   </cars>\n";

        }
        return car;
    }
}
