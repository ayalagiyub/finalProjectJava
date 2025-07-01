package com.managing_advertisements.first_project.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.managing_advertisements.first_project.model.advertistingAcordingTime;

@Repository
public interface advertistingAcordingTimeRepository extends CrudRepository<advertistingAcordingTime,Integer> {
    
}
