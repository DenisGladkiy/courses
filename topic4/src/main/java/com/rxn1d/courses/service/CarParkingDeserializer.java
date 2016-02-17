package com.rxn1d.courses.service;

import com.rxn1d.courses.model.CarParking;

/**
 * Интерфейс десериализатора класса {@link com.rxn1d.courses.model.CarParking}
 * TODO необходимо создать реализацию этого интерфейса
 *
 * @author Ievgen Tararaka
 */
public interface CarParkingDeserializer {
    CarParking deserialize(String serializedCarParking);
}
