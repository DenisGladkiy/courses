package com.courses.spalah.text.analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Ievgen Tararaka
 */
public class TextAnalyzer {
    public static void main(String[] args) {
        // Входная точка для аналайзера текста
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("topic8/src/main/resources/text_sample.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SymbolCounter symbolCounter = new SymbolCounter(fileReader);
        System.out.println(symbolCounter.readFile());
    }
}
