package com.courses.spalah.text.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Denis on 05.03.2016.
 */
public class SymbolCounter {
    private BufferedReader bufferedReader;
    private FileReader fileReader;
    private String result;
    private Map<Character, Integer> letters;

    public int countSymbols(File file) {
        result = "";
        String line = "";
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while (line != null) {
                result += line;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = result.replaceAll("\\s+", "");
        return result.length();
    }

    public void detailLetterStat(File file) {
        letters = new TreeMap<>();
        countSymbols(file);
        char[] symbols = result.toCharArray();
        for (char c : symbols) {
            if (Character.isLetter(c)) {
                if (letters.containsKey(c)) {
                    letters.put(c, letters.get(c) + 1);
                } else {
                    letters.put(c, 1);
                }
            }
        }
        System.out.println("");
        for (Map.Entry<Character, Integer> e : letters.entrySet()) {
            System.out.println(e);
        }
    }
}
