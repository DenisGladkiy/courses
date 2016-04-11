package com.courses.spalah;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 4/10/16.
 */

@RunWith(JUnit4.class)
public class CarmarketHttpServletTest {
    CarmarketHttpServlet servlet;
    List<String> testList;
    private static final String serialized = "{\n"+
            "\"id\": 12,\n"+
            "\"manufacturer\": \"Mazda\",\n"+
            "\"model\": \"MX5\",\n"+
            "\"year\": 2010,\n"+
            "\"vin\": \"vin\",\n"+
            "\"description\": \"description\",\n"+
            "\"price\": 18000,\n"+
            "\"phone\": 12345,\n"+
            "},\n";

    @Before
    public void setUp() {
        servlet = new CarmarketHttpServlet();
        testList = new ArrayList<>();
        testList.add(0, "12");
        testList.add(1, "Mazda");
        testList.add(2, "MX5");
        testList.add(3, "2010");
        testList.add(4, "vin");
        testList.add(5, "description");
        testList.add(6, "18000");
        testList.add(7, "12345");
    }

    @Test
    public void testSerialization(){
        assertNotNull(servlet.serialize(testList));
        assertEquals(serialized, servlet.serialize(testList));
    }
}
