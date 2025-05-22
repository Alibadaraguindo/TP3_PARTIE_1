package net.ali.tp3_partie1.repositories;

import net.ali.tp3_partie1.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page <Patient> findByNomContains(String keyword, Pageable pageable);


}
