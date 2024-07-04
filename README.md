# Gestion des Articles - Projet Spring Boot

## Introduction

Ce projet est une application Spring Boot permettant la gestion d'articles. Elle offre des fonctionnalités pour créer, lire, mettre à jour et supprimer des articles. L'application utilise Spring Data JPA pour la persistance des données et propose une API RESTful pour les opérations CRUD.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les éléments suivants :

- JDK 8 ou supérieur
- Maven 3.6.0 ou supérieur
- MySQL ou une autre base de données relationnelle

## Installation

1. Clonez le dépôt depuis GitHub :
   ```bash
   git clone https://github.com/votre-utilisateur/votre-repo.git
   ```

2. Accédez au répertoire du projet :
   ```bash
   cd votre-repo
   ```

3. Configurez la base de données dans le fichier `src/main/resources/application.properties` :
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/votre_base_de_donnees
   spring.datasource.username=votre_utilisateur
   spring.datasource.password=votre_mot_de_passe
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Compilez et empaquetez le projet avec Maven :
   ```bash
   mvn clean install
   ```

## Exécution

Pour exécuter l'application, utilisez la commande suivante :
```bash
mvn spring-boot:run
```

L'application sera accessible à l'adresse suivante : `http://localhost:8080`

## Structure du Projet

- **src** : Contient le code source principal.
  - **main** :
    - **java** : Contient les classes Java de l'application.
      - **com.example.project** :
        - **controller** : Contient les contrôleurs REST.
        - **model** : Contient les entités JPA.
        - **repository** : Contient les interfaces de dépôt.
        - **service** : Contient les services métiers.
    - **resources** : Contient les ressources de l'application.
      - **application.properties** : Fichier de configuration principal.
  - **test** : Contient les tests unitaires et d'intégration.

## Fonctionnalités

- **Créer un article** : Permet d'ajouter un nouvel article à la base de données.
- **Lire tous les articles** : Permet de récupérer la liste de tous les articles.
- **Lire un article par ID** : Permet de récupérer un article spécifique par son ID.
- **Mettre à jour un article** : Permet de modifier un article existant.
- **Supprimer un article** : Permet de supprimer un article de la base de données.

## Endpoints API

- `GET /articles` : Récupère la liste de tous les articles.
- `POST /articles` : Crée un nouvel article.
- `GET /articles/{id}` : Récupère un article par son ID.
- `PUT /articles/{id}` : Met à jour un article existant.
- `DELETE /articles/{id}` : Supprime un article par son ID.


