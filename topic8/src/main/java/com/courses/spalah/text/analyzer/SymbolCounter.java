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
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        result = result.replaceAll("\\s+", "");
        return result.length();
    }

    public Map<Character, Integer> detailLetterStat(File file) {
        letters = new TreeMap<>();
        countSymbols(file);
        char[] symbols = result.toCharArray();
        for (char c : symbols) {
            if (Character.isLetter(c)) {
                if (letters.containsKey(Character.toLowerCase(c))) {
                    letters.put(Character.toLowerCase(c), letters.get(Character.toLowerCase(c)) + 1);
                } else {
                    letters.put(Character.toLowerCase(c), 1);
                }
            }
        }
        return letters;
    }
}
