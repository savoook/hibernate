package ru.easium.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.easium.HibernateSessionSingleton;
import ru.easium.domain.Student;

import java.util.List;
@Repository
public class StudentDAO {
    public Student findById(int id) {
        return HibernateSessionSingleton.getSessionFactory().openSession().get(Student.class, id);
    }

    public List<Student> findAll() {
        return HibernateSessionSingleton.getSessionFactory().openSession().createQuery("FROM Student").list();
    }

    public void save(Student student) {
        Session session = HibernateSessionSingleton.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
    }
}
