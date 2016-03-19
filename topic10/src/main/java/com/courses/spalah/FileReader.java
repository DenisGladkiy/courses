package com.courses.spalah;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Ievgen Tararaka
 */
public class FileReader {
    public String pathToFile;
    private String line;

    public FileReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    /**
     * Should return content of file by path
     * @return content of file
     */
    public String readFile() {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(pathToFile));
            line = reader.readLine();
            while(line != null){
                builder.append(line + "\n");
                line = reader.readLine();
            }
            reader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

}
