package com.rxn1d.courses.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Ievgen Tararaka
 */
public class TestUtils {
    public static String readFile(String path) {
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource(path);
            byte[] encoded = Files.readAllBytes(Paths.get(url.toURI()));
            return new String(encoded, Charset.defaultCharset());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String fieldMessage(String fieldName, Object expected, Object actual) {
        return "Поле " + fieldName + " не совпадает, ожидаемый результат=" + expected +
                ",\nрезультат=" + actual;
    }

    public static String jsonMessage(String expectedJson, String actualJson) {
        return "JSON без учета пробельных символов не совпадает, ожидаемый JSON=" + expectedJson.replaceAll("\\s+", "") +
                ",\n результат=" + actualJson.replaceAll("\\s+", "");
    }
}
