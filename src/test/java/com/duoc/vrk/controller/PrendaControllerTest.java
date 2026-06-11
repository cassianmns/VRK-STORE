package com.duoc.vrk.controller;

import com.duoc.vrk.model.Prenda;
import com.duoc.vrk.services.PrendaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrendaControllerTest {

    @Mock
    private PrendaService prendaService;

    @InjectMocks
    private PrendaController prendaController;

    @Test
    void agregarPrenda_retorna201_cuandoPrendaEsValida() {
        Prenda prenda = new Prenda(1, "Polera", "Casual", "Polera Jojo's", 10, "Algodón", "M", 9990, "Negro");
        when(prendaService.savePrenda(prenda)).thenReturn(prenda);
        var respuesta = prendaController.agregarPrenda(prenda);
        assertNotNull(respuesta);
        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
        var body = respuesta.getBody();
        assertNotNull(body);
        assertEquals("Polera Jojo's", body.getNombre());
    }

    @Test
    void buscarPrenda_retorna200_cuandoExiste() {
        Prenda prenda = new Prenda(1, "Polera", "Casual", "Polera Jojo's", 10, "Algodón", "M", 9990, "Negro");
        when(prendaService.getPrendaId(1)).thenReturn(prenda);
        var respuesta = prendaController.buscarPrenda(1);
        assertNotNull(respuesta);
        assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        var body = respuesta.getBody();
        assertNotNull(body);
        assertEquals(1, body.getId());
    }

    @Test
    void buscarPrenda_retorna404_cuandoNoExiste() {
        when(prendaService.getPrendaId(99)).thenReturn(null);
        var respuesta = prendaController.buscarPrenda(99);
        assertNotNull(respuesta);
        assertEquals(HttpStatus.NOT_FOUND, respuesta.getStatusCode());
    }

    @Test
    void listarPrendas_retorna200_conListaDePrendas() {
        List<Prenda> prendas = List.of(
                new Prenda(1, "Polera", "Casual", "Polera Jojo's", 10, "Algodón", "M", 9990, "Negro"),
                new Prenda(2, "Jeans", "Urbano", "Jeans Oversize", 5, "Denim", "L", 29990, "Azul")
        );
        when(prendaService.getPrendas()).thenReturn(prendas);
        var respuesta = prendaController.listarPrendas();
        assertNotNull(respuesta);
        assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        var body = respuesta.getBody();
        assertNotNull(body);
        assertEquals(2, body.size());
    }
}