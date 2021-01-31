package com.rehabilitation.repository;

import com.rehabilitation.Object.Treatment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends CrudRepository<Treatment, Integer> {
    @Query("SELECT t FROM Treatment t WHERE t.treatmentId = :treatment")
    Treatment getTreatmentById(@Param("treatment") int treatmentId);
}
