package com.managing_advertisements.first_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.managing_advertisements.first_project.model.advertistingAcordingViewing;

public interface advertistingAcordingViewingService {
    @Autowired
    public List<advertistingAcordingViewing> getAdvert();
    }
