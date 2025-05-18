package com.bus.management.repository;

import com.bus.management.model.Trayecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrayectoRepository extends JpaRepository<Trayecto, Long> {

    List<Trayecto> findByOrigenAndDestino(String origen, String destino);
}

