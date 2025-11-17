# TODO.md

## Tâches assignées
> **Note GN** : `Veuilez Lire attentivement le fichier CONTRIBUTING.md avant de faire quoi que ce soit`.
> **Note G** : `Veuilez respecter la structure des packages et les bonnes pratiques`.


### DAFFE – Backend / ms-user

* [ ] Creation de la classe Role
* [ ] Mettre en place le Repository de la classe Role
* [ ] Service de la classe Role
* [ ] Controller de la classe Role `api/v1/roles`

### Safy – Backend / ms-user

* [ ] Creation de la classe Utilisateur
* [ ] Mettre en place le Repository de la classe Utilisateur
* [ ] Service de la classe Utilisateur
* [ ] Endpoint pour lister tous les utilisateur `api/v1/utilisateurs`

> **Note** : `utiliser les dtos pour la creation d'un utilisateur et pour les lister`.

### Djiby FALL – Backend / ms-user

* [ ] Creation de la classe CodeValidation
* [ ] Implementer le service de mailing pour qu'on puisse envoyer un code dans le mail de l'utilisateur
* [ ] Logique metier de l'implémenter l'envoi d'email de confirmation d'activation de compte

### Mouhamed Ndoye – Backend / ms-user

* [ ] Creation de la classe Alumni
* [ ] Mettre en place le Repository de la classe Alumni
* [ ] Service de la classe Alumni - logique metier de la creation du compte
* [ ] Endpoint pour inscrire un alumni `api/v1/auth/inscription-alumni`

> **Note** : `utiliser les dtos pour l'inscription d'un alumni`.

### Aimerou DIA – Backend / ms-user

* [ ] Creation de la classe Etudiant
* [ ] Mettre en place le Repository de la classe Etudiant
* [ ] Service de la classe Etudiant - logique metier de la creation du compte
* [ ] Endpoint pour inscrire un Etudiant `api/v1/auth/inscription-etudiant`

> **Note** : `utiliser les dtos pour l'inscription d'un etudiant`.


### Dieydy DEMBELE – Backend / ms-user

* [ ] Endpoint pour la validation du mail `api/v1/auth/valider-code`
* [ ] Logique metier pour le renvoi du code de validation 
* [ ] Endpoint pour la validation du mail `api/v1/auth/renvoyer-code`

### Abdourahmane DIALLO – Backend / ms-user
* [ ] Mise en place de la securite de l'application `securityfilterchain`
* [ ] Mise en place de l'acces par role 

### Ansoumana Konate – Backend / ms-user
* [ ] Développer le système de hashage des mots de passe

### Seydina Al Hamine  – Backend / ms-user
* [ ] Generation de jeton JWT 
* [ ] Filtre de jeton JWT 
* [ ] Endpoint pour la connexion `api/auth/login

###  Abdoulaye GAYE – Backend / ms-user
* [ ] Gérer le rafraîchissement de token 
* [ ] Tester son bonne fonctionnement 
* [ ] Postman - test de la connexion


###  Dicory – Backend / ms-user
* [ ] Postman - Tester inscription etudiant et alumni
* [ ] Postman - Tester validation de code et son renvoi

> **Note** : `Il faut tester toutes les evantualites`.



###  El abdou DRAME 
* [x] Mise en place de l'entite de base
* [x] Creation du projet frontend
* [ ] Conteneurisation le frontend
* [ ] Integration des parties


> **Note G1** : `On utilisera la suppression logique dans le projet et non pas la suppression definitive`.



Chaque membre peut **cocher `[x]`** les tâches terminées.
On peut aussi préciser que chaque dev **doit puller les dernières modifications de `develop`** avant de commencer une tâche.

