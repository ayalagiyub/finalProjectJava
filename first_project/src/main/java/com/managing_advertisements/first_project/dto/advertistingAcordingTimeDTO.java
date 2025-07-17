package com.managing_advertisements.first_project.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class advertistingAcordingTimeDTO extends advertistingDTO {

    private int minutes;

    private LocalDateTime startTime;

    private boolean active;

    private String title;

    private String AdvertPicture;

}
