package com.example.course.controller;

import com.example.course.entity.Course;
import com.example.course.entity.CourseWithStudentsResponse;
import com.example.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course) {
        service.saveCourse(course);
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAllCourses() {
        return ResponseEntity.ok(service.findAllCourses());
    }



    @GetMapping("/find-Students-by-course/{course-id}")
    public ResponseEntity<CourseWithStudentsResponse> findAllStudentsByCourseId(
            @PathVariable("course-id") Integer courseId
    ){
        return ResponseEntity.ok(service.findAllStudentsByCourseId(courseId));
    }
}
