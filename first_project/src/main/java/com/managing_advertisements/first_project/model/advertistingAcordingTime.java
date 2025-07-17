package com.managing_advertisements.first_project.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class advertistingAcordingTime extends advertisting {
    @Id
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
