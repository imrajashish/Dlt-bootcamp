
package com.deloitte.training.student.controller;

import com.deloitte.training.student.model.SubjectDto;
import com.deloitte.training.student.model.SubjectResponse;
import com.deloitte.training.student.service.SubjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@Tag(name = "Subject API",
        description = "Subject CRUD Operations")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    // GET ALL SUBJECTS
    @GetMapping
    @Operation(summary = "Get all subjects")
    public ResponseEntity<List<SubjectResponse>>
    getAllSubjects() {

        List<SubjectResponse> subjects =
                subjectService.getAllSubjects();

        return new ResponseEntity<>(
                subjects, HttpStatus.OK);
    }

    // GET SUBJECT BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Get subject by ID")
    public ResponseEntity<SubjectResponse>
    getSubjectById(@PathVariable Long id) {

        SubjectResponse subject =
                subjectService.getSubjectById(id);

        if (subject != null) {
            return new ResponseEntity<>(
                    subject, HttpStatus.OK);
        }

        return new ResponseEntity<>(
                HttpStatus.NOT_FOUND);
    }

    // CREATE SUBJECT
    @PostMapping(
            produces = "application/json",
            consumes = "application/json")
    @Operation(summary = "Create a new subject")
    public ResponseEntity<SubjectDto>
    createSubject(
            @RequestBody @Valid SubjectDto subjectDto) {

        SubjectDto savedSubject =
                subjectService.saveSubject(subjectDto);

        return new ResponseEntity<>(
                savedSubject, HttpStatus.CREATED);
    }

    // UPDATE SUBJECT
    @PutMapping(
            value = "/{id}",
            produces = "application/json",
            consumes = "application/json")
    @Operation(summary = "Update subject by ID")
    public ResponseEntity<SubjectDto>
    updateSubject(
            @PathVariable Long id,
            @RequestBody @Valid SubjectDto subjectDto) {

        SubjectDto updatedSubject =
                subjectService.updateSubjectById(
                        id, subjectDto);

        if (updatedSubject != null) {
            return new ResponseEntity<>(
                    updatedSubject, HttpStatus.OK);
        }

        return new ResponseEntity<>(
                HttpStatus.NOT_FOUND);
    }

    // DELETE SUBJECT
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete subject by ID")
    public ResponseEntity<Void>
    deleteSubject(@PathVariable Long id) {

        boolean deleted =
                subjectService.deleteSubjectById(id);

        if (deleted) {
            return new ResponseEntity<>(
                    HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(
                HttpStatus.NOT_FOUND);
    }
}
