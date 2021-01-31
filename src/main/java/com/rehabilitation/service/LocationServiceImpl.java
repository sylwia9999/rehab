package com.rehabilitation.service;

import com.rehabilitation.Dto.LocationResponse;
import com.rehabilitation.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationResponse> getAll() {
        return StreamSupport.stream(locationRepository.findAll().spliterator(), false)
                .map(location -> new LocationResponse(location.getLocationId(), location.getCity(), location.getAddress()))
                .collect(Collectors.toList());
    }

}
