package com.duoc.vrk.controller;

import com.duoc.vrk.dto.CarritoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/carritos")
public class CarritoController {
    private static final Logger log = LoggerFactory.getLogger(CarritoController.class);

    @GetMapping("/{id}")
    public ResponseEntity<CarritoDTO> obtenerCarrito(@PathVariable int id) {
        log.info("Buscando carrito ID: {} y transformando a DTO", id);
        
        // Simulación basada en tus entidades reales
        CarritoDTO dto = new CarritoDTO();
        dto.setId(id);
        dto.setNombreUsuario("Jotaro Kujo");
        dto.setPrecioTotal(9990);
        
        CarritoDTO.ItemDetalle item = new CarritoDTO.ItemDetalle();
        item.setNombrePrenda("Polera Jojo's");
        item.setCantidad(1);
        item.setPrecioUnitario(9990);
        
        dto.setItems(List.of(item));
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/{id}/vaciar")
    public ResponseEntity<Void> vaciarCarrito(@PathVariable int id) {
        log.warn("Vaciando items del carrito con ID: {}", id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/checkout")
    public ResponseEntity<String> pagarCarrito(@PathVariable int id) {
        log.info("Procesando checkout del carrito: {}", id);
        return ResponseEntity.ok("Compra realizada con éxito en VRK.");
    }
}