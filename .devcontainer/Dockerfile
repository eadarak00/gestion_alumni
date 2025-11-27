# Image DevContainer de base
FROM mcr.microsoft.com/devcontainers/base:ubuntu

# --- Dépendances système ---
RUN apt-get update && apt-get install -y \
    curl \
    ca-certificates \
    gnupg \
    lsb-release \
    sudo \
    git \
    unzip \
    bash-completion

# --- Java 17 ---
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

# --- Node.js 20 + npm + yarn ---
RUN curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g npm@latest yarn

# --- Docker CLI ---
RUN apt-get install -y docker.io

# --- Docker Compose ---
RUN curl -SL https://github.com/docker/compose/releases/download/v2.24.0/docker-compose-linux-x86_64 -o /usr/local/bin/docker-compose \
    && chmod +x /usr/local/bin/docker-compose

# --- Configuration des permissions Docker ---
# Créer le groupe docker s'il n'existe pas et ajouter vscode
RUN groupadd -f docker
RUN usermod -aG docker vscode

# S'assurer que le socket Docker a les bonnes permissions
RUN chmod 666 /var/run/docker.sock || true

# Nettoyage
RUN apt-get clean && rm -rf /var/lib/apt/lists/*

USER vscode
WORKDIR /workspace

# Vérification des installations
RUN java -version && mvn -version && node --version && npm --version