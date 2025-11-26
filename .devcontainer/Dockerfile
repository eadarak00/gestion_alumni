FROM mcr.microsoft.com/devcontainers/base:ubuntu

# Mise à jour du système
RUN apt-get update && apt-get upgrade -y

# --- Java 17 ---
RUN apt-get install -y openjdk-17-jdk

# --- Node.js 20 + npm + yarn ---
RUN curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g npm@latest yarn

# --- Installer Docker CLI depuis le repo officiel Docker ---
RUN apt-get update && apt-get install -y \
    ca-certificates \
    curl \
    gnupg \
    lsb-release

RUN install -m 0755 -d /etc/apt/keyrings \
    && curl -fsSL https://download.docker.com/linux/ubuntu/gpg | gpg --dearmor -o /etc/apt/keyrings/docker.gpg \
    && chmod a+r /etc/apt/keyrings/docker.gpg

RUN echo \
    "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
    $(lsb_release -cs) stable" \
    > /etc/apt/sources.list.d/docker.list

RUN apt-get update && apt-get install -y \
    docker-ce-cli \
    docker-buildx-plugin \
    docker-compose-plugin

# --- Utilitaires ---
RUN apt-get install -y git unzip bash-completion

# User VSCode
USER vscode
WORKDIR /workspace
