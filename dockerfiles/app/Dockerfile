############################
# ===== BUILD STAGE ===== #
############################
FROM maven:3.9.9-eclipse-temurin-17 AS build

LABEL stage=builder

WORKDIR /app

# Copier d'abord les fichiers Maven pour profiter du cache
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Télécharger les dépendances (cache)
RUN mvn dependency:go-offline

# Copier le reste du projet
COPY src src

# Build avec profil prod + skip tests
RUN mvn clean package -Dspring.profiles.active=prod -DskipTests


############################
# ===== RUN STAGE ======= #
############################
FROM tomcat:11.0.18-jdk17

LABEL project="vitrineSitePoker"
LABEL author="Kaya Rhabby"

# Tomcat tourne déjà en user non-root (tomcat)
WORKDIR /usr/local/tomcat

# Nettoyage des apps par défaut
RUN rm -rf webapps/*

# Copier le WAR depuis l’étape build
COPY --from=build /app/target/*.war webapps/ROOT.war

# Droits propres
#RUN chown -R tomcat:tomcat webapps

# Définir le profil Spring actif
ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8080

# Lancer Tomcat
CMD ["catalina.sh", "run"]
