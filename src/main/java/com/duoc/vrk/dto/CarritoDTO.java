package com.duoc.vrk.dto;

import lombok.Data;
import java.util.List;

@Data
public class CarritoDTO {
    
    private Integer id;
    private String nombreUsuario;
    private Integer precioTotal;
    private List<ItemDetalle> items;

    @Data
    public static class ItemDetalle {

        private String nombrePrenda;
        private Integer cantidad;
        private Integer precioUnitario;
    }
}