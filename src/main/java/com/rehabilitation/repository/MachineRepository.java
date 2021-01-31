package com.rehabilitation.repository;

import com.rehabilitation.Object.Machine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends CrudRepository<Machine, Integer> {
}
