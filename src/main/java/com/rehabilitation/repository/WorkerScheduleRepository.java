package com.rehabilitation.repository;

import com.rehabilitation.Object.WorkerSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerScheduleRepository extends CrudRepository<WorkerSchedule, Integer> {
}
