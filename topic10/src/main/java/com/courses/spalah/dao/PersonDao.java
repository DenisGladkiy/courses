package com.courses.spalah.dao;

import java.util.List;

import com.courses.spalah.FileReader;
import com.courses.spalah.domain.Person;

/**
 * Implement this file. Work with DB simulation
 *
 * @author Ievgen Tararaka
 */
public class PersonDao implements Dao<Person> {
    FileReader fileReader;

    public PersonDao(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person findById(Long id) {
        return null;
    }

    @Override
    public boolean update(Person entity) {
        return false;
    }

    @Override
    public boolean insert(Person entity) {
        return false;
    }

    @Override
    public Person remove(Long id) {
        return null;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }
}
