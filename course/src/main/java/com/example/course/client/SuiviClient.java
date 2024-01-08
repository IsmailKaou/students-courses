package com.example.course.client;

import com.example.course.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "suivie_cours")
public interface SuiviClient{

    @GetMapping("/students/{course-id}")
    List<Student> findAllStudentsByCourseId(
            @PathVariable("course-id") Integer courseId
    );
}
