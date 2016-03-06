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
        String text = "";
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while (line != null) {
                text += line;
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        result = text.split(regex);
        return result;
    }
}
