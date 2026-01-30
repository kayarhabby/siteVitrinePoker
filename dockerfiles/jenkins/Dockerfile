FROM jenkins/jenkins:lts

# Passer en root pour installer Docker et Compose
USER root

# Installer Docker CLI et dépendances
RUN apt-get update && \
    apt-get install -y docker.io curl git && \
    usermod -aG docker jenkins

# Installer Docker Compose v2.39.4
ENV DOCKER_COMPOSE_VERSION=2.39.4
RUN curl -SL https://github.com/docker/compose/releases/download/v${DOCKER_COMPOSE_VERSION}/docker-compose-linux-x86_64 \
    -o /usr/local/bin/docker-compose && \
    chmod +x /usr/local/bin/docker-compose

# Vérifier les versions
RUN docker --version && docker-compose --version

# Installer et activer Buildx
RUN mkdir -p /usr/libexec/docker/cli-plugins && \
    curl -SL https://github.com/docker/buildx/releases/download/v0.21.1/buildx-v0.21.1.linux-amd64 \
    -o /usr/libexec/docker/cli-plugins/docker-buildx && \
    chmod +x /usr/libexec/docker/cli-plugins/docker-buildx && \
    docker buildx create --name jenkins-builder --use && \
    docker buildx inspect --bootstrap

# Repasser à l'utilisateur Jenkins
USER jenkins
