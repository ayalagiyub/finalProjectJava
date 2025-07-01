package com.managing_advertisements.first_project.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import lombok.Data;
import lombok.Data;

@Entity
@Table
@Data
public class advertistingAcordingViewing extends advertisting{
@Id
int numOfViews;
}