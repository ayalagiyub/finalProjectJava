package com.managing_advertisements.first_project.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.managing_advertisements.first_project.dto.advertistingAcordingTimeDTO;
import com.managing_advertisements.first_project.dal.advertistingAcordingTimeRepository;
import com.managing_advertisements.first_project.model.advertistingAcordingTime;

@SessionScope
@Service
public class advertistingAcordingTimeServiceImpl implements advertistingAcordingTimeService {
    @Autowired
    advertistingAcordingTimeRepository adverRepo;

    @Autowired
    private ModelMapper mapper;

    private boolean isStillActive(advertistingAcordingTime ad) {
        if (!ad.isActive()) {
            return false;
        }
        LocalDateTime endTime = ad.getStartTime().plusMinutes(ad.getMinutes());
        boolean stillValid = LocalDateTime.now().isBefore(endTime);
        // אופציונלי: לעדכן אם הזמן עבר
        if (!stillValid) {
            ad.setActive(false);
            adverRepo.save(ad);
        }
        return stillValid;
    }

    @Override
    public List<advertistingAcordingTimeDTO> getAdvert() {
        List<advertistingAcordingTime> allAds = new ArrayList<>();
        adverRepo.findAll().forEach(allAds::add);
        List<advertistingAcordingTime> ll = allAds.stream()
                .filter(ad -> isStillActive(ad))
                .toList();
        List<advertistingAcordingTimeDTO> listdto = ll.stream()
                .map(entity -> mapper.map(entity, advertistingAcordingTimeDTO.class))
                .toList();
        return listdto;
    }

    @Override
    public void save(advertistingAcordingTimeDTO advert) {
        adverRepo.save(mapper.map(advert, advertistingAcordingTime.class));
    }

    @Override
    public void add(advertistingAcordingTimeDTO advert) {
        advertistingAcordingTime entity=mapper.map(advert, advertistingAcordingTime.class);
        entity.setActive(true);
        entity.setStartTime(LocalDateTime.now());
    }
}

// //לזמן בקונטרולר לפני ה GET
// public void checkStatus(advertistingAcordingTime advert) {
// Timer timer = new Timer();
// timer.schedule(new TimerTask() {
// @Override
// public void run() {
// // .... what we need...
// advert.setActive(false);
// adverRepo.save(advert);
// }
// }, advert.getMinutes() * 60000);
// }