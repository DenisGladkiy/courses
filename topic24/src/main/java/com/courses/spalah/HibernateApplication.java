package com.courses.spalah;

import com.courses.spalah.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Ievgen Tararaka
 */
public class HibernateApplication {
    public static void main(String[] args) {
        // создаем конфигурацию
        Configuration cfg=new Configuration();
        // конфигурим с помощью XML-файла
        cfg.configure("hibernate.cfg.xml");

        // создаем фабрику сессий
        SessionFactory factory=cfg.buildSessionFactory();
        // создаем сессию
        Session session=factory.openSession();

        // открываем транзакцию
        Transaction t=session.beginTransaction();

        // создаем нашу сущность
        Employee e1=new Employee();
        e1.setFirstName("sonoo");
        e1.setLastName("jaiswal");

        // сохраняем обьект
        session.persist(e1);

        // коммитим транзакцию
        t.commit();
        // закрываем сессию
        session.close();

        System.out.println("successfully saved");
    }
}
