package com.courses.spalah;

import com.google.gson.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Денис on 4/5/16.
 */
public class CarmarketHttpServlet extends HttpServlet {
    List<List<String>> carList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //List<List<String>> carList;
        PrintWriter printWriter = response.getWriter();
        GetAdverts getAdverts = new GetAdverts();
        carList = getAdverts.getData(request);
        printWriter.write("{ \n [ \n");
        for (List<String> car : carList) {
            printWriter.write(serialize(car));
        }
        printWriter.write("] \n }");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder sBuilder = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        while(line!=null){
            sBuilder.append(line);
            line = reader.readLine();
        }
        reader.close();
        String jsonInsert = sBuilder.toString();
        JsonObject jsonObject = new Gson().fromJson(jsonInsert, JsonObject.class);
        Map<String, String> advert = new HashMap<>();
        advert.put("manufacturer",jsonObject.get("manufacturer").getAsString());
        advert.put("modelName",jsonObject.get("modelName").getAsString());
        advert.put("year",jsonObject.get("year").getAsString());
        advert.put("vin",jsonObject.get("vin").getAsString());
        advert.put("description",jsonObject.get("description").getAsString());
        advert.put("price",jsonObject.get("price").getAsString());
        advert.put("name",jsonObject.get("name").getAsString());
        advert.put("surname",jsonObject.get("surname").getAsString());
        advert.put("contact_phone",String.valueOf(jsonObject.get("contact_phone").getAsInt()));
        InsertNewAdvert insertion = new InsertNewAdvert();
        insertion.insert(advert);
    }

    String serialize(List<String> list) {
        JsonObject json = new JsonObject();
        json.add("id", new JsonPrimitive(Integer.parseInt(list.get(0))));
        json.add("manufacturer", new JsonPrimitive(list.get(1)));
        json.add("model", new JsonPrimitive(list.get(2)));
        json.add("year", new JsonPrimitive(Integer.parseInt(list.get(3))));
        json.add("vin", new JsonPrimitive(list.get(4)));
        json.add("description", new JsonPrimitive(list.get(5)));
        json.add("price", new JsonPrimitive(Integer.parseInt(list.get(6))));
        json.add("phone", new JsonPrimitive(Integer.parseInt(list.get(7))));
        return json.toString();
    }
}
