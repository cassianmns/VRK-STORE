package com.duoc.robloxmusic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrendaDTO {

    private Integer id;

    @NotBlank
    private String nombre;

    @NotNull
    @Positive
    private Double precio;
    
    @NotBlank
    private String talla;

    @NotNull
    private Boolean disponibilidad;
    
}
