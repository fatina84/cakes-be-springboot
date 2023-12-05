package com.psw.servizi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.engine.jdbc.SerializableBlobProxy;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cake")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cake implements Serializable {

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
