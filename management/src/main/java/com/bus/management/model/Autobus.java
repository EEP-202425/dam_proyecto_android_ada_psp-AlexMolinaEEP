package com.bus.management.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
@Table(name = "autobuses")
public class Autobus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String matricula;

    private int capacidad;

    private String modelo;

    @OneToMany(mappedBy = "autobus", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Trayecto> trayectos;
}


