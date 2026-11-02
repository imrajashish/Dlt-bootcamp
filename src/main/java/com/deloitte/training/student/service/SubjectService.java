
package com.deloitte.training.student.service;

import com.deloitte.training.student.entity.Subject;
import com.deloitte.training.student.model.SubjectDto;
import com.deloitte.training.student.model.SubjectResponse;
import com.deloitte.training.student.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    // POST - Create Subject
    public SubjectDto saveSubject(SubjectDto subjectDto) {

        log.info("Inside SubjectService.saveSubject()");

        Subject subject = convertDtoToEntity(subjectDto);

        Subject savedSubject = subjectRepository.save(subject);

        return convertEntityToDto(savedSubject);
    }

    // GET - Get All Subjects
    public List<SubjectResponse> getAllSubjects() {

        log.info("Inside SubjectService.getAllSubjects()");

        List<Subject> subjects = subjectRepository.findAll();

        return subjects.stream()
                .map(this::convertEntityToResponse)
                .toList();
    }

    // GET - Get Subject By ID
    public SubjectResponse getSubjectById(Long id) {

        Optional<Subject> optionalSubject =
                subjectRepository.findById(id);

        if (optionalSubject.isPresent()) {

            Subject subject = optionalSubject.get();

            return convertEntityToResponse(subject);
        }

        return null;
    }

    // PUT - Update Subject By ID
    public SubjectDto updateSubjectById(
            Long id, SubjectDto subjectDto) {

        log.info("Inside SubjectService.updateSubjectById()");

        Optional<Subject> optionalSubject =
                subjectRepository.findById(id);

        if (optionalSubject.isPresent()) {

            Subject subject = optionalSubject.get();

            subject.setName(subjectDto.getName());
            subject.setCode(subjectDto.getCode());
            subject.setDescription(subjectDto.getDescription());

            Subject updatedSubject =
                    subjectRepository.save(subject);

            return convertEntityToDto(updatedSubject);
        }

        return null;
    }

    // DELETE - Delete Subject By ID
    public boolean deleteSubjectById(Long id) {

        log.info("Inside SubjectService.deleteSubjectById()");

        Optional<Subject> optionalSubject =
                subjectRepository.findById(id);

        if (optionalSubject.isPresent()) {

            subjectRepository.deleteById(id);

            return true;
        }

        return false;
    }

    // DTO TO ENTITY
    private Subject convertDtoToEntity(SubjectDto subjectDto) {

        Subject subject = new Subject();

        subject.setName(subjectDto.getName());
        subject.setCode(subjectDto.getCode());
        subject.setDescription(subjectDto.getDescription());

        return subject;
    }

    // ENTITY TO DTO
    private SubjectDto convertEntityToDto(Subject subject) {

        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setCode(subject.getCode());
        subjectDto.setDescription(subject.getDescription());

        return subjectDto;
    }

    // ENTITY TO RESPONSE
    private SubjectResponse convertEntityToResponse(
            Subject subject) {

        SubjectResponse subjectResponse =
                new SubjectResponse();

        subjectResponse.setId(subject.getId());
        subjectResponse.setName(subject.getName());
        subjectResponse.setCode(subject.getCode());
        subjectResponse.setDescription(subject.getDescription());

        return subjectResponse;
    }
}
