package com.rxn1d.courses.service;

import com.rxn1d.courses.common.Format;
import com.rxn1d.courses.model.CarParking;

/**
 * Created by Denis on 23.02.2016.
 */
public class XmlToJsonConverter {

    public static String convert(String xml){
        CarParkingDeserializer xmlDeserializer = SerializationFactory.getDeserializer(Format.XML);
        CarParking parking = xmlDeserializer.deserialize(xml);
        CarParkingSerializer jsonSerializer = SerializationFactory.getSerializer(Format.JSON);
        String json = jsonSerializer.serialize(parking);
        return json;
    }
}
