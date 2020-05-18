import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.easium.HibernateSessionSingleton;
import ru.easium.domain.Course;
import ru.easium.domain.Student;
import ru.easium.service.StudentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Session session = HibernateSessionSingleton.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
        Course junior = new Course("Java junior", 32);
        Course middle = new Course("Java middle", 12);
        List<Course> courses = new ArrayList();
        courses.add(junior);
        courses.add(middle);
        Student student = new Student("John", new Date(12354), 1000, courses);
        junior.setStudent(student);
        middle.setStudent(student);
//        session.save(student);
//        tx.commit();
//        session.close();

        StudentService service = new StudentService();
        service.saveStudent(student);
    }
}

