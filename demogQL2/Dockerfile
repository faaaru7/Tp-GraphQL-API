# Stage 1: Build avec Maven
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le code source et compiler
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Image finale légère
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copier le JAR depuis le stage de build
COPY --from=build /app/target/*.jar app.jar

# Variables d'environnement
ENV PORT=8085

# Exposer le port
EXPOSE 8085

# Commande de démarrage
ENTRYPOINT ["java", "-jar", "app.jar"]