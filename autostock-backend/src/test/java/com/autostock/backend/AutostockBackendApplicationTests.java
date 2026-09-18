package com.autostock.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

// Force le profil dev (H2) pendant les tests, indépendamment du profil
// actif de la machine qui exécute le build.
@SpringBootTest
@ActiveProfiles("dev")
class AutostockBackendApplicationTests {

    @Test
    void contextLoads() {
        // Le test réussit si le contexte Spring démarre sans erreur :
        // ça vérifie que toutes les beans (repository, service, controller,
        // config CORS...) s'assemblent correctement.
    }

}
