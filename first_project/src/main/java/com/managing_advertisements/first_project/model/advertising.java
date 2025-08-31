package com.managing_advertisements.first_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class advertising {
    //בכוונה ריק
    @Id
    private int id_Advert;
    @Column
    private int idCustomer;
    @ManyToOne
    @JoinColumn(name = "idCustomer",insertable = false,updatable = false )
    private Customer customer;
}
