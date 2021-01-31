package com.rehabilitation.repository;

import com.rehabilitation.Object.TreatmentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentTypeRepository extends CrudRepository<TreatmentType, Integer> {
}
