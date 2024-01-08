package com.example.suivie_cours.client;

import com.example.suivie_cours.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "students",url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/course/{course-id}")
    List<Student> findAllStudentsByCourseId(
            @PathVariable("course-id") Integer courseId
    );

}
