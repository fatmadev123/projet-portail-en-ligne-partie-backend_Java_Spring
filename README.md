# projet-portail-en-ligne-partie-backend_Java_Spring

Partie back-end pour le projet projet portail en ligne pour permettre aux locataires potentiels de contacter les propriétaires des différentes propriétés qu'ils souhaitent louer, la partie back- end est developpée en Java et Spring boot.

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
- Générer et copier dans app.jwt-secret= un mot de passe de 64 caractères hexadécimaux aléatoires.

## Partie Front-end de projet :

- Cloner le projet suivant : https://github.com/OpenClassrooms-Student-Center/Developpez-le-back-end-en-utilisant- Java-et-Spring.git
- Se positionner dans le dossier de projet et ouvrir un console et taper l’instruction suivante : npm install

## Structure de projet :

- Controllers : Contrôleurs des APIs
- Model: Modèles pour communiquer avec le DB
- Service : Traitement des données reçues
- Repository : Les classes qui interagi avec le DB
- Dto : Objet de transfert de données

## Application run

- Run the back-end project
- You can now use the back-end project with Postman or with Swagger http://localhost:3001/swagger-ui/index.html
- To use the application with an user interface, open a terminal, go to the front-end project directory, enter npm start and navigate to http://localhost:4200/.

## Author

Fatma Zammel
