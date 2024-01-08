package com.example.suivie_cours.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullResponse {

    private List<Student> students;

}
