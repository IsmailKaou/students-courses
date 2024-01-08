package com.example.suivie_cours.controller;

import com.example.suivie_cours.model.FullResponse;
import com.example.suivie_cours.service.SuiviCoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/suivi_cours")
@RequiredArgsConstructor
public class SuiviCoursController {

    private final SuiviCoursService suiviCoursService;


    @GetMapping("/students/{course-id}")
    public List<FullResponse> getStudentCourses(@PathVariable("course-id") Integer courseId){
        suiviCoursService.findAllStudentByCourseId(courseId);
        return null;
    }


}
