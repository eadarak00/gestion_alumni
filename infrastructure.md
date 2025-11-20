1 Base de donnees: Nous allons utilisé la base de données MariaDB . 

3 microservices techniques : 

    - ms-config (Spring Cloud Config Server)
        Rôle :
            Serveur qui centralise toutes les configurations des microservices.
            Permet de ne pas mettre les configurations dans le code (port, DB URL, JWT secret, API Keys…).
            Distribue dynamiquement les configurations aux microservices au démarrage.
        Pourquoi il démarre en premier?

    - ms-register (Eureka Server)
        Rôle :
            Annuaire des microservices.
            Chaque microservice s’enregistre ici → "Je suis ms-user, je suis sur le port 8081".
            Permet la découverte dynamique :

                ms-gateway et les autres microservices sans avoir besoin de connaître les ports.

    - ms-gateway (Spring Cloud Gateway)
        Rôle :
            Point d’entrée unique de l’application.
            Toutes les requêtes passent par lui.
            Il redirige les requêtes vers les microservices appropriés.

6 microservice de l'application:

    - ms-user (priorite 1)
        Gestion des utilisateurs (inscription, connexion, profils)
        Authentification (JWT)
        Rôles (admin, Etudiant, Alumni)

        Fonctions :
            CRUD utilisateurs
            Login / Register
            Stockage des informations personnelles


    - ms-cv (priorite 2)
        Gestion des CV des utilisateurs

        Fonctions :
        Ajouter / Modifier / Supprimer un CV
        Upload de documents (PDF)
        Consultation du CV 
        Gestion des permissions


    - ms-invitation (priorite 3)
        Rôle principal :
            Gestion des demandes d’invitation.

        Fonctions :
            Envoyer une invitation
            Accepter / Refuser

    
    - ms-publication (priorite 4)
        Rôle principal :
            Gestion des posts / publications

        Fonctions :
            Créer ou ajouter une publication (texte, PDF)
            Modifier / Supprimer



    - ms-analytics (priorite 5)
        Rôle principal :
            Statistiques et analyse des données de la plateforme

        Fonctions :
            Nombre d’utilisateurs actifs
            Nombre de CV créés
            Classement des utilisateurs les plus actifs
            Dashboard global


    - ms-messagerie (priorite 6)
        Gestion des messages privés entre utilisateurs

        Fonctions :
            Envoyer un message privé
            Recevoir et stocker l’historique
            Conversations entre deux utilisateurs

Communication entre les microservices (inter-services)

    1 Communication Synchrone REST
        Outil à utiliser : OpenFeign de Spring Cloud

    2 Communication Asynchrone (Events)
        Utilisée pour les services comme :
            ms-analytics
            ms-publication
            ms-invitation

        Outils possibles :
            Kafka (le plus puissant)
            RabbitMQ (simple et léger)

Architecture globale du fonctionnement de l'application (voir schema)

    