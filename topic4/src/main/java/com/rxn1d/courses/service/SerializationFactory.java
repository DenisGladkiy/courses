package com.rxn1d.courses.service;

import com.rxn1d.courses.common.Format;

/**
 * Фабрика для создания сериализатора и десериализатора для конкретного типа файла
 *
 * @author Ievgen Tararaka
 */
public class SerializationFactory {
    /**
     * Необходимо реализовать логику возвращения
     * десериализатора для конкретного формата файла.
     * </p>Например вернуть реализацию CarParkingDeserializer для JSON формата
     *
     * @param format формат файла
     * @return имплементацию десериализатора
     */
    public static CarParkingDeserializer getDeserializer(Format format) {
        // TODO - здесь будет ваша логика. Необходимо вернуть реализацию интерфейса
        if(format.equals(Format.JSON)){
            CarParkingDeserializer deserializerJSON = new DeserializerJSON();
            return deserializerJSON;
        }else {
            CarParkingDeserializer deserializerXML = new DeserializerXML();
            return deserializerXML;
        }
    }

    /**
     * Необходимо реализовать логику возвращения
     * сериализатора для конкретного формата файла.
     * </p>Например вернуть реализацию CarParkingSerializer для JSON формата
     *
     * @param format формат файла
     * @return имплементацию сериализатора
     */
    public static CarParkingSerializer getSerializer(Format format) {
        // TODO - здесь будет ваша логика. Необходимо вернуть реализацию интерфейса
        if(format.equals(Format.JSON)){
            CarParkingSerializer serializerJSON = new SerializerJSON();
            return serializerJSON;
        }else{
            CarParkingSerializer serializerXML = new SerializerXML();
            return serializerXML;
        }
    }
}
