package com.courses.spalah.text.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Denis on 05.03.2016.
 */
public class SymbolCounter {
    BufferedReader bufferedReader;

    public SymbolCounter(FileReader fileReader){
        bufferedReader = new BufferedReader(fileReader);
    }

    public int  readFile(){
        String line = "";
        String result = "";
        int i = 100;
        try {
            while(line != null){
                result +=line;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        result = result.replaceAll("\\s+", "");
        return result.length();
    }
}
