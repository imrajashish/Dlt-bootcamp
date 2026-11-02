package com.deloitte.training.student.repository;

import com.deloitte.training.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    @Query("SELECT s FROM Student s WHERE s.name = :name")
    List<Student> findByName(@Param("name") String name);

}
