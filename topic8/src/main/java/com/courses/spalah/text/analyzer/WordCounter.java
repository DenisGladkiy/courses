package com.courses.spalah.text.analyzer;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Denis on 06.03.2016.
 */
public class WordCounter {
    private String[] result;
    private Map<String, Integer> words;

    public int countWords(File file) {
        String regex = "\\s*[,|.|!|?|-|:|;|\\s]+\\s*";
        result = new TextSplitter().splitText(file, regex);
        return result.length;
    }

    public int countUniqueWords(File file) {
        makeWordsMap(file);
        int uniqueWords = 0;
        for (Map.Entry<String, Integer> e : words.entrySet()) {
            if (e.getValue() == 1) {
                uniqueWords++;
            }
        }
        return uniqueWords;
    }

    public String mostFrequentWord(File file) {
        makeWordsMap(file);
        String frequentWord = "";
        int frequency = 0;
        for (Map.Entry<String, Integer> e : words.entrySet()) {
            if (frequency < e.getValue()) {
                frequency = e.getValue();
                frequentWord = e.getKey();
            }
        }
        return frequentWord;
    }

    public int shortestWord(File file) {
        countWords(file);
        int wordLength = 100;
        for (String s : result) {
            if (wordLength > s.length()) {
                wordLength = s.length();
            }
        }
        return wordLength;
    }

    public int longestWord(File file) {
        countWords(file);
        int wordLength = 0;
        for (String s : result) {
            if (wordLength < s.length()) {
                wordLength = s.length();
            }
        }
        return wordLength;
    }

    public void detailWordStats(File file) {
        makeWordsMap(file);
        System.out.println("");
        for (Map.Entry<String, Integer> e : words.entrySet()) {
            System.out.println(e);
        }
    }

    private Map<String, Integer> makeWordsMap(File file) {
        words = new TreeMap();
        countWords(file);
        for (String s : result) {
            if (words.containsKey(s)) {
                words.put(s, words.get(s) + 1);
            } else {
                words.put(s, 1);
            }
        }
        return words;
    }
}
