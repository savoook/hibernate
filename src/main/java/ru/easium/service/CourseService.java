package ru.easium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.easium.dao.CourseDAO;
import ru.easium.domain.Course;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseDAO dao;

    public Course findById(int id) {
        return dao.findById(id);
    }

    public List<Course> findAllCourses() {
        return dao.findAll();
    }

    public void saveCourse(Course course) {
        dao.save(course);
    }
}

