# siteVitrinePoker

Page d’accueil : / (via ton HomeController existant)

Galerie d’images : /images

Console H2 : /h2-console


# SiteVitrinePoker

## Description

Site Vitrine Poker est un site vitrine réalisé avec **Spring Boot**, **Thymeleaf** et **H2**.  
Il présente un thème casino/poker avec :

- Une page d’accueil (`index.html`) avec sections services et teaser vers la galerie
- Une page galerie (`images.html`) qui affiche des images stockées dans H2
- Gestion des images via Spring Data JPA et un service dédié
- Style responsive et moderne façon casino/poker

## Prérequis

- JDK 17+
- Maven 3+
- Spring Boot 4
- Tomcat 10+ (pour déploiement WAR)
- Navigateur web


## Installation & Lancement

1. Cloner le projet :  
   ```bash
    git clone <url-du-projet>
   ```

2. Construire le projet avec Maven :

   ```bash
    mvn clean package
   ```

3. Lancer l’application :

   ```bash
   mvn spring-boot:run
   ```

   ou déployer le `WAR` sur Tomcat.

4. Accéder à l’application :

   ```
   http://localhost:8080/
   ```

5. Accéder à la galerie :

   ```
   http://localhost:8080/images
   ```

6. Accéder à H2 Console (si besoin) :

   ```
   http://localhost:8080/h2-console
   JDBC URL : jdbc:h2:mem:siteVitrineDB
   User : sa
   Password : (vide)
   ```

## Configuration

Dans `application.properties` :

* Hibernate crée automatiquement les tables à partir des entités.
* Les images sont insérées au démarrage via **CommandLineRunner** ou `data.sql`.

## Organisation

* `src/main/resources/templates` : pages HTML (`index.html`, `images.html`)
* `src/main/resources/static/images` : images de la galerie
* `src/main/java/...` : logique Spring Boot (service, repository, controller)
* `application.properties` : configuration Spring Boot et H2

## Images par défaut

Au démarrage, 5 images sont disponibles dans H2 :

1. Poker Table → poker1.jpg
2. Blackjack Night → blackjack.jpg
3. Roulette Wheel → roulette.jpg
4. VIP Lounge → vip-lounge.jpg
5. Casino Entrance → casino-entrance.jpg

## Notes

* Les images doivent rester dans `static/images` pour être servies correctement
* Utiliser le service pour accéder à la base, ne pas appeler directement le repository
* Le site peut être déployé sur Tomcat avec `ROOT.war` ou via modification du `context path`
