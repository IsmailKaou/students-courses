package com.example.suivie_cours.service;

import com.example.suivie_cours.client.StudentClient;
import com.example.suivie_cours.model.FullResponse;
import com.example.suivie_cours.model.Student;
import com.example.suivie_cours.model.SuiviCours;
import com.example.suivie_cours.repository.SuiviCoursRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuiviCoursService {
    private final SuiviCoursRepository suiviCoursRepository;
    private  StudentClient studentClient;

    public FullResponse findAllStudentByCourseId(Integer courseId) {


        var students = studentClient.findAllStudentsByCourseId(courseId);
        return FullResponse.builder()
                .students(students)
                .build();

    }

    @PostConstruct
    public void init(){
        suiviCoursRepository.save(
                SuiviCours.builder()
                        .courseId(1)
                        .studentId(1)
                        .build()
        );
        suiviCoursRepository.save(
                SuiviCours.builder()
                        .courseId(1)
                        .studentId(2)
                        .build()
        );
        suiviCoursRepository.save(
                SuiviCours.builder()
                        .courseId(2)
                        .studentId(1)
                        .build()
        );
        suiviCoursRepository.save(
                SuiviCours.builder()
                        .courseId(2)
                        .studentId(2)
                        .build()
        );
    }

}
