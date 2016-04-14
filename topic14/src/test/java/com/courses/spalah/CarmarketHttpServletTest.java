package com.courses.spalah;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 4/10/16.
 */

@RunWith(JUnit4.class)
public class CarmarketHttpServletTest extends Mockito {
    CarmarketHttpServlet servlet;
    GetDbState dbState;
    List<String> testList;
    private static final String serialized = "{\"id\":12," +
            "\"manufacturer\":\"Mazda\"," +
            "\"model\":\"MX5\"," +
            "\"year\":2010," +
            "\"vin\":\"vin\"," +
            "\"description\":\"description\"," +
            "\"price\":18000," +
            "\"phone\":12345}";

    @Before
    public void setUp() {
        dbState = new GetDbState();
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
    public void testSerialization() {
        assertNotNull(servlet.serialize(testList));
        assertEquals(serialized, servlet.serialize(testList));
    }

    @Test
    public void testDoGet() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getQueryString()).thenReturn(null);
        try {
            when(response.getWriter()).thenReturn(new PrintWriter(System.out));
            servlet.doGet(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        int count = dbState.getTotalRowsNumber();
        assertEquals(count, servlet.carList.size());
    }

    @Test
    public void testDoGetSortManufacturer() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getQueryString()).thenReturn("manufacturer=nissan");
        try {
            when(response.getWriter()).thenReturn(new PrintWriter(System.out));
            servlet.doGet(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        assertEquals(2, servlet.carList.size());

    }

    @Test
    public void testDoGetSortYear() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getQueryString()).thenReturn("yearFrom=2009&yearTo=2014");
        try {
            when(response.getWriter()).thenReturn(new PrintWriter(System.out));
            servlet.doGet(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        int count = dbState.getSelectedRowsNumber("SELECT COUNT(*) AS rowcount FROM car " +
                "WHERE car.year > 2009 AND car.year < 2014");
        assertEquals(count, servlet.carList.size());
    }

    @Test
    public void testDoPost() {
        int count = dbState.getSelectedRowsNumber("SELECT COUNT(*) AS rowcount FROM car " +
                "WHERE car.manufacturer = 'Toyota' AND car.model = 'Auris'");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        BufferedReader bufferedReader = org.mockito.Mockito.mock(BufferedReader.class);
        PrintWriter printWriter = org.mockito.Mockito.mock(PrintWriter.class);
        when(request.getQueryString()).thenReturn("manufacturer=Toyota&modelName=Auris");
        try {
            when(request.getReader()).thenReturn(bufferedReader);
            when(bufferedReader.readLine()).
                    thenReturn("{\"manufacturer\":\"Toyota\",").
                    thenReturn("\"modelName\": \"Auris\",").
                    thenReturn("\"year\": 2011,").
                    thenReturn("\"vin\": \"ABC12345\",").
                    thenReturn("\"description\": \"Black\",").
                    thenReturn("\"price\": 14000,").
                    thenReturn("\"name\": \"Alex\",").
                    thenReturn("\"surname\": \"Gold\",").
                    thenReturn("\"contact_phone\": 38066223}").
                    thenReturn(null);
            servlet.doPost(request, response);
            when(response.getWriter()).thenReturn(printWriter);
            servlet.doGet(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        assertEquals(++count, servlet.carList.size());
    }
}
