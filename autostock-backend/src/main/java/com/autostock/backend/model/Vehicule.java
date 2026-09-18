package com.autostock.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "vehicules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La marque est obligatoire.")
    private String marque;

    @NotBlank(message = "Le modèle est obligatoire.")
    private String modele;


    @NotNull(message = "L'année est obligatoire.")
    @Min(value = 1970, message = "L'année doit être supérieure ou égale à 1970.")
    private Integer annee;

    @NotNull(message = "Le prix est obligatoire.")
    @Positive(message = "Le prix doit être un nombre positif.")
    private BigDecimal prix;

    @NotNull(message = "Le kilométrage est obligatoire.")
    @PositiveOrZero(message = "Le kilométrage doit être positif ou nul.")
    private Integer kilometrage;

    @NotBlank(message = "La couleur est obligatoire.")
    private String couleur;


    private boolean disponible = true;

}
