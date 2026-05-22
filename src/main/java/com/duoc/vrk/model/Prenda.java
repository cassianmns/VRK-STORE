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
@Table(name = "prendas")
public class Prenda{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  private String tipo; 

  @NotBlank
  private String estilo; 

  @NotBlank
  private String nombre;

  @NotNull
  private Integer stock;

  @NotBlank
  private String material;

  @NotBlank
  private String talla;

  @NotNull
  private Integer precio;

  @NotBlank
  private String color;
}