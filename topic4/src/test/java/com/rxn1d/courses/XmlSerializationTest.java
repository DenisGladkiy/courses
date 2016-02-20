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
public class XmlSerializationTest {
    private static final Format FORMAT = Format.XML;

    private static String expectedXml1;
    private static String expectedXml2;

    public static CarParking parking1;
    public static CarParking parking2;
    public static Car car1;
    public static Car car2;
    public static Car car3;

    @BeforeClass
    public static void setUp() {
        expectedXml1 = TestUtils.readFile("serialization/xml/expected_xml1.xml");
        expectedXml2 = TestUtils.readFile("serialization/xml/expected_xml2.xml");

        car1 = new Car();
        car1.setManufacturer("Volvo");
        car1.setModelName("D60");
        car1.setVin("VD111160");
        car1.setLengthMillimeters(5111);
        car1.setHeightMillimeters(2420);

        car2 = new Car();
        car2.setManufacturer("Mazda");
        car2.setModelName("Mazda2");
        car2.setVin("1Mzzzm12311");
        car2.setLengthMillimeters(5330);
        car2.setHeightMillimeters(2315);

        car3 = new Car();
        car3.setManufacturer("Reno");
        car3.setModelName("Megane");
        car3.setVin("M12312MM");
        car3.setLengthMillimeters(5155);
        car3.setHeightMillimeters(2055);

        parking1 = new CarParking();
        parking1.setAddress("Bridge street 73A");
        parking1.setParkingName("Sailing");
        parking1.setCars(new Car[]{car1});

        parking2 = new CarParking();
        parking2.setAddress("Down Town street 3701");
        parking2.setParkingName("Mike's parking");
        parking2.setCars(new Car[]{car2, car3});
    }

    @Test
    public void testSerializationFirstParking() {
        CarParkingSerializer serializer = SerializationFactory.getSerializer(FORMAT);
        String xml = serializer.serialize(parking1);

        equals(expectedXml1, xml);
    }

    @Test
    public void testSerializationSecondParking() {
        CarParkingSerializer serializer = SerializationFactory.getSerializer(FORMAT);
        String xml = serializer.serialize(parking2);

        equals(expectedXml2, xml);
    }

    /*
     * Сравнивает 2 строки в XML формате. Игнорирует все пробельные символы
     */
    private static boolean equalsIgnoreWhiteSpaces(String expected, String actual) {
        String expectedWithoutSpaces = expected.replaceAll("\\s+", "");
        String actualWithoutSpaces = actual.replaceAll("\\s+", "");
        return expectedWithoutSpaces.equals(actualWithoutSpaces);
    }

    private static void equals(String expectedJson, String actualJson) {
        assertTrue(TestUtils.xmlMessage(expectedJson, actualJson), equalsIgnoreWhiteSpaces(expectedJson, actualJson));
    }
}
