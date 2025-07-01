package com.managing_advertisements.first_project.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Customer{
@Id
private int id;
@Column
private String name;
}
