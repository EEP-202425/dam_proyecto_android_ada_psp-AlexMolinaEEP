package com.bus.management.repository;

import com.bus.management.model.Autobus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutobusRepository extends JpaRepository<Autobus, Long> {

    Autobus findByMatricula(String matricula);
}

