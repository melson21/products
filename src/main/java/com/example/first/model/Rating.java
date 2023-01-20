package com.example.first.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length=1000)
    private Double rate;

    @Column(length=1000)
    private Double count;

}
