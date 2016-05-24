package com.courses.spalah;

import com.courses.spalah.stuff.SortRows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Created by Денис on 5/22/16.
 */

@RunWith(JUnit4.class)
public class SelectionTest {
    @Test
    public void testSelection(){
        SortRows sort = new SortRows();
        String[] selection = new String[]{"testcar","testmodel","","",""};
        String[][] testSelect = sort.sortTable(selection);
        assertEquals(1, testSelect.length);
    }

}
