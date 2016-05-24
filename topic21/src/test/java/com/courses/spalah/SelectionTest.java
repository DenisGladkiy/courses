package com.courses.spalah;

import com.courses.spalah.entity.AdvertEntity;
import com.courses.spalah.hibernate.HibernateUtil;
import com.courses.spalah.stuff.SortRows;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

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
        removeTestRow();
    }
    private void removeTestRow() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql_select = "from AdvertEntity WHERE car.manufacturer = 'testcar'";
        Query query = session.createQuery(hql_select);
        List<AdvertEntity> adverts = query.list();
        int ownerId = adverts.get(0).getCar().getOwner().getIdowner();
        String hql = "delete from OwnerEntity where idowner = " + ownerId;
        Query removeQuery = session.createQuery(hql);
        removeQuery.executeUpdate();
        session.close();
    }

}
