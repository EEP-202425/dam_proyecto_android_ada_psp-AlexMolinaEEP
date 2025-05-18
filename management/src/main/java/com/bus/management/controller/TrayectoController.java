package com.bus.management.controller;

import com.bus.management.model.Autobus;
import com.bus.management.model.Trayecto;
import com.bus.management.service.AutobusService;
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

    @Autowired
    private AutobusService autobusService;

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

    @PutMapping("/{id}/asignar-autobus")
    public ResponseEntity<Trayecto> asignarAutobus(@PathVariable Long id, @RequestBody Autobus autobus) {
        Trayecto trayecto = trayectoService.obtenerPorId(id);
        if (trayecto == null) return ResponseEntity.notFound().build();

        Autobus autobusCompleto = autobusService.obtenerPorId(autobus.getId());
        if (autobusCompleto == null) return ResponseEntity.badRequest().build();

        trayecto.setAutobus(autobusCompleto);
        Trayecto actualizado = trayectoService.actualizarTrayecto(id, trayecto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTrayecto(@PathVariable Long id) {
        trayectoService.eliminarTrayecto(id);
        return ResponseEntity.noContent().build();
    }
}


