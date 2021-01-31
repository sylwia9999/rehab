package com.rehabilitation.repository;

import com.rehabilitation.Object.RehabilitationPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RehabilitationPlanRepository extends CrudRepository<RehabilitationPlan, Integer> {
}
