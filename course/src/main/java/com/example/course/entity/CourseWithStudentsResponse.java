package com.example.course.entity;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseWithStudentsResponse {

    private String courseName;
    private List<Student> students;
}
