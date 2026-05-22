package com.duoc.vrk.controller;

import com.duoc.vrk.model.Prenda;
import com.duoc.vrk.services.PrendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prendas")
public class PrendaController {

    @Autowired
    private PrendaService prendaService;

    @GetMapping
    public ResponseEntity<List<Prenda>> listarPrendas() {
        return ResponseEntity.ok(prendaService.getPrendas());
    }

    @PostMapping
    public ResponseEntity<Prenda> agregarPrenda(@Valid @RequestBody Prenda prenda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prendaService.savePrenda(prenda));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prenda> buscarPrenda(@PathVariable int id) {
        Prenda prenda = prendaService.getPrendaId(id);
        if (prenda == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prenda> actualizarPrenda(@PathVariable int id, @Valid @RequestBody Prenda prenda) {
        prenda.setId(id);
        Prenda actualizado = prendaService.updatePrenda(prenda);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrenda(@PathVariable int id) {
        prendaService.deletePrenda(id);
        return ResponseEntity.noContent().build();
    }
}