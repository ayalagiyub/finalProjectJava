package com.managing_advertisements.first_project.dto;

import lombok.Data;

@Data
public class advertistingAcordingViewingDTO extends advertistingDTO {
    private int numOfViewsPayed;

    private int numOfViews;

    private String title;

    private String AdvertPicture;

}
