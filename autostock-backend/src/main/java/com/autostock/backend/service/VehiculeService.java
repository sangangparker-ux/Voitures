package com.autostock.backend.service;

import com.autostock.backend.dto.VehiculeDTO;
import com.autostock.backend.exception.VehiculeNotFoundException;
import com.autostock.backend.model.Vehicule;
import com.autostock.backend.repository.VehiculeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public List<VehiculeDTO> listerVehicules() {
        List<VehiculeDTO> resultat = new ArrayList<>();
        for (Vehicule vehicule : vehiculeRepository.findAll()) {
            resultat.add(versDTO(vehicule));
        }
        return resultat;
    }

    public VehiculeDTO obtenirVehiculeParId(Long id) {
        Vehicule vehicule = trouverOuLeverException(id);
        return versDTO(vehicule);
    }

    public VehiculeDTO creerVehicule(VehiculeDTO dto) {
        validerAnnee(dto.getAnnee());
        Vehicule vehicule = versEntite(dto);
        vehicule.setId(null); // on ignore un éventuel id envoyé par le client
        Vehicule vehiculeSauvegarde = vehiculeRepository.save(vehicule);
        return versDTO(vehiculeSauvegarde);
    }

    public VehiculeDTO modifierVehicule(Long id, VehiculeDTO dto) {
        validerAnnee(dto.getAnnee());
        Vehicule vehiculeExistant = trouverOuLeverException(id);

        vehiculeExistant.setMarque(dto.getMarque());
        vehiculeExistant.setModele(dto.getModele());
        vehiculeExistant.setAnnee(dto.getAnnee());
        vehiculeExistant.setPrix(dto.getPrix());
        vehiculeExistant.setKilometrage(dto.getKilometrage());
        vehiculeExistant.setCouleur(dto.getCouleur());
        vehiculeExistant.setDisponible(dto.isDisponible());

        Vehicule vehiculeMisAJour = vehiculeRepository.save(vehiculeExistant);
        return versDTO(vehiculeMisAJour);
    }

    public void supprimerVehicule(Long id) {
        Vehicule vehicule = trouverOuLeverException(id);
        vehiculeRepository.delete(vehicule);
    }

    private Vehicule trouverOuLeverException(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new VehiculeNotFoundException(id));
    }


    private void validerAnnee(Integer annee) {
        int anneeMax = Year.now().getValue() + 1;
        if (annee != null && annee > anneeMax) {
            throw new IllegalArgumentException(
                    "L'année doit être inférieure ou égale à " + anneeMax + ".");
        }
    }

    private VehiculeDTO versDTO(Vehicule vehicule) {
        VehiculeDTO dto = new VehiculeDTO();
        dto.setId(vehicule.getId());
        dto.setMarque(vehicule.getMarque());
        dto.setModele(vehicule.getModele());
        dto.setAnnee(vehicule.getAnnee());
        dto.setPrix(vehicule.getPrix());
        dto.setKilometrage(vehicule.getKilometrage());
        dto.setCouleur(vehicule.getCouleur());
        dto.setDisponible(vehicule.isDisponible());
        return dto;
    }

    private Vehicule versEntite(VehiculeDTO dto) {
        Vehicule vehicule = new Vehicule();
        vehicule.setId(dto.getId());
        vehicule.setMarque(dto.getMarque());
        vehicule.setModele(dto.getModele());
        vehicule.setAnnee(dto.getAnnee());
        vehicule.setPrix(dto.getPrix());
        vehicule.setKilometrage(dto.getKilometrage());
        vehicule.setCouleur(dto.getCouleur());
        vehicule.setDisponible(dto.isDisponible());
        return vehicule;
    }

}
