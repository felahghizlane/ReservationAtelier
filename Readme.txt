Projet de Réservation d'Ateliers Artisanaux
Ce projet est une application web développée avec Spring Boot, intégrant Spring Data JPA et Thymeleaf, destinée à la gestion et à la réservation d'ateliers artisanaux.

Objectifs : 
Appliquer les principes de l'architecture MVC.
Utiliser Spring Boot pour construire l'application.
Intégrer Spring Data JPA avec MySQL pour les opérations sur la base de données.
Créer des interfaces utilisateur dynamiques avec Thymeleaf sans interaction JavaScript complexe.

Phases de Développement : 
Phase 1: Initialisation du Projet
Génération d'un projet Spring Boot avec Spring Initializr incluant Spring Web, Thymeleaf, Spring Data JPA, et MySQL Driver.
Phase 2: Configuration de l'Environnement de Développement
Configuration de l'IDE et du fichier application.properties pour la connexion à MySQL.
Création d'une base de données via MySQL Workbench.
Phase 3: Création de la Base de Données et Modélisation des Entités JPA
Définition des entités JPA nécessaires : Atelier, Artisan, Participant, Réservation.
Phase 4: Développement du Back-end
Implémentation des repositories JPA pour chaque entité.
Développement des services métiers.
Création des contrôleurs MVC.
Phase 5: Création de l'Interface Utilisateur
Construction des templates Thymeleaf pour différentes pages.
Stylisation des templates avec CSS.
Phase 6: Tests et Validation
Validation des fonctionnalités et de la réponse aux actions de l'utilisateur.
Implémentation de la validation des données côté serveur.
Phase 7: Préparation pour le Déploiement
Préparation de l'application pour la génération d'un fichier WAR exécutable.

Pour afficher la liste des ateliers : 
http://localhost:8080/ateliers
Pour ajouter un creneau:
http://localhost:8080/ReservationCreneau
Pour supprimer une reservation:
http://localhost:8080/reservations




Rendu Final:
Soumission du code source sur un répertoire Git.
Préparation d'une vidéo de démonstration de l'application.


Ressources:
Documentation de Spring Boot, Spring Data JPA, et Thymeleaf.
Outils recommandés : Spring Initializr, MySQL Workbench.
