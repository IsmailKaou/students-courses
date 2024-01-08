package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    public List<Student> findAllStudentsBySchoolId(Integer schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }

    public List<Student> findAllStudentsByCourseId(Integer courseId) {
        return repository.findAllBySchoolId(courseId);
    }

    @PostConstruct
    public void init() {
        repository.save(Student.builder()
                .name("Student 1")
                .email("student1@gmail.com")
                .schoolId(1)
                .courseId(1)
                .build());

        repository.save(Student.builder()
                .name("Student 2")
                .email("student2@gmail.com")
                .schoolId(1)
                .courseId(1)
                .build());

        repository.save(Student.builder()
                .name("Student 3")
                .email("student3@gmail.com")
                .schoolId(1)
                .courseId(1)
                .build());

        repository.save(Student.builder()
                .name("Student 4")
                .email("student4@gmail.com")
                .schoolId(1)
                .courseId(2)
                .build());
        repository.save(Student.builder()
                .name("Student 5")
                .email("student5@gmail.com")
                .schoolId(1)
                .courseId(2)
                .build());

        repository.save(Student.builder()
                .name("Student 6")
                .email("student6@gmail.com")
                .schoolId(1)
                .courseId(3)
                .build());

    }
}
