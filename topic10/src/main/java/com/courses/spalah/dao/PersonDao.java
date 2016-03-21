package com.courses.spalah.dao;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
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
    private BufferedWriter writer;
    private BufferedReader reader;
    private long idCounter;
    private boolean isUpdate;


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
            isUpdate = true;
            insert(entity);
            isUpdate = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insert(Person entity) {
        if (idCounter < entity.getId() || isUpdate) {
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

    @Override
    public Person remove(Long id) {
        Person person = null;
        URL url = Thread.currentThread().getContextClassLoader().getResource(fileReader.getPathToFile());
        try {
            File persons = new File(url.toURI());
            File tempFile = new File(persons.getAbsolutePath()+".tmp");
            reader = new BufferedReader(new java.io.FileReader(persons));
            writer = new BufferedWriter(new FileWriter(tempFile, true));
            String line = reader.readLine();
            while (line != null) {
                String[] lineArr = line.split(";\\s*");
                if (Long.parseLong(lineArr[0]) == id) {
                    person = deserializeEntity(line);
                } else {
                    writer.write(line);
                    writer.newLine();
                }
                line = reader.readLine();
            }
            reader.close();
            writer.close();
            System.gc();
            persons.delete();
            tempFile.renameTo(persons);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
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
}
