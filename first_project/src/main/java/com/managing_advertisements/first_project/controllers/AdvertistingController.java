package com.managing_advertisements.first_project.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.managing_advertisements.first_project.model.advertisting;
import com.managing_advertisements.first_project.model.advertistingAcordingTime;
import com.managing_advertisements.first_project.model.advertistingAcordingViewing;
import com.managing_advertisements.first_project.service.advertistingAcordingTimeService;
import com.managing_advertisements.first_project.service.advertistingAcordingViewingService;

// import lombok.var;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AdvertistingController {
    @Autowired
    private advertistingAcordingTimeService adverTimeSrc;
    @Autowired
    private advertistingAcordingViewingService adverViewSrc;

    @GetMapping("ViewAdvertisting")
    public List<advertisting> viewAllAdverTime() {
        List<advertistingAcordingTime> l1 = adverTimeSrc.getAdvert();
        List<advertistingAcordingViewing> l2=adverViewSrc.getAdvert();
        List<advertisting> AllAdvert = new ArrayList<>();
        AllAdvert.addAll(l1); 
        AllAdvert.addAll(l2);
        if(AllAdvert!=null)
        {
         return AllAdvert;   
        }
        else
        throw new RuntimeException("thattt nulllllllll");
    }
}
