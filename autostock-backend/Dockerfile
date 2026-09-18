# Utiliser une image de base Java légère (JRE seulement pour l'exécution)
FROM eclipse-temurin:17-jre-alpine

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré par Maven/Gradle dans l'image
# Remplace "ton-application.jar" par le nom réel de ton fichier JAR dans target/
COPY target/ton-application.jar app.jar

# Exposer le port sur lequel ton application Spring Boot écoute (par défaut 8080)
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]