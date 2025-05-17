package com.bus.management.service;

import com.bus.management.model.Autobus;
import java.util.List;

public interface AutobusService {
    Autobus crearAutobus(Autobus autobus);
    List<Autobus> obtenerTodos();
    Autobus obtenerPorId(Long id);
    Autobus actualizarAutobus(Long id, Autobus autobus);
    void eliminarAutobus(Long id);
}

