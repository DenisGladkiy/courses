package com.rxn1d.courses;

import com.rxn1d.courses.service.JsonToXmlConverter;
import com.rxn1d.courses.service.XmlToJsonConverter;
import com.rxn1d.courses.utils.TestUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertTrue;

/**
 * Created by Denis on 23.02.2016.
 */
@RunWith(JUnit4.class)
public class ConverterTest {
    private static String json;
    private static String xml;

    @BeforeClass
    public static void setUp() {
        json = TestUtils.readFile("deserialization/json/json1.json");
        xml = TestUtils.readFile("deserialization/CarParking.xml");
    }

    @Test
    public void testJsonToXml() {
        String actualXml = JsonToXmlConverter.convert(json);
        equals(xml,actualXml);

    }
    @Test
    public void testXmlToJson(){
        String actualJson = XmlToJsonConverter.convert(xml);
        equals(json,actualJson);
    }

    private static boolean equalsIgnoreWhiteSpaces(String expected, String actual) {
        String expectedWithoutSpaces = expected.replaceAll("\\s+", "");
        String actualWithoutSpaces = actual.replaceAll("\\s+", "");
        return expectedWithoutSpaces.equals(actualWithoutSpaces);
    }

    private static void equals(String expectedXml, String actualXml) {
        assertTrue(TestUtils.xmlMessage(expectedXml, actualXml), equalsIgnoreWhiteSpaces(expectedXml, actualXml));
    }

}
