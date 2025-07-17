package com.managing_advertisements.first_project.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.managing_advertisements.first_project.dal.advertistingAcordingViewingRepository;
import com.managing_advertisements.first_project.dto.advertistingAcordingViewingDTO;
import com.managing_advertisements.first_project.model.advertistingAcordingViewing;

@Service
@SessionScope
public class advertistingAcordingViewingServiceImpl implements advertistingAcordingViewingService {
    @Autowired
    private advertistingAcordingViewingRepository advertRep;

    @Autowired
    private ModelMapper mapper;
    
    LocalDateTime lastTime = null;

//בדפדפן קודם כל אני אעשה בדיקה ורק אחכ GET של כל הפרסומות

    // פונקציה שמוסיפה מספר צפיות אם עברו 10 דקות
    @Override
    public void AddViewToCount(advertistingAcordingViewingDTO advert) {
        if (lastTime == null || LocalDateTime.now().isAfter(lastTime.plusMinutes(10))) {
            advertistingAcordingViewing entity=mapper.map(advert, advertistingAcordingViewing.class);
            entity.setNumOfViews(entity.getNumOfViews() + 1);
            lastTime = LocalDateTime.now();
            advertRep.save(entity);
            // IsToShow(advert);
        }
    }


    @Override
    public List<advertistingAcordingViewingDTO> getAdvert() {
        List<advertistingAcordingViewing>allAds=new ArrayList<>();
        advertRep.findAll().forEach(allAds::add);
        List<advertistingAcordingViewing>ll= allAds.stream()
        .filter(this::IsToShow) // רק פרסומות שעדיין בתוקף
        .toList();

         List<advertistingAcordingViewingDTO> dtoList = ll.stream()
        .map(entity -> mapper.map(entity, advertistingAcordingViewingDTO.class))
        .toList();

        return dtoList;
    }

    //בדיקה האם עדיין להציג את הפרסומת
    public boolean IsToShow(advertistingAcordingViewing advert)
    {
        if(advert.getNumOfViews()<=advert.getNumOfViewsPayed())
        {
            return true;
        }
        return false;
    }


    @Override
    public void save(advertistingAcordingViewingDTO advert) {
        advertRep.save(mapper.map(advert,advertistingAcordingViewing.class));
    }


    @Override
    public void add(advertistingAcordingViewingDTO advert) {
        advertRep.save(mapper.map(advert,advertistingAcordingViewing.class));
        // throw new UnsupportedOperationException("Unimplemented method 'add'");
    }


}
