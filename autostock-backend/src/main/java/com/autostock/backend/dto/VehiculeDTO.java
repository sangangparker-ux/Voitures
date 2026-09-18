package com.autostock.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeDTO {

    // null à la création, renseigné en sortie et sur une modification.
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
