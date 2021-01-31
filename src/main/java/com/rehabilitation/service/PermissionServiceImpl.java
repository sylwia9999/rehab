package com.rehabilitation.service;

import com.rehabilitation.Dto.PermissionResponse;
import com.rehabilitation.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<PermissionResponse> getAll() {
        return StreamSupport.stream(permissionRepository.findAll().spliterator(), false)
                .map(permission -> new PermissionResponse(permission.getPermission_id(), permission.getTreatmentType().getTreatment_type_id(), permission.getWorker().getUserId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PermissionResponse> getAllForWorker(int workerId) {
         return StreamSupport.stream(permissionRepository.findAll().spliterator(), false)
                .map(permission -> new PermissionResponse(permission.getPermission_id(), permission.getTreatmentType().getTreatment_type_id(), permission.getWorker().getUserId()))
                .filter(permissionResponse -> permissionResponse.getWorker() == workerId)
                .collect(Collectors.toList());
    }

    @Override
    public List<PermissionResponse> getAllForTreatment(int treatmentTypeId) {
        return StreamSupport.stream(permissionRepository.findAll().spliterator(), false)
                .map(permission -> new PermissionResponse(permission.getPermission_id(), permission.getTreatmentType().getTreatment_type_id(), permission.getWorker().getUserId()))
                .filter(permissionResponse -> permissionResponse.getTreatmentType() == treatmentTypeId)
                .collect(Collectors.toList());
    }
}
