package com.psw.servizi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "cake")
@Data
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "occasion")
    private String occasion;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private double  weight;

    @Column(name = "numberportions")
    private int  numberportions;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;

    @Column(name = "img")
    private String img;
}
