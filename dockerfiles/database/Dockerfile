FROM mysql:8.4.8

LABEL project="vitrineSitePoker"
LABEL author="Kaya Rhabby"

# Variables d'environnement MySQL
ENV MYSQL_ROOT_PASSWORD=sitepasswordroot \
    MYSQL_DATABASE=siteVitrineDB \
    MYSQL_USER=siteuser \
    MYSQL_PASSWORD=sitepassword

# Répertoire de travail (bonne pratique même si MySQL n'en dépend pas)
WORKDIR /docker-entrypoint-initdb.d

# Copier le dump SQL dans le dossier d'init
COPY dockerfiles/database/siteVitrineDB.sql ./siteVitrineDB.sql

# Donner les bons droits au user mysql (déjà présent dans l’image)
RUN chown -R mysql:mysql /docker-entrypoint-initdb.d \
    && chmod 644 /docker-entrypoint-initdb.d/siteVitrineDB.sql

# Exposition du port MySQL
EXPOSE 3306
