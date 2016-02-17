package com.rxn1d.courses;

import com.rxn1d.courses.common.Format;
import com.rxn1d.courses.model.Car;
import com.rxn1d.courses.model.CarParking;
import com.rxn1d.courses.service.CarParkingSerializer;
import com.rxn1d.courses.service.SerializationFactory;
import com.rxn1d.courses.utils.TestUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

/**
 * @author Ievgen Tararaka
 */
@RunWith(JUnit4.class)
public class JsonSerializationTest {
    private static final Format FORMAT = Format.JSON;

    private static String expectedJson1;
    private static String expectedJson2;

    public static CarParking parking1;
    public static CarParking parking2;
    public static Car car1;
    public static Car car2;
    public static Car car3;

    @BeforeClass
    public static void setUp() {
        expectedJson1 = TestUtils.readFile("serialization/expected_json1.json");
        expectedJson2 = TestUtils.readFile("serialization/expected_json2.json");

        car1 = new Car();
        car1.setManufacturer("BMW");
        car1.setModelName("X6");
        car1.setVin("1111X6");
        car1.setLengthMillimeters(5500);
        car1.setHeightMillimeters(3500);

        car2 = new Car();
        car2.setManufacturer("Ferarri");
        car2.setModelName("458");
        car2.setVin("F458-111");
        car2.setLengthMillimeters(4800);
        car2.setHeightMillimeters(2800);

        car3 = new Car();
        car3.setManufacturer(car1.getManufacturer());
        car3.setModelName(car1.getModelName());
        car3.setVin(car1.getVin() + "3333");
        car3.setLengthMillimeters(car1.getLengthMillimeters());
        car3.setHeightMillimeters(car1.getHeightMillimeters());

        parking1 = new CarParking();
        parking1.setAddress("Cebra avenue 1F");
        parking1.setParkingName("Baltic Parking");
        parking1.setCars(new Car[]{car1, car3});

        parking2 = new CarParking();
        parking2.setAddress("Clinton street 126");
        parking2.setParkingName("Navy Parking");
        parking2.setCars(new Car[]{car2, car3});
    }

    @Test
    public void testSerializationFirstParking() {
        CarParkingSerializer serializer = SerializationFactory.getSerializer(FORMAT);
        String json = serializer.serialize(parking1);

        equals(expectedJson1, json);
    }

    @Test
    public void testSerializationSecondParking() {
        CarParkingSerializer serializer = SerializationFactory.getSerializer(FORMAT);
        String json = serializer.serialize(parking2);

        equals(expectedJson2, json);
    }

    /*
     * Сравнивает 2 строки в JSON формате. Игнорирует все пробельные символы
     */
    private static boolean equalsIgnoreWhiteSpaces(String expected, String actual) {
        String expectedWithoutSpaces = expected.replaceAll("\\s+", "");
        String actualWithoutSpaces = actual.replaceAll("\\s+", "");
        return expectedWithoutSpaces.equals(actualWithoutSpaces);
    }

    private static void equals(String expectedJson, String actualJson) {
        assertTrue(TestUtils.jsonMessage(expectedJson, actualJson), equalsIgnoreWhiteSpaces(expectedJson, actualJson));
    }
}
