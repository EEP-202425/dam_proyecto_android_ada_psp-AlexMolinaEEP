package com.bus.management.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@Table(name = "trayectos")
public class Trayecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origen;

    private String destino;

    private LocalDateTime fechaHora;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "autobus_id")
    private Autobus autobus;

    @OneToMany(mappedBy = "trayecto", cascade = CascadeType.ALL)
    private List<Reserva> reservas;
}

