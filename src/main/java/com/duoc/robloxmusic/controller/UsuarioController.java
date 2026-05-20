package com.duoc.robloxmusic.controller;

import com.duoc.robloxmusic.model.Usuario;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
    private List<Usuario> usuariosSimulados = new ArrayList<>(); // Simulación rápida para endpoints obligatorios

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody Usuario usuario) {
        log.info("Creando usuario: {} {}", usuario.getNombre(), usuario.getApellido());
        usuario.setId(usuariosSimulados.size() + 1);
        usuariosSimulados.add(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        log.info("Listando todos los usuarios");
        return ResponseEntity.ok(usuariosSimulados);
    }

    @GetMapping("/{run}")
    public ResponseEntity<Usuario> buscarPorRun(@PathVariable Integer run) {
        log.info("Buscando usuario por RUN: {}", run);
        return usuariosSimulados.stream()
                .filter(u -> u.getRun().equals(run))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}