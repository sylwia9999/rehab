package com.rehabilitation.repository;

import com.rehabilitation.Object.Breakdown;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakdownRepository extends CrudRepository<Breakdown, Integer> {
}
