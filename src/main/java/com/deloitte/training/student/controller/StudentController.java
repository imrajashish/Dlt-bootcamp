package com.deloitte.training.student.controller;


import com.deloitte.training.student.model.StudentDto;
import com.deloitte.training.student.model.StudentResponse;
import com.deloitte.training.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id) {
        StudentResponse student = studentService.getStudentResponseById(id);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid StudentDto studentDto){
        StudentDto savedStudent = studentService.saveStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/list/{name}")
    public ResponseEntity<List<StudentResponse>> getStudentByName(@PathVariable String name) {
        List<StudentResponse> student = studentService.getStudentResponseByName(name);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping(
            value = "/{id}",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable Long id,
            @RequestBody @Valid StudentDto studentDto) {

        StudentDto updatedStudent =
                studentService.updateStudentById(id, studentDto);

        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {

        boolean deleted = studentService.deleteStudentById(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
