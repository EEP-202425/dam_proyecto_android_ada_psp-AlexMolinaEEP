package com.bus.management.service;

import com.bus.management.model.Trayecto;
import java.util.List;

public interface TrayectoService {
    Trayecto crearTrayecto(Trayecto trayecto);
    List<Trayecto> obtenerTodos();
    Trayecto obtenerPorId(Long id);
    Trayecto actualizarTrayecto(Long id, Trayecto trayecto);
    void eliminarTrayecto(Long id);
}

