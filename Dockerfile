# --- Stage 1: Build mit Maven und Java 17 ---
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Abhängigkeiten cachen
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Sourcecode kopieren und WAR-Datei bauen
COPY src ./src
RUN mvn package -DskipTests

# --- Stage 2: Laufzeit-Umgebung mit Apache Tomcat ---
FROM tomcat:10.1-jre17-alpine
WORKDIR /usr/local/tomcat/webapps/

# Bestehende Tomcat-Standard-Apps löschen (optional, für ein sauberes Image)
RUN rm -rf ROOT

# Die generierte WAR-Datei aus Stage 1 als 'ROOT.war' kopieren.
# Dadurch ist die App später direkt unter '/' (ohne den Kontextpfad /wallet-0.0.1-SNAPSHOT) erreichbar.
COPY --from=build /app/target/wallet-0.0.1-SNAPSHOT.war ./ROOT.war

# Tomcat läuft standardmäßig auf Port 8080
EXPOSE 8080

# Tomcat startet automatisch über das Basis-Image, kein ENTRYPOINT nötig
