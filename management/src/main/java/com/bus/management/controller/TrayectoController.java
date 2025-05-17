package com.bus.management.controller;

import com.bus.management.model.Autobus;
import com.bus.management.model.Trayecto;
import com.bus.management.service.TrayectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trayectos")
public class TrayectoController {

    @Autowired
    private TrayectoService trayectoService;

    @PostMapping
    public ResponseEntity<Trayecto> crearTrayecto(@RequestBody Trayecto trayecto) {
        return ResponseEntity.ok(trayectoService.crearTrayecto(trayecto));
    }

    @GetMapping
    public List<Trayecto> obtenerTodos() {
        return trayectoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trayecto> obtenerPorId(@PathVariable Long id) {
        Trayecto trayecto = trayectoService.obtenerPorId(id);
        return trayecto != null ? ResponseEntity.ok(trayecto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trayecto> actualizarTrayecto(@PathVariable Long id, @RequestBody Trayecto trayecto) {
        Trayecto actualizado = trayectoService.actualizarTrayecto(id, trayecto);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTrayecto(@PathVariable Long id) {
        trayectoService.eliminarTrayecto(id);
        return ResponseEntity.noContent().build();
        
    }
    
    @PutMapping("/{id}/asignar-autobus")
    public ResponseEntity<Trayecto> asignarAutobus(
            @PathVariable Long id,
            @RequestBody Autobus autobus
    ) {
        Trayecto trayecto = trayectoService.obtenerPorId(id);
        if (trayecto == null) {
            return ResponseEntity.notFound().build();
        }

        trayecto.setAutobus(autobus); // Puedes validar si el autobus existe si quieres
        Trayecto actualizado = trayectoService.actualizarTrayecto(id, trayecto);
        return ResponseEntity.ok(actualizado);
    }

    
}

