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
        return null;
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
        return  null;
    }
}
