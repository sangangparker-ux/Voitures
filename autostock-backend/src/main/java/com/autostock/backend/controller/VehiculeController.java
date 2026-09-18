package com.autostock.backend.controller;

import com.autostock.backend.dto.VehiculeDTO;
import com.autostock.backend.service.VehiculeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor

@CrossOrigin(origins = "${cors.allowed-origins}")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    @GetMapping
    public ResponseEntity<List<VehiculeDTO>> listerVehicules() {
        return ResponseEntity.ok(vehiculeService.listerVehicules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculeDTO> obtenirVehiculeParId(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculeService.obtenirVehiculeParId(id));
    }

    @PostMapping
    public ResponseEntity<VehiculeDTO> creerVehicule(@Valid @RequestBody VehiculeDTO vehiculeDTO) {
        VehiculeDTO vehiculeCree = vehiculeService.creerVehicule(vehiculeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeCree);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculeDTO> modifierVehicule(@PathVariable Long id,
                                                          @Valid @RequestBody VehiculeDTO vehiculeDTO) {
        return ResponseEntity.ok(vehiculeService.modifierVehicule(id, vehiculeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerVehicule(@PathVariable Long id) {
        vehiculeService.supprimerVehicule(id);
        return ResponseEntity.noContent().build();
    }

}
