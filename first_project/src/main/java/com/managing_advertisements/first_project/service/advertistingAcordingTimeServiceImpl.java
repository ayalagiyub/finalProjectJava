package com.managing_advertisements.first_project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.managing_advertisements.first_project.dal.advertistingAcordingTimeRepository;
import com.managing_advertisements.first_project.model.advertistingAcordingTime;


@Service
public class advertistingAcordingTimeServiceImpl implements advertistingAcordingTimeService {
    @Autowired
    advertistingAcordingTimeRepository adverRepo;

    @Override
    public List<advertistingAcordingTime> getAdvert() {
        return (List<advertistingAcordingTime>) adverRepo.findAll();
    }


}
