package com.duoc.vrk.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nombre; 

    @NotBlank
    private String apellido; 

    @NotBlank
    private String correo;

    @NotNull
    private Integer numeroCel;

    @NotNull
    private Integer run;

    @NotBlank
    private String dv;

    @NotBlank
    private String direccion;
}
