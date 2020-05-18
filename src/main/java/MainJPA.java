import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;
import ru.easium.domain.Course;
import ru.easium.domain.Student;
import ru.easium.domain.Teacher;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MainJPA {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceDB");
        EntityManager entityManager = factory.createEntityManager();
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
//            Course junior = new Course("Java junior", 32);
//            Course middle = new Course("Java middle", 12);
//            List<Course> courses = new ArrayList();
//            courses.add(junior);
//            courses.add(middle);
//            Teacher teacher = new Teacher("Сидр сидр сидр", "Учитель высшей ка3тегории", courses);
//            junior.setTeacher(teacher);
//            middle.setTeacher(teacher);
//            entityManager.persist(teacher);

//            Teacher teacher=entityManager.find(Teacher.class, 1);
//            System.out.println(teacher.getCourses());

//            for (int i = 0; i < 10; i++) {
//               if (i > 0 && i % 5 == 0) {
//                    entityManager.flush();
//                    entityManager.clear();
//                }
//                Course course = new Course("Курс-" + i, 100 + i);
//                entityManager.persist(course);
//            }
//            String hql = "FROM Teacher ";
//            Query query = entityManager.createQuery(hql);
//            System.out.println(query.getResultList());
//
//            hql = "select c.name from Course c where c.duration=32";
//            query = entityManager.createQuery(hql);
//            System.out.println(query.getResultList());
//
//            hql = "select sum(duration), c.teacher from Course  c where  c.teacher.fio=:fio group by c.teacher";
//            query = entityManager.createQuery(hql);
//            query.setParameter("fio", "Иван Иванович");
//            System.out.println("---group by-->" + query.getResultList());

//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<Student> cr = cb.createQuery(Student.class);
//            Root<Student> root = cr.from(Student.class);
//            cr.select(root);
//            List<Student> result = entityManager.createQuery(cr).getResultList();
//            System.out.println(result);
//
//            cr.select(root).where(cb.equal(root.get("fio"),"Иванов Иван"));
//            result=entityManager.createQuery(cr).getResultList();
//            System.out.println(result);

            String sql = "select ABOUT from  TEACHER where fio=:fio";
            List<Object> teachers = entityManager.createNativeQuery(sql).setParameter("fio", "Иванов Иван").getResultList();
            System.out.println(teachers);

            sql="UPDATE TEACHER set ABOUT=:about where FIO=:fio";
            entityManager.createNativeQuery(sql)
                    .setParameter("about", "стаж преподавания>20лет")
                    .setParameter("fio", "Сидр сидр сидр").executeUpdate();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            factory.close();
        }
    }
}

