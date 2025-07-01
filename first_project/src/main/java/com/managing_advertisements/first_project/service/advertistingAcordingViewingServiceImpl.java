package com.managing_advertisements.first_project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.managing_advertisements.first_project.dal.advertistingAcordingViewingRepository;
import com.managing_advertisements.first_project.model.advertistingAcordingViewing;

@Service
@SessionScope
public class advertistingAcordingViewingServiceImpl implements advertistingAcordingViewingService {
    @Autowired
    private advertistingAcordingViewingRepository advertRep;
    LocalDateTime lastTime = null;

    @Override
    public List<advertistingAcordingViewing> getAdvert() {
        return (List<advertistingAcordingViewing>) advertRep.findAll();
    }

    // פונקציה שמוסיפה מספר צפיות אם עברו 10 דקות
    public void AddViewToCount(advertistingAcordingViewing advert) {
        if (lastTime == null || LocalDateTime.now().isAfter(lastTime.plusMinutes(10))) {
            advert.setNumOfViews(advert.getNumOfViews() + 1);
            lastTime = LocalDateTime.now();
            advertRep.save(advert);
        }
    }
}
