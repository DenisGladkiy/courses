package com.courses.spalah.dao;

import java.io.*;
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
    private BufferedReader reader;
    private long idCounter;
    private static final String FILE_PATH = "E:\\java\\courses\\topic10\\src\\test\\resources\\persons.txt";
    private static final String TEMP_FILE_PATH = "E:\\java\\courses\\topic10\\src\\test\\resources\\temp.txt";


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
        List<Person> persons = findAll();
        for(Person person : persons){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
    }

    @Override
    public boolean update(Person entity) {
        long personId = entity.getId();
        if(remove(personId) != null){
            insert(entity);
            return true;
        }else {
            return false;
        }
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
        Person person = null;
        File tempFile = new File(TEMP_FILE_PATH);
        File persons = new File(FILE_PATH);
        try {
            reader = new BufferedReader(new java.io.FileReader(persons));
            writer = new BufferedWriter(new FileWriter(tempFile, true));
            String line = reader.readLine();
            while(line != null){
                String[] lineArr = line.split(";\\s*");
                if(Long.parseLong(lineArr[0]) == id){
                    person = deserializeEntity(line);
                    System.out.println("remove "+line);
                }else{
                    System.out.println("write "+line);
                    writer.write(line);
                    writer.newLine();
                }
                line = reader.readLine();
            }
            reader.close();
            writer.close();
            persons.delete();
            tempFile.renameTo(persons);
        } catch (IOException e) {
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

    public void clearFile(String path){
        try {
            writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
