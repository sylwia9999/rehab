package com.rehabilitation.repository;

import com.rehabilitation.Object.Treatment;
import com.rehabilitation.Object.TreatmentType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentTypeRepository extends CrudRepository<TreatmentType, Integer> {
    @Query("SELECT t FROM TreatmentType t WHERE t.treatmentTypeId = :treatment")
    TreatmentType getTreatmentTypeById(@Param("treatment") int treatmentTypeId);
}
