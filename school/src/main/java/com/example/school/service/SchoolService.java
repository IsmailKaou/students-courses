package com.example.school.service;

import com.example.school.client.StudentClient;
import com.example.school.entity.FullSchoolResponse;
import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;

    private final StudentClient studentClient;

    public void saveSchool(School school) {
        repository.save(school);
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse findAllSchoolsWithStudents(Integer schoolId) {

        var school = repository.findById(schoolId).orElse(
                School.builder()
                        .name("School not found")
                        .email("School not found")
                        .build()
        );

        var students = studentClient.findAllStudentsBySchoolId(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();

    }
}
