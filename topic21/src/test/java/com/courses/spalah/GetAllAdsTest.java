package com.courses.spalah;

import com.courses.spalah.entity.AdvertEntity;
import com.courses.spalah.hibernate.HibernateUtil;
import com.courses.spalah.stuff.TableRows;
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
public class GetAllAdsTest {
    @Test
    public void testAllAds(){
        String hql = "from AdvertEntity";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<AdvertEntity> adverts = query.list();
        TableRows tableRows = new TableRows();
        String[][] testRows = tableRows.getAllRows();
        assertEquals(adverts.size(), testRows.length);
    }
    @Test
    public void testAllCars(){

    }
    @Test
    public void testAllOwners(){

    }



}
