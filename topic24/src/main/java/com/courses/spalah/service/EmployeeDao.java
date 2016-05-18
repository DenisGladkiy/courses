package com.courses.spalah.service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.courses.spalah.domain.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * @author Ievgen Tararaka
 */
public class EmployeeDao {
    private SessionFactory factory;

    public EmployeeDao(SessionFactory factory) {
        this.factory = factory;
    }

    public List<Employee> getAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Employee> employees = Collections.emptyList();
        try {
            tx = session.beginTransaction();
            employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator =
                 employees.iterator(); iterator.hasNext(); ) {
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("Last Name: " + employee.getLastName());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }

    public Employee get(Long id) {
        Session session = factory.openSession();
        Transaction tx = null;
        Employee employee = null;
        try {
            tx = session.beginTransaction();
            employee = session.get(Employee.class, id);
            System.out.print("First Name: " + employee.getFirstName());
            System.out.print("Last Name: " + employee.getLastName());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }

    public void save(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(employee);
            System.out.print("First Name: " + employee.getFirstName());
            System.out.print("Last Name: " + employee.getLastName());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void update(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(employee);
            System.out.print("First Name: " + employee.getFirstName());
            System.out.print("Last Name: " + employee.getLastName());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Employee> findByName(String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Employee> employees = Collections.emptyList();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Employee E WHERE E.firstName=:name");
            query.setParameter("name", name);
            employees = query.list();
            for (Iterator iterator =
                 employees.iterator(); iterator.hasNext(); ) {
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("Last Name: " + employee.getLastName());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }

    public List<Employee> findByNameWithCriteria(String name) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Employee> employees = Collections.emptyList();
        try {
            tx = session.beginTransaction();
            employees = session.createCriteria(Employee.class)
                    .add(Restrictions.in("firstName", new String[]{"Fritz", "Izi", "Pk"}))
                    .add(Restrictions.disjunction()
                            .add(Restrictions.isNull("age"))
                            .add(Restrictions.eq("age", new Integer(0)))
                            .add(Restrictions.eq("age", new Integer(1)))
                            .add(Restrictions.eq("age", new Integer(2)))
                    ).list();
            for (Iterator iterator =
                 employees.iterator(); iterator.hasNext(); ) {
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("Last Name: " + employee.getLastName());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }
}
