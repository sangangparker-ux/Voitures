# --- Étape 1 : build ---
# Utilise une image avec Maven + JDK, seulement pour compiler.
# Cette étape n'est PAS présente dans l'image finale : elle n'alourdit pas
# ce qui sera déployé sur Render.
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copié séparément pour profiter du cache Docker : si seul le code source
# change, Maven ne re-télécharge pas les dépendances à chaque build.
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# --- Étape 2 : exécution ---
# Image finale beaucoup plus légère : un JRE seul, pas de Maven ni de JDK complet.
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/target/autostock-backend.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
