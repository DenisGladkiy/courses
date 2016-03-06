package com.courses.spalah.text.analyzer;

import java.io.*;
import java.util.Map;

/**
 * @author Ievgen Tararaka
 */
public class TextAnalyzer {
    private static Map<String, Integer> words;
    private static Map<Character, Integer> letters;

    public static void main(String[] args) {
        // Входная точка для аналайзера текста
        File file = new File("topic8/src/main/resources/text_sample.txt");
        SymbolCounter symbolCounter = new SymbolCounter();
        WordCounter wordCounter = new WordCounter();
        SentenceCounter sentenceCounter = new SentenceCounter();
        words = wordCounter.detailWordStats(file);
        letters = symbolCounter.detailLetterStat(file);

        try {
            FileWriter fileWriter = new FileWriter("topic8/src/main/resources/output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Number of symbols = " + symbolCounter.countSymbols(file)+"\n");
            bufferedWriter.write("Number of words = " + wordCounter.countWords(file)+"\n");
            bufferedWriter.write("Number of sentences = " + sentenceCounter.countSentence(file)+"\n");
            bufferedWriter.write("Number of unique words = " + wordCounter.countUniqueWords(file)+"\n");
            bufferedWriter.write("The most frequent word = " + wordCounter.mostFrequentWord(file)+"\n");
            bufferedWriter.write("The length of the shortest word = " + wordCounter.shortestWord(file)+"\n");
            bufferedWriter.write("The length of the longest word = " + wordCounter.longestWord(file)+"\n"+"\n");
            printMap(bufferedWriter, words);
            bufferedWriter.write("\n");
            printMap(bufferedWriter, letters);
            bufferedWriter.close();
            System.out.println("Look result at the file  - topic8/src/main/resources/output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printMap(BufferedWriter br, Map map) throws IOException {
        for(Object e : map.entrySet()){
            br.write(e.toString()+"\n");
        }
    }
}
