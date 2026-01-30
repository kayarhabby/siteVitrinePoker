FROM jenkins/jenkins:lts

USER root

# Installer Docker CLI et Docker Compose
RUN apt-get update && \
    apt-get install -y docker.io curl unzip && \
    DOCKER_COMPOSE_VERSION=$(curl -s https://api.github.com/repos/docker/compose/releases/latest | grep tag_name | cut -d '"' -f 4) && \
    curl -L "https://github.com/docker/compose/releases/download/${DOCKER_COMPOSE_VERSION}/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && \
    chmod +x /usr/local/bin/docker-compose && \
    usermod -aG docker jenkins && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

USER jenkins

# Vérification
RUN docker --version
RUN docker-compose --version
