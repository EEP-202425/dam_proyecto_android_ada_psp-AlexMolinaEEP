package com.bus.management.service;

import com.bus.management.model.Autobus;
import com.bus.management.repository.AutobusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutobusServiceImpl implements AutobusService {

    @Autowired
    private AutobusRepository autobusRepository;

    @Override
    public Autobus crearAutobus(Autobus autobus) {
        return autobusRepository.save(autobus);
    }

    @Override
    public List<Autobus> obtenerTodos() {
        return autobusRepository.findAll();
    }

    @Override
    public Autobus obtenerPorId(Long id) {
        return autobusRepository.findById(id).orElse(null);
    }

    @Override
    public Autobus actualizarAutobus(Long id, Autobus autobus) {
        Autobus existente = obtenerPorId(id);
        if (existente != null) {
            existente.setMatricula(autobus.getMatricula());
            existente.setCapacidad(autobus.getCapacidad());
            existente.setModelo(autobus.getModelo());
            return autobusRepository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminarAutobus(Long id) {
        autobusRepository.deleteById(id);
    }
}

