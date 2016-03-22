package com.courses.spalah.dao;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.courses.spalah.FileReader;
import com.courses.spalah.domain.Person;

/**
 * Implement this file. Work with DB simulation
 *
 * @author Ievgen Tararaka
 */
public class PersonDao implements Dao<Person> {
    private FileReader fileReader;
    private BufferedWriter writer;
    private BufferedReader reader;
    private long idCounter;


    public PersonDao(FileReader fileReader) {

        this.fileReader = fileReader;
    }

    @Override
    public List<Person> findAll() {
        String file = fileReader.readFile();
        List<Person> persons = new ArrayList<>();
        String[] lines = file.split("\n");
        for (String line : lines) {
            if (!line.equals("")) {
                persons.add(deserializeEntity(line));
            }
        }
        return persons;
    }

    @Override
    public Person findById(Long id) {
        List<Person> persons = findAll();
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public boolean update(Person entity) {
        long personId = entity.getId();
        if (remove(personId) != null) {
            long tempIdCounter = idCounter;
            idCounter = 0;
            insert(entity);
            idCounter = tempIdCounter;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insert(Person entity) {
        if (idCounter < entity.getId()) {
            try {
                URL url = Thread.currentThread().getContextClassLoader().getResource(fileReader.getPathToFile());
                writer = new BufferedWriter(new FileWriter(new File(url.toURI()), true));
                writer.write(serializeEntity(entity));
                writer.newLine();
                writer.close();
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
            idCounter = entity.getId();
            return true;
        } else {
            return false;
        }
    }

    public Person remove(Long id) {
        Person person = null;
        URL url = Thread.currentThread().getContextClassLoader().getResource(fileReader.getPathToFile());
        List<String> lines = new ArrayList<>();
        try {
            File persons = new File(url.toURI());
            reader = new BufferedReader(new java.io.FileReader(persons));
            String line = reader.readLine();
            while (line != null) {
                if (getIdFromStringPerson(line) != id) {
                    lines.add(line);
                } else {
                    person = deserializeEntity(line);
                }
                line = reader.readLine();
            }
            reader.close();
            writer = new BufferedWriter(new FileWriter(persons));
            for (String s : lines) {
                writer.write(s);
                writer.newLine();
            }
            writer.close();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return person;
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
        Person person = new Person(Long.parseLong(personTxt[0]), personTxt[1], personTxt[2], personTxt[3]);
        return person;
    }

    private long getIdFromStringPerson(String person) {
        return Long.parseLong(person.split(";\\s*")[0]);
    }
}
