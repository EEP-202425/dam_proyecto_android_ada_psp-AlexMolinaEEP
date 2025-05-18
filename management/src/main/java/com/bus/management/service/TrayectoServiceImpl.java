package com.bus.management.service;

import com.bus.management.model.Trayecto;
import com.bus.management.repository.TrayectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrayectoServiceImpl implements TrayectoService {

    @Autowired
    private TrayectoRepository trayectoRepository;

    @Override
    public Trayecto crearTrayecto(Trayecto trayecto) {
        return trayectoRepository.save(trayecto);
    }

    @Override
    public List<Trayecto> obtenerTodos() {
        return trayectoRepository.findAll();
    }

    @Override
    public Trayecto obtenerPorId(Long id) {
        return trayectoRepository.findById(id).orElse(null);
    }

    @Override
    public Trayecto actualizarTrayecto(Long id, Trayecto trayecto) {
        Trayecto existente = obtenerPorId(id);
        if (existente != null) {
            existente.setOrigen(trayecto.getOrigen());
            existente.setDestino(trayecto.getDestino());
            existente.setFechaHora(trayecto.getFechaHora());
            return trayectoRepository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminarTrayecto(Long id) {
        trayectoRepository.deleteById(id);
    }
}

