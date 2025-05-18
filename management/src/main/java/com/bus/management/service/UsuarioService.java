package com.bus.management.service;

import com.bus.management.model.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    List<Usuario> obtenerTodos();
    Usuario obtenerPorId(Long id);
    Usuario obtenerPorEmail(String email);
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
}

