package com.bus.management.service;

import com.bus.management.model.Reserva;
import java.util.List;

public interface ReservaService {
    Reserva crearReserva(Reserva reserva);
    List<Reserva> obtenerTodos();
    Reserva obtenerPorId(Long id);
    void eliminarReserva(Long id);
}
