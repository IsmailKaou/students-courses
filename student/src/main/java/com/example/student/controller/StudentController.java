package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        service.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(service.findAllStudents());
    }



    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudentsBySchoolId(
            @PathVariable("school-id") Integer schoolId
    ){
        return ResponseEntity.ok(service.findAllStudentsBySchoolId(schoolId));
    }

    @GetMapping("/course/{course-id}")
    public ResponseEntity<List<Student>> findAllStudentsByCourseId(
            @PathVariable("course-id") Integer courseId
    ){
        return ResponseEntity.ok(service.findAllStudentsByCourseId(courseId));
    }
}
