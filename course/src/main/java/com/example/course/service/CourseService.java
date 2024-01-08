package com.example.course.service;


import com.example.course.client.SuiviClient;
import com.example.course.entity.Course;
import com.example.course.entity.CourseWithStudentsResponse;
import com.example.course.entity.Student;
import com.example.course.repository.CourseRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private    SuiviClient suiviClient;

    public void saveCourse(Course course) {
        repository.save(course);
    }

    public List<Course> findAllCourses() {
        return repository.findAll();
    }



    public CourseWithStudentsResponse findAllStudentsByCourseId(Integer courseId) {
        var course = repository.findById(courseId).orElse(
                Course.builder()
                        .courseName("Course Not Found")
                        .build()
        );

        var students = suiviClient.findAllStudentsByCourseId(courseId);
        return CourseWithStudentsResponse.builder()
                .courseName(course.getCourseName())
                .students(students)
                .build();
    }

    @PostConstruct
public void init(){
        repository.save(Course.builder()
                .courseName("Java")
                .build());
        repository.save(Course.builder()
                .courseName("Spring")
                .build());
        repository.save(Course.builder()
                .courseName("Spring Boot")
                .build());

    }

}
