package com.courses.spalah.myExceptions;

/**
 * Created by Denis on 01.03.2016.
 */
public class TableIsFullException extends Exception {

    public TableIsFullException(String message){
        super(message);
    }
}
