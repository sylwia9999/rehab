package com.rehabilitation.repository;

import com.rehabilitation.Object.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface TreatmentScheduleRepository extends CrudRepository<TreatmentSchedule, Integer> {
    @Query("SELECT t FROM TreatmentSchedule t WHERE t.treatment = :treatment")
    TreatmentSchedule getById(@Param("treatment") Treatment treatmentId);
}
