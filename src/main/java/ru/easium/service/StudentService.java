package ru.easium.service;

import ru.easium.dao.StudentDAO;
import ru.easium.domain.Student;

import java.util.List;

public class StudentService {
    private StudentDAO dao = new StudentDAO();

    public Student findStudent(int id) {
        return dao.findById(id);
    }

    public List<Student> findAllStudent() {
        return dao.findAll();
    }

    public void saveStudent(Student student) {
        dao.save(student);
    }
}
