# projet-portail-en-ligne-partie-backend_Java_Spring

Partie back_end pour le projet portail en ligne pour permettre aux locataires potentiels de contacter les propriétaires des différentes propriétés qu'ils souhaitent louer, la partie back_end est developpée en Java et Spring boot.

## Technologies utilisés :

- Java
- Spring Boot
- MySQL Server
- Angular 14

## Base de données :

- Installer MySQL Server et MySQL Workbench
- Noter les user-name, password et numéro de port de MySQL.
- Créer un nouveau base de données et prendre note de nom de DB.
- A partir d’un navigateur web ouvrir le lien suivant: http://github.com/OpenClassrooms-student-Center/Developpez-le-back-end-en-utilisant-Java-et-Spring/blob/main/ressources/sql/script.sql
- Copier les requêtes SQL et les exécuter dans le base de données.

## Partie Back-end de projet :

- Cloner le projet suivant: https://github.com/fquyont/Project3-ChatopAPI.git
- Remplir le fichier application.properties par les informations suivantes : spring.datasource.url=jdbc:mysql://localhost:PORT/SCHEMA par le remplacement de PORT et SCHEMA par le port SQL et le schema utilisé dans le base de données, et insérer les informations suivantes spring.datasource.username= et spring.datasource.password= par leurs valeur.
- Générer et copier dans app.jwt-secret= un mot de passe aléatoire de 64 caractères hexadécimaux.

## Partie Front-end de projet :

- Cloner le projet suivant : https://github.com/OpenClassrooms-Student-Center/Developpez-le-back-end-en-utilisant- Java-et-Spring.git
- Se positionner dans le dossier de projet et ouvrir un console et taper l’instruction suivante : npm install
- Tester le partie front_end en utilisant le serveur fictif Mockoon en utilisant le fichier Json qui se trouve dans le lien suivant :https://github.com/OpenClassrooms-Student-Center/Developpez-le-back-end-en-utilisant-Java-et-Spring/blob/main/ressources/mockoon/rental-oc.json

## Structure de projet :

- Controllers : Contrôleurs des APIs
- Model: Modèles pour communiquer avec le DB
- Service : Traitement des données reçues
- Repository : Les classes qui interagissent avec le DB
- Dto : Objet de transfert de données

## Application run

- Executez le projet back_end sur Spring boot
- Vous pouvez testez le projet back_end soit par Postman ou Swagger http://localhost:3001/swagger-ui/index.html
- Pour utiliser l'application avec une interface utilisateur, ouvrir un terminal, aller au chemin d'acces du projet front-end, entrer npm start and navigate to http://localhost:4200/

## Réalisateur

Fatma Zammel
