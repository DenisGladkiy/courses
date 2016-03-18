package com.courses.spalah;

/**
 * @author Ievgen Tararaka
 */
public class FileReader {
    public String pathToFile;

    public FileReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    /**
     * Should return content of file by path
     * @return content of file
     */
    public String readFile() {
        return "";
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
}
