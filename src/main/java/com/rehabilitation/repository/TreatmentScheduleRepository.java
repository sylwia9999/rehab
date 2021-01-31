package com.rehabilitation.repository;

import com.rehabilitation.Object.TreatmentSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentScheduleRepository extends CrudRepository<TreatmentSchedule, Integer> {
}
