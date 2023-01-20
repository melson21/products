package com.example.first.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Products {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Double price;

    @Column(length=1000)
    private String description;

    @Column(length=1000)
    private String category;

    @Column(length=1000)
    private String image;

    @OneToOne(cascade = {CascadeType.ALL})
    private Rating rating;

}
