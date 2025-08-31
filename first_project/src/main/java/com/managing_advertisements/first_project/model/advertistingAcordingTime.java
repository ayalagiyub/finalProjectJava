package com.managing_advertisements.first_project.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "id_Advert")
@Data
public class advertistingAcordingTime extends advertising {
    @Column
    int minutes;

    @Column(nullable = true)
    private LocalDateTime startTime;

    @Column
    private boolean active;

    @Column
    private String title;

    @Column
    private String AdvertPicture;
}
