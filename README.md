# Membres de l'équipe

# Livrable 1

## Fonctionnalités implémentées

- [x] Afficher la liste détaillée des modèles
- [x] Il est possible de choisir le modèle à visualiser dans la liste
- [x] Le modèle est chargé et visualisé
- [x] Message d'erreur en cas d'erreur de format dans le fichier
- [x] La visualisation est correcte
- [~] On visualise simultanément trois vues du modèle (de face, de haut, de côté)
- [x] Rotation
- [x] Translation
- [x] Homotétie

## Autres éléments demandés

- [x] Tests pour les classes de calcul mathématique
- [x] Captures d'écran pour le rendu
- [x] Vidéo de présentation du rendu
- [x] Respect du format de rendu (cf Moodle)

## Informations importantes

>Afin de lancer la visualisation d'un fichier Ply, en ayant vérifié au préalable que vous vous trouvez bien dans le dossier projetmodeg4/target, il suffit de lancer cette commande :

>
java module-path 'path-to-javafx-binaries/lib' --add-modules javafx.controls,javafx.fxml -jar projetmodeg4-livrable1.jar

 les fichiers de capture d'écran / vidéo sont présents dans le dossier **projetmodeg4\captures**
 
## Distribution du travail (qui a fait quoi)

Maxence Billiau : 

- Classe de matrices, Travail sur toutes les fonctions de modifications de matrices, test Matrices
- Interface visuelle
- Débugage
- Géométrie affine

Alexander Bassett :

- Classes de matrices, Travail sur toutes les fonctions de modifications de matrices
- Lecteur de fichier Ply
- Classes Sommets/Faces
- Débugage

Loïck Debay : 

- Gestion des erreurs de format 
- Fonction de centrage/déplacement de matrice 
- Captures d'écran/vidéo/readme

Alexis Donnez :

- Création de fichier pour le MVC
- Tri des fichiers
 
## Difficultés rencontrées

- Difficultés de conflits avec Git
- Déformation des figures 
- Figures non visibles sur le canvas 
- Rotations affectant le visuel des modèles
- Calculs de Zoom 
- Tous calculs liés aux matrices
- Recadrage

# Livrable 2

## Fonctionnalités implémentées


- [x] Affichage faces seulement / segments seulement
- [~] Affichage avancé de la bibliothèque de modèles 
   - pas fonctionnel
- [ ] Recherche dans la bibliothèque de modèles
   - pas fonctionnel
- [ ] Éditer les informations sur un modèle
- [x] Modèle centré
- [x] Éclairage
- [ ] Lissage
- [x] Ombre portée
- [ ] Vue en tranches
- [x] Controleur horloge
- [ ] Autres, préciser

## Autres exigences

- [~] Tests unitaires
- [x] Diagramme de classes UML
- [x] Javadoc
- [x] Captures d'écran
- [x] Vidéo de présentation
- [x] Respect du format de rendu

## Distribution du travail (qui a fait quoi)
Maxence Billiau : majorité du javafx, synchronisation des trois vues par mvc, pmd, edit fxml, quelques tests de matrice
Alexander Bassett : contrôleur horloge/éclairage, affichage segment/face
Loïck Debay : fonctions d'affichage de liste de fichier et des détails des fichiers ply, création d'une classe d'objet ply pour la liste, javadoc, readme, règles pmd, edit fxml
Alexis Donnez :

## Difficultés rencontrées

Loïck Debay : problème aux mains la dernière semaine de projet, absence en cours + impossibilité d'utiliser un clavier pour une longue durée/ 4 doigts immobilisés
problème d'affichage de modèles "écrasés"
organisation

Problèmes de zoom et de recadrage que l'on a pas reussi à règler.

## Informations !

Pour lancer le .jar, il faut utiliser les modules java séparéments grâce à la commande suivante :

java -jar --module-path "path jusqu'au dossier du projet"/src/main/resources/javafx-sdk-11.0.2-[Windows ou Linux]/lib --add-modules javafx.controls,javafx.fxml projetmodeg4-livrable[1 ou 2].jar

(Exemple : java -jar --module-path C:/Users/inacraft/git/projetmodeg4/src/main/resources/javafx-sdk-11.0.2-Windows/lib --add-modules javafx.controls,javafx.fxml projetmodeg4-livrable2.jar).

