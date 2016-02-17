package com.rxn1d.courses.service;

import com.rxn1d.courses.model.CarParking;

/**
 * Интерфейс сериализатора класса {@link com.rxn1d.courses.model.CarParking}
 * TODO необходимо создать реализацию этого интерфейса
 *
 * @author Ievgen Tararaka
 */
public interface CarParkingSerializer {
    String serialize(CarParking carParking);
}
