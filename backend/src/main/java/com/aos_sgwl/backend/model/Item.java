package com.aos_sgwl.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;


@Entity

@Table(name = "item")

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 150)
    private String name;

    @Positive
    @Column(nullable = false)
    private double preco;

    @Column(length = 20)
    private String prioridade;

    @Column(nullable = false)
    private boolean comprado = false;

}
