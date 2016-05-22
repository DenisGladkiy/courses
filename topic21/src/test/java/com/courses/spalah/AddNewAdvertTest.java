package com.courses.spalah;

import com.courses.spalah.stuff.InsertData;
import com.courses.spalah.stuff.TableRows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Денис on 5/22/16.
 */

@RunWith(JUnit4.class)
public class AddNewAdvertTest {

    @Test
    public void testInsertion(){
        int dbSize = dbSize();
        InsertData insertData = new InsertData();
        try {
            insertData.insertData(dataToInsert());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(dbSize + 1, dbSize());

    }

    private int dbSize(){
        int size = 0;
        TableRows tableRows = new TableRows();
        String[][] testRows = tableRows.getAllRows();
        size = testRows.length;
        return size;
    }

    private String[][] dataToInsert(){
        String[][] data = null;
        String[] advert = {"0", "999111"};
        String[] car = {"testcar", "testmodel", "9999", "testvin", "testdescription"};
        String[] owner = {"abcd", "xyz", "09876"};
        data = new String[][]{advert, car, owner};
        return data;
    }

}
