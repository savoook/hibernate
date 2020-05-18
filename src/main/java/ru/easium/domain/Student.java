package ru.easium.domain;

import javafx.scene.chart.PieChart;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fio")
    private String name;
    @Column(name = "birth")
    private Date birthDate;
    @Column(name = "score")
    private long score;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Course> courses;

    public Student() {
    }

    public Student(String name, Date birthDate, long score, List<Course> courses) {
        this.name = name;
        this.birthDate = birthDate;
        this.score = score;
        this.courses = courses;
    }
}
