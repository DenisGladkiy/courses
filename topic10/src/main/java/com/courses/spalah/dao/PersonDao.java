package com.courses.spalah.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.courses.spalah.FileReader;
import com.courses.spalah.domain.Person;

/**
 * Implement this file. Work with DB simulation
 *
 * @author Ievgen Tararaka
 */
public class PersonDao implements Dao<Person> {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedWriter writer;
    private static long idCounter;
    private static final String FILE_PATH = "E:\\java\\courses\\topic10\\src\\test\\resources\\persons.txt";
    //private static final String FILE_PATH = "/persons.txt";


    public PersonDao(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Person> findAll() {
        fileReader = new FileReader(FILE_PATH);
        String file = fileReader.readFile();
        List<Person> persons = new ArrayList<>();
        String[] lines = file.split("\n");
        for (String line : lines) {
            if(!line.equals("")) {
                persons.add(deserializeEntity(line));
            }
        }
        return persons;
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
        System.out.println("counter " + idCounter + "id " + entity.getId());
        if (idCounter < entity.getId()) {
            try {
                fileWriter = new FileWriter(FILE_PATH, true);
                writer = new BufferedWriter(fileWriter);
                writer.write(serializeEntity(entity));
                writer.newLine();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            idCounter = entity.getId();
            return true;
        } else {
            return false;
        }
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

    private String serializeEntity(Person entity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(entity.getId() + "; ");
        stringBuilder.append(entity.getFirstName() + "; ");
        stringBuilder.append(entity.getLastName() + "; ");
        stringBuilder.append(entity.getAddress() + ";");
        return stringBuilder.toString();
    }

    private Person deserializeEntity(String line) {
        String[] personTxt = line.split(";\\s*");
        //System.out.println(Arrays.asList(personTxt));
        Person person = new Person(Long.parseLong(personTxt[0]), personTxt[1], personTxt[2], personTxt[3]);
        return person;
    }

}
