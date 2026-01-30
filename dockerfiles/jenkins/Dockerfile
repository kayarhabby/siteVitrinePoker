FROM jenkins/jenkins:lts

USER root

# Mettre à jour et installer les dépendances
RUN apt-get update && \
    apt-get install -y \
        docker.io \
        curl \
        unzip \
        git \
        sudo \
        iproute2 \
        iputils-ping && \
    rm -rf /var/lib/apt/lists/*

# Ajouter l'utilisateur Jenkins au groupe Docker pour accéder au daemon
RUN usermod -aG docker jenkins

# Installer Docker Compose 2.39.4 (binaire officiel)
RUN curl -SL https://github.com/docker/compose/releases/download/v2.39.4/docker-compose-linux-x86_64 \
    -o /usr/local/bin/docker-compose && \
    chmod +x /usr/local/bin/docker-compose

# Installer Docker Buildx binaire (dernier stable)
RUN mkdir -p /usr/libexec/docker/cli-plugins && \
    curl -SL https://github.com/docker/buildx/releases/download/v0.21.1/buildx-v0.21.1.linux-amd64 \
    -o /usr/libexec/docker/cli-plugins/docker-buildx && \
    chmod +x /usr/libexec/docker/cli-plugins/docker-buildx

# Revenir à l'utilisateur Jenkins
USER jenkins

# Vérification des versions
RUN docker --version || true && \
    docker-compose --version || true && \
    docker buildx version || true
