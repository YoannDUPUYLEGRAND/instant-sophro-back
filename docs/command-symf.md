# 🌐 Projet blog-PHP Symfony

![PHP](https://img.shields.io/badge/php-%3E%3D7.4-blue)
![Symfony](https://img.shields.io/badge/symfony-%5E5.2.3-blue)
![License](https://img.shields.io/badge/license-MIT-green)
![Platform](https://img.shields.io/badge/platform-Windows%20%7C%20Unix%20%2F%20Linux-yellow)

## 📋 Table des matières
- [🌐 Projet blog-PHP Symfony](#-projet-blog-php-symfony)
  - [📋 Table des matières](#-table-des-matières)
  - [📝 Contexte](#-contexte)
  - [Création d'un nouveau projet](#création-dun-nouveau-projet)
  - [Création d'un controller](#création-dun-controller)
  - [cmd Doctrine pour DB](#cmd-doctrine-pour-db)
  - [cmd Pour création entity](#cmd-pour-création-entity)
  - [Pour préparer migration ver DB](#pour-préparer-migration-ver-db)
  - [Pour envoyer table vers DB](#pour-envoyer-table-vers-db)
  - [Code pour envoyer des donnée avec EntityManagerInterface $em](#code-pour-envoyer-des-donnée-avec-entitymanagerinterface-em)
  - [Récupérer les données de la DB](#récupérer-les-données-de-la-db)
        - [Méthode de base (findAll)](#méthode-de-base-findall)
        - [Méthode Custom ( findByTitle )](#méthode-custom--findbytitle-)
  - [Création données fictives](#création-données-fictives)
  - [Installation JWT](#installation-jwt)
  - [📜 Licence](#-licence)


## 📝 Contexte
Ce fichier sert de mémo pour expliquer le fonctionnement des commandes de base symfony.

## Création d'un nouveau projet
```
symfony new project_name --webapp # Création d'un nouveau projet web
symfony new project_name # Création d'un nouveau projet de base
```
## Création d'un controller
```
symfony console make:controller MainController
```
## cmd Doctrine pour DB
```
symfony console doctrine:database:create
symfony console doctrine:database:drop --force
```
## cmd Pour création entity
```
symfony console make:entity Name
symfony console make:user Name
```
## Pour préparer migration ver DB
```
symfony console make:migration
```
## Pour envoyer table vers DB
```
symfony console doctrine:migration:migrate
symfony console do:mi:mi
```
## Code pour envoyer des donnée avec EntityManagerInterface $em
```
$em->persist($obj)  #Permet de mettre en attente les données
$em->flush() #Permet de les save dans la DB
```
c'est l'ObjectManager qui gère les méthodes persist et flush.
## Récupérer les données de la DB

##### Méthode de base (findAll)
```
$posts = $repository->findAll();
```
##### Méthode Custom ( findByTitle )
```
public function findByTitle(string $title):array
    {
        return $this->createQueryBuilder('p')
        ->where('p.title = :title')
        ->setParameter('title', $title)
        ->orderBy('p.publishedAt', 'DESC')
        ->getQuery()
        ->getResult();
    }
```

## Création données fictives
+ lire FakerPHP pour plus d'info
+ Lire AliceBundle pour plus d'info

Les deux permettent de créer des données fictives pour la DB rapidement et facilement.

## Installation JWT
```
composer require jms/serializer-bundle
composer require friendsofsymfony/rest-bundle
composer require --dev symfony/maker-bundle    
composer require symfony/orm-pack
composer require lexik/jwt-authentication-bundle
```


## 📜 Licence
Ce projet est sous licence MIT. Il est libre d'utilisation à des fins éducatives et personnelles.