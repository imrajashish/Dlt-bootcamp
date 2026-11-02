package com.deloitte.training.student.model;

import lombok.Data;

@Data
public class Course {
    private Integer id;
    private String name;
    private String description;
    private int durationInHours;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", durationInHours=" + durationInHours +
                '}';
    }
}
