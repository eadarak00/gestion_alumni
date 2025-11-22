# CONTRIBUTING.md

# Contribuer au projet `gestion_alumni`
Merci de votre intérêt pour contribuer à ce projet. Avant de soumettre des pull requests ou de travailler sur le code, merci de lire ces directives.

## 1. Prérequis
Pour travailler sur ce projet, vous devez avoir installé :

* [Docker et Docker Compose](https://docs.docker.com/compose/install/)
* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Maven 3.9+](https://maven.apache.org/install.html)
* [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)


## 2. Récupérer le projet

```bash
git clone https://github.com/<votre-repo>/gestion_alumni.git
cd gestion_alumni
```

## 3. Synchronisation avec `develop`
Avant de commencer vos modifications :

```bash
git checkout develop
git pull origin develop
```

Puis créez une nouvelle branche pour vos changements :

```bash
git checkout -b feature/nom-de-la-feature
```

## 4. Structure du projet

```
backend/
  ms-config/     # Config Server Spring Boot
  ms-discover/   # Eureka Discovery Server
  ms-gateway/    # API Gateway
  ms-user/       # Microservice User
docker-compose.yml
```

Chaque microservice a son propre Dockerfile et configuration `application.yml`.


## 5. Lancer l’environnement Docker

```bash
docker compose up --build
```

Vérifiez que tous les services sont sains :

```bash
docker ps
```

> **Note** : `ms-user-db` doit être `healthy` pour que `ms-user` démarre correctement.
> Le port interne MariaDB pour les microservices est **3306**, même si le port externe exposé est différent.


## 6. Branches et commits

* Créez toujours une branche pour vos modifications :

```bash
git checkout -b feature/nom-de-la-feature
```

* Committez avec des messages clairs :

```bash
git add .
git commit -m "Ajout de la fonctionnalité X dans ms-user"
```

* Poussez votre branche :

```bash
git push origin feature/nom-de-la-feature
```

## 7. Documentation Swagger
* Chaque microservice exposant des API doit utiliser `springdoc-openapi`.
* Accessible via `http://<host>:<port>/swagger-ui.html` ou `/v3/api-docs`.

## 8. Bonnes pratiques
* Respectez le format de code Java et Maven.
* Microservices autonomes, communiquant via Eureka et Gateway.
* Tests unitaires recommandés avant toute PR.
* Ajoutez un `healthcheck` Docker pour tous les services exposant des ports HTTP.


## 9. Questions / Problèmes
* Vérifiez que `ms-config` et `ms-discover` tournent avant les autres services.
* Si un service ne s’enregistre pas dans Eureka, vérifiez `spring.application.name` et `eureka.client.service-url`.
* Pour la base MariaDB, utilisez toujours le port interne 3306 pour les microservices.
