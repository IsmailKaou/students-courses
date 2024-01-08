package com.example.suivie_cours.repository;

import com.example.suivie_cours.model.SuiviCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuiviCoursRepository extends JpaRepository<SuiviCours, Integer>{
}
