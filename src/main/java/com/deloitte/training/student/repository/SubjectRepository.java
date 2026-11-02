
package com.deloitte.training.student.repository;

import com.deloitte.training.student.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository
        extends JpaRepository<Subject, Long> {

    boolean existsByCode(String code);
}
