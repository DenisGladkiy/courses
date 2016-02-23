package com.rxn1d.courses.service;

import com.rxn1d.courses.common.Format;
import com.rxn1d.courses.model.CarParking;

/**
 * Created by Denis on 23.02.2016.
 */
public class JsonToXmlConverter {

    public static String convert (String json) {
        CarParkingDeserializer jsonDeserializer = SerializationFactory.getDeserializer(Format.JSON);
        CarParking parking = jsonDeserializer.deserialize(json);
        CarParkingSerializer xmlSerializer = SerializationFactory.getSerializer(Format.XML);
        String xml = xmlSerializer.serialize(parking);
        return xml;
    }
}
