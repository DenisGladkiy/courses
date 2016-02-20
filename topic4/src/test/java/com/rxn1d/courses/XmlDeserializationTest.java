package com.rxn1d.courses;

import com.rxn1d.courses.common.Format;
import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;
import com.rxn1d.courses.service.CarParkingDeserializer;
import com.rxn1d.courses.service.SerializationFactory;
import com.rxn1d.courses.utils.TestUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Ievgen Tararaka
 */
@RunWith(JUnit4.class)
public class XmlDeserializationTest {
    private static final Format FORMAT = Format.XML;

    private static String firstXml;
    private static String secondXml;

    @BeforeClass
    public static void setUp() {
        firstXml = TestUtils.readFile("deserialization/xml/xml1.xml");
        secondXml = TestUtils.readFile("deserialization/xml/xml2.xml");
    }

    @Test
    public void testDeserializationFirstXml() {
        CarParkingDeserializer deserializer = SerializationFactory.getDeserializer(FORMAT);
        CarParking carParking = deserializer.deserialize(firstXml);

        assertNotNull(carParking);
        equals("address", "Atkinson ave 55", carParking.getAddress());
        equals("parkingName", "Atkinson Parking", carParking.getParkingName());

        Car[] cars = carParking.getCars();
        assertTrue(cars.length == 3);

        Car firstCar = cars[0];

        equals("manufacturer", "Bentley", firstCar.getManufacturer());
        equals("modelName", "Mark V", firstCar.getModelName());
        equals("vin", "123123123MV", firstCar.getVin());
        equals("lengthMillimeters", 5454, firstCar.getLengthMillimeters());
        equals("heightMillimeters", 2300, firstCar.getHeightMillimeters());

        Car secondCar = cars[1];

        equals("manufacturer", "McLaren", secondCar.getManufacturer());
        equals("modelName", "F1", secondCar.getModelName());
        equals("vin", "F1299FFF", secondCar.getVin());
        equals("lengthMillimeters", 5110, secondCar.getLengthMillimeters());
        equals("heightMillimeters", 2155, secondCar.getHeightMillimeters());

        Car thirdCar = cars[2];

        equals("manufacturer", "Mini", thirdCar.getManufacturer());
        equals("modelName", "Cooper", thirdCar.getModelName());
        equals("vin", "MCOO00", thirdCar.getVin());
        equals("lengthMillimeters", 4780, thirdCar.getLengthMillimeters());
        equals("heightMillimeters", 2331, thirdCar.getHeightMillimeters());
    }

    @Test
    public void testDeserializationSecondXml() {
        CarParkingDeserializer deserializer = SerializationFactory.getDeserializer(FORMAT);
        CarParking carParking = deserializer.deserialize(secondXml);

        assertNotNull(carParking);
        equals("address", "Advanced street 12A", carParking.getAddress());
        equals("parkingName", "Advanced parking", carParking.getParkingName());

        Car[] cars = carParking.getCars();
        assertTrue(cars.length == 0);
    }

    private static void equals(String fieldName, Object expected, Object actual) {
        assertEquals(TestUtils.fieldMessage(fieldName, expected, actual), expected, actual);
    }
}
