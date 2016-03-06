package com.courses.spalah.text.analyzer;

import java.io.File;

/**
 * Created by Denis on 06.03.2016.
 */
public class SentenceCounter {

    public int countSentence(File file) {
        String regex = "[.|!|?]\\s*";
        String[] result = new TextSplitter().splitText(file, regex);
        return result.length;
    }
}
