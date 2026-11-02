package com.deloitte.training.student.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private int age;
    Integer courseId;

    public Integer getCourseId() {
        return courseId;
    }

    public  void setCourseId(Integer courseId){
        this.courseId = courseId;
    }

    private String updatedBy;

    // Constructors
    public Student() {}

    public Student(String name, String email, int age, int courseId) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.courseId = courseId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

}