# 🌐 Site Web pour Murielle LE GRAND, Sophrologue

![GitHub](https://img.shields.io/badge/version-1.0-blue)
![License](https://img.shields.io/badge/license-MIT-green)
![Platform](https://img.shields.io/badge/platform-Windows%20%7C%20Unix%20%2F%20Linux-yellow)

## 📋 Table des matières
- [🌐 Site Web pour Murielle LE GRAND, Sophrologue](#-site-web-pour-murielle-le-grand-sophrologue)
  - [📋 Table des matières](#-table-des-matières)
  - [📝 Contexte](#-contexte)
  - [🎯 Objectifs du Projet](#-objectifs-du-projet)
  - [🗂 Structure du Projet](#-structure-du-projet)
  - [💻 Technologies Utilisées](#-technologies-utilisées)
  - [🚀 Mise en Route](#-mise-en-route)
  - [📊 Modèle de Données](#-modèle-de-données)
  - [🧪 Tests](#-tests)
  - [📜 Licence](#-licence)
  - [vérif git](#vérif-git)

## 📝 Contexte
Ce projet s'inscrit dans le cadre du développement d'un site web professionnel pour Murielle LE GRAND, sophrologue à Bailleau l'Évêque. L'application sera structurée selon le modèle MVC (Modèle-Vue-Contrôleur) avec l'utilisation de DAO (Data Access Object) et DTO (Data Transfer Object), une architecture robuste qui permet une séparation claire des responsabilités et une organisation efficace du code.

🛠 Description du Projet
Le projet consiste en la création d'un site web complet pour une sophrologue, comprenant des fonctionnalités telles que la présentation des services, la consultation des tarifs, un système de réservation en ligne pour les séances individuelles et collectives, ainsi qu'un tableau de bord administratif.

L'application sera développée en utilisant React pour le frontend, **Java avec Spring Boot et JPA pour le backend**, et MySQL pour la gestion de la base de données. Vite sera utilisé comme outil de build pour optimiser le développement frontend.

## 🎯 Objectifs du Projet
*   Implémenter une architecture MVC robuste et évolutive **avec Spring Boot**
*   Développer une interface utilisateur réactive avec React
*   Créer un backend solide en **Java/Spring Boot** avec une API RESTful
*   Concevoir et implémenter une base de données MySQL pour stocker les informations relatives aux utilisateurs, réservations et contenus du site
*   Assurer une séparation claire des responsabilités entre les différentes couches de l'application
*   Mettre en place un système de réservation en ligne sécurisé
*   Utiliser Vite pour une expérience de développement frontend optimisée

## 🗂 Structure du Projet
'''
sophrology-website/
│
├── frontend/ (React)
│ ├── src/
│ │ ├── components/
│ │ ├── pages/
│ │ ├── services/
│ │ └── App.jsx
│ ├── public/
│ ├── ...
│
├── backend/ (Spring Boot)
│ ├── src/main/java/
│ │ ├── com/example/sophrology/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── dto/
│ ├── src/main/resources/
│ ├── ...
│
├── .env
├── pom.xml (Maven)
├── package.json
└── vite.config.js

'''

## 💻 Technologies Utilisées
*   Frontend: React, utilisé pour créer une interface utilisateur dynamique et réactive.
*   Backend: **Java avec Spring Boot et JPA**, employé pour la logique métier, le traitement des données et la coordination des différents composants de l'application.
*   Base de données: MySQL, pour le stockage et la gestion des données.
*   Serveur d'application: Tomcat (intégré à Spring Boot), Nginx ou Apache pour la production.
*   ORM: **JPA (Java Persistence API) avec Hibernate**
*   Build tool: Vite pour le frontend, Maven ou Gradle pour le backend.

## 🚀 Mise en Route

**Backend (Spring Boot):**

1.  Clonez le dépôt.
2.  Assurez-vous d'avoir Java et Maven (ou Gradle) installés.
3.  Configurez votre base de données dans `src/main/resources/application.properties` ou `application.yml`.
4.  Compilez et lancez l'application Spring Boot :  `mvn spring-boot:run`  (ou équivalent Gradle).

**Frontend (React):**

1.  Accédez au répertoire  `frontend/`.
2.  Installez les dépendances JavaScript :  `npm install`.
3.  Lancez Vite :  `npm run dev`.

## 📊 Modèle de Données
Le schéma de base de données inclura des tables pour les utilisateurs, les réservations, les services de sophrologie, et les contenus du site. Les relations entre ces tables seront gérées par **JPA et les annotations Hibernate.**

## 🧪 Tests
Les tests unitaires et d'intégration seront écrits en utilisant JUnit et Mockito pour le backend et Jest pour le frontend.

*   Backend :  `mvn test`  (ou équivalent Gradle)
*   Frontend :  `npm test`

## 📜 Licence
Ce projet est développé pour Murielle LE GRAND et n'est pas destiné à une utilisation commerciale sans autorisation.

