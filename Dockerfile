# --- Stage 1: Build mit Maven und Java 25 ---
FROM maven:3.9-eclipse-temurin-25-alpine AS build
WORKDIR /app

# Abhängigkeiten cachen (optimiert die Build-Zeit bei Code-Änderungen)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Sourcecode kopieren und WAR-Datei bauen
COPY src ./src
RUN mvn clean package -DskipTests

# --- Stage 2: Laufzeit-Umgebung mit Apache Tomcat ---
FROM tomcat:10.1-jdk25-openjdk-slim
WORKDIR /usr/local/tomcat/webapps/

# Bestehende Tomcat-Standard-Apps löschen für ein sauberes Image
RUN rm -rf ./ROOT

# Die generierte WAR-Datei aus Stage 1 als 'ROOT.war' kopieren.
# Dadurch ist die App direkt unter '/' erreichbar.
COPY --from=build /app/target/wallet-0.1.1-SNAPSHOT.war ./ROOT.war

# Tomcat läuft standardmäßig auf Port 8080
EXPOSE 8080

# Tomcat startet automatisch über das Basis-Image, kein ENTRYPOINT nötig
