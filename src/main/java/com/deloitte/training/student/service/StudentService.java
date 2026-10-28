package com.deloitte.training.student.service;

import com.deloitte.training.student.entity.Student;
import com.deloitte.training.student.model.StudentDto;
import com.deloitte.training.student.model.StudentResponse;
import com.deloitte.training.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j

public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentDto saveStudent(StudentDto studentDto) {
        System.out.println("Inside StudentService.saveStudent() method");
        Student student = convertStudentDtoTOEntity(studentDto);
        Student updatedStudent = studentRepository.save(student);
        return convertStudentEntityToDto(updatedStudent);
    }

    private StudentDto convertStudentEntityToDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setAge(student.getAge());
        return  studentDto;
    }

    public StudentResponse getStudentResponseById(Long id) {
        Optional<Student> optionalStudent =studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            return convertStudentEntityToResponse(student);
        }
        return null;
    }


    private Student convertStudentDtoTOEntity(StudentDto studentDto){
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());
        return  student;
    }

    private StudentResponse convertStudentEntityToResponse(Student student){
        StudentResponse studentDto = new StudentResponse();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setAge(student.getAge());

        return  studentDto;
    }
}
