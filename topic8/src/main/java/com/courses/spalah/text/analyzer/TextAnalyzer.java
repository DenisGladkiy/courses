package com.courses.spalah.text.analyzer;

import java.io.File;

/**
 * @author Ievgen Tararaka
 */
public class TextAnalyzer {
    public static void main(String[] args) {
        // Входная точка для аналайзера текста
        File file = new File("topic8/src/main/resources/text_sample.txt");
        SymbolCounter symbolCounter = new SymbolCounter();
        System.out.println("symbol " + symbolCounter.countSymbols(file));
        WordCounter wordCounter = new WordCounter();
        System.out.println("word " + wordCounter.countWords(file));
        SentenceCounter sentenceCounter = new SentenceCounter();
        System.out.println("sentence " + sentenceCounter.countSentence(file));
        System.out.println("unique " + wordCounter.countUniqueWords(file));
        System.out.println("frequent " + wordCounter.mostFrequentWord(file));
        System.out.println("shortest " + wordCounter.shortestWord(file));
        System.out.println("longest " + wordCounter.longestWord(file));
        wordCounter.detailWordStats(file);
        symbolCounter.detailLetterStat(file);

    }
}
