package com.courses.spalah.text.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Denis on 06.03.2016.
 */
public class TextSplitter {
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public String[] splitText(File file, String regex) {
        String[] result;
        String line = "";
        StringBuilder builder = new StringBuilder();
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while (line != null) {
                builder.append(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        result = builder.toString().split(regex);
        return result;
    }
}
