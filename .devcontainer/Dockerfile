FROM mcr.microsoft.com/devcontainers/base:ubuntu

# Mise à jour du système
RUN apt-get update && apt-get upgrade -y

# --- Java 17 (OpenJDK) ---
RUN apt-get install -y openjdk-17-jdk

# --- Node.js 20 + npm + yarn ---
RUN curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g npm@latest yarn

# --- Docker CLI et docker compose ---
RUN apt-get install -y docker.io docker-compose-plugin

# --- Utilitaires ---
RUN apt-get install -y git unzip bash-completion

# User VSCode
USER vscode
WORKDIR /workspace
