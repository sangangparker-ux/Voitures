package com.autostock.backend.exception;

/**
 * Exception métier non vérifiée : levée par le Service, interceptée par
 * GlobalExceptionHandler qui la traduit en réponse HTTP 404.
 */
public class VehiculeNotFoundException extends RuntimeException {

    public VehiculeNotFoundException(Long id) {
        super("Aucun véhicule trouvé avec l'identifiant " + id);
    }

}
