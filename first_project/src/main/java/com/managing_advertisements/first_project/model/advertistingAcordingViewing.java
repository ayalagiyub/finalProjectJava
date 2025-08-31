package com.managing_advertisements.first_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
// import lombok.Data;
import lombok.Data;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "id_Advert")

@Data
public class advertistingAcordingViewing extends advertising {
    @Column
    int numOfViewsPayed;

    @Column
    private int numOfViews;

    @Column
    private String title;

    @Column
    private String AdvertPicture;
}