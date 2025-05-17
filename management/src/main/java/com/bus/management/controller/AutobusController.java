package com.bus.management.controller;

import com.bus.management.model.Autobus;
import com.bus.management.service.AutobusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autobuses")
public class AutobusController {

    @Autowired
    private AutobusService autobusService;

    @PostMapping
    public ResponseEntity<Autobus> crearAutobus(@RequestBody Autobus autobus) {
        return ResponseEntity.ok(autobusService.crearAutobus(autobus));
    }

    @GetMapping
    public List<Autobus> obtenerTodos() {
        return autobusService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autobus> obtenerPorId(@PathVariable Long id) {
        Autobus autobus = autobusService.obtenerPorId(id);
        return autobus != null ? ResponseEntity.ok(autobus) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autobus> actualizarAutobus(@PathVariable Long id, @RequestBody Autobus autobus) {
        Autobus actualizado = autobusService.actualizarAutobus(id, autobus);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAutobus(@PathVariable Long id) {
        autobusService.eliminarAutobus(id);
        return ResponseEntity.noContent().build();
    }
}

