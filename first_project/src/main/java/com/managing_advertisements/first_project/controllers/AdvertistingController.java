package com.managing_advertisements.first_project.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.managing_advertisements.first_project.dto.advertistingAcordingTimeDTO;
import com.managing_advertisements.first_project.dto.advertistingAcordingViewingDTO;
import com.managing_advertisements.first_project.dto.advertistingDTO;
import com.managing_advertisements.first_project.model.advertisting;
import com.managing_advertisements.first_project.model.advertistingAcordingTime;
import com.managing_advertisements.first_project.model.advertistingAcordingViewing;
import com.managing_advertisements.first_project.service.advertistingAcordingTimeService;
import com.managing_advertisements.first_project.service.advertistingAcordingViewingService;

// import lombok.var;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AdvertistingController {
    @Autowired
    private advertistingAcordingTimeService adverTimeSrc;
    @Autowired
    private advertistingAcordingViewingService adverViewSrc;

    //הוספת פרסומת לפי כמות זמן
    @PostMapping("AddAdvertAcordingTime")
    public String postMethodName(@RequestBody advertistingAcordingTimeDTO advert) {
        adverTimeSrc.add(advert);
        return "succeed";
    }

    //הוספת פרסומת לפי מספר צפיות  
    @PostMapping("AddAdvertAcordingViewing")
    public String postMethodName(@RequestBody advertistingAcordingViewingDTO advert) {
        adverViewSrc.AddViewToCount(advert);
        adverViewSrc.add(advert);
        return "succeed";
    }

    @GetMapping("ViewAdvertisting")
    public List<advertistingDTO> viewAllAdverTime() {
        List<advertistingAcordingTimeDTO> l1 = adverTimeSrc.getAdvert();
        List<advertistingAcordingViewingDTO> l2 = adverViewSrc.getAdvert();
        List<advertistingDTO> AllAdvert = new ArrayList<>();
        AllAdvert.addAll(l1);
        AllAdvert.addAll(l2);
        if (AllAdvert != null) {
            return AllAdvert;
        } else
            throw new RuntimeException("thattt nulllllllll");
    }
}
