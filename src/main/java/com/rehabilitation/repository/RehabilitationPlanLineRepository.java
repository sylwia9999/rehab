package com.rehabilitation.repository;

import com.rehabilitation.Object.RehabilitationPlanLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RehabilitationPlanLineRepository extends CrudRepository<RehabilitationPlanLine, Integer> {
}