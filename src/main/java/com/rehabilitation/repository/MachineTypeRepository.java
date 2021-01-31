package com.rehabilitation.repository;

import com.rehabilitation.Object.MachineType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineTypeRepository extends CrudRepository<MachineType, Integer> {
}
