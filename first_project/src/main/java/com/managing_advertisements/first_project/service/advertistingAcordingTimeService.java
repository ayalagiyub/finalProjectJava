package com.managing_advertisements.first_project.service;

import java.util.List;

import com.managing_advertisements.first_project.dto.advertistingAcordingTimeDTO;




public interface advertistingAcordingTimeService {
    
public List <advertistingAcordingTimeDTO> getAdvert();

public void save(advertistingAcordingTimeDTO advert);

public void add(advertistingAcordingTimeDTO advert);

} 