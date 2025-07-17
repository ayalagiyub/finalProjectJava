package com.managing_advertisements.first_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.managing_advertisements.first_project.dto.advertistingAcordingViewingDTO;

public interface advertistingAcordingViewingService {
    @Autowired
    public List<advertistingAcordingViewingDTO> getAdvert();

    public void AddViewToCount(advertistingAcordingViewingDTO advert);

    public void save(advertistingAcordingViewingDTO advert);

    public void add(advertistingAcordingViewingDTO advert);
    }
