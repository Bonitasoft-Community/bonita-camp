---
title: Exercice 4 - Création de formulaires
---

## Objectif

L'objectif de cet exercice est de fournir des formulaires simples, conviviaux et adaptés aux utilisateurs, affichés à l'exécution du processus.

## Instructions simples

Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *2.1.0*.

Créer les formulaires suivants :
- Un formulaire d'instanciation de processus au niveau du pool permettant d'initialiser les attributs *dateDebut* et *nombreJours* de la variable métier *demande*
- Un formulaire d'exécution de tâche permettant d'afficher les informations du demandeur et les données *dateDebut* et *nombreJours* en lecture seule puis d'alimenter la donnée *estApprouvee*

## Instructions pas-à-pas
1. Dupliquer le diagramme de processus de l'exercice précédent (2.0.0) pour créer une version *"2.1.0"* du diagramme ET du pool
1. Créer un formulaire d'instanciation :
   - Sélectionner le pool
   - Dans la zone de propriétés, cliquer sur l'onglet **Exécution** puis le sous-onglet **Formulaire d'instanciation**
   - Dans le champ **Formulaire cible**, cliquer sur l'icon **Crayon**
   
   ![création d'un formulaire](images/ex03/ex3_01.png)
   
   Le UI Designer s'ouvre dans votre navigateur web avec un nouveau formulaire généré automatiquement à partir du contrat d'instanciation.
   
   ![Initialisation du formulaire dans UID](images/ex03/ex3_02.png)
   
1. Changer le nom technique du formulaire :
   - Dans le champ texte en haut de l'écran, changer le nom par défaut *newForm* en *"remplirDemandeConges"*. Il s'agit d'un nom technique, donc sans espaces, accents ou autres caractères spéciaux.
   - Cliquer sur le bouton **Enregistrer**
1. Changer le titre du formulaire, visible pour l'utilisateur :
   - Sélectionner le widget de type **Titre** pré-rempli par *Demande* en haut du formulaire.
   - Dans la zone de propriétés à droite de l'écran, éditer les propriétés suivantes :

   Propriété | Valeur
   --------- | ------
   Texte | *"Nouvelle demande de congés"*
   Niveau du titre | **Niveau 2**
   Alignement | **au centre**

1. Changer le widget *Date Picker* *Date Debut* :
   - Sélectionner le widget de type **Date Picker** pré-rempli par *Date Debut* et éditer les propriétés suivantes :

   Propriété | Valeur
   --------- | ------
   Libellé | *"Date de début"*
   Format technique de la date | *"dd/MM/yyyy"*
   Placeholder | *"jj/mm/aaaa"*
   Afficher le bouton Aujourd'hui | **non**

1. Changer le widget **Input** *Nombre Jours* :
   - Sélectionner le widget de type **Input** pré-remppli par *Nombre Jours* et éditer les propriétés suivantes :

   Propriété | Valeur
   --------- | ------
   Libellé | *"Nombre de jours"*
   Placeholder | *"Nombre de jours de congés"*
   Valeur minimum (à ne pas confondre avec la propriété **Longueur minimum de la valeur**) | *"1"*

1. Changer le widget *Button* *Submit* :
   - Sélectionner le widget de type **Button** pré-rempli par *Submit*
   - Changer son *Libellé* en *"Soumettre"*

1. Vérifier le formulaire :
   - Vérifier que le formulaire ressemble à ceci dans l'éditeur :
   
   ![formulaire dans l'UI Designer](images/ex03/ex3_05.png)
   
   - Cliquer sur le bouton **Enregistrer** en haut de l'écran
   - Cliquer sur le bouton **Aperçu** à côté
   - Vérifier que l'aperçu ressemble à ceci :
   
   ![aperçu d'un formulaire](images/ex03/ex3_06.png)
   
   - On notera les points suivants dans l'aperçu :
     - Le widget présentant l'erreur n'est pas visible
     - Il est possible de tester l'aperçu sur différents appareils, du téléphone mobile au grand écran
     - Le bouton *Soumettre* est désactivé par défaut (ceci est dû à la validation fournie par le container de formulaire)
     - Le bouton *Soumettre* est activé quand le contenu du formulaire est valide  

   > **Note :** il n'est pas possible de soumettre le formulaire depuis l'aperçu, même lorsque ce dernier est valide.

1. Fermer la fenêtre d'aperçu

1. Créer un formulaire pour l'étape *Valider demande* :
   - De retour dans Bonita Studio, sélectionner l'étape *Valider demande*
   - Dans la zone de propriétés, l'onglet *Exécution* est déjà sélectionné. Cliquer le sous-onglet **Formulaire**.
   - Dans le champ  **Formulaire cible**, cliquer sur l'icon **Crayon** pour ouvrir un nouveau formulaire dans le UI Designer
   - A la question concernant l'ajout de widgets en lecture seule, répondre **Oui** 

   > **Note :** le formulaire a été généré automatiquement à partir du BDM et du contrat, et affiche en lecture seule les données du BDM qui ne sont pas attendues par le contrat à cette étape.

1. Changer le nom technique du formulaire :
   - Dans le champ en haut, renommer le formulaire en *validerDemandeConges* et l'enregistrer

1. Récupérer les informations concernant le demandeur
   - Dans le panneau en bas de l'écran, cliquer sur le bouton **Créer une nouvelle variable** et définir une variable avec les propriétés suivantes :

   Propriété | Valeur
   --------- | ------
   Nom | demandeur
   Type | External API
   URL d'API | ../API/Identity/user//{{demande.idDemandeur}}

   ![propriétés variable demandeur](images/ex03/ex3_03.png)
   > **Note :** vous pouvez utiliser les exemples qui vous permettent de récupérer automatiquement des modèles d'appels API. Ici on va récupérer `identity API` car on cherche les informations liées à un utilisateur.

1. Modifier le titre du formulaire
   - Sélectionner le widget de type **Titre** pré-rempli par *{{ task.displayName }}* situé en haut du formulaire
   - Configurer le widget de la manière suivante :

   Propriété | Valeur
   --------- | ------
   Texte | *"Valider une demande de congés"*
   Niveau du titre | **Niveau 2**

1. Modifier le widget *Id Demandeur* pour présenter le prénom et nom du demandeur :
   - Sélectionner le widget de type **Texte** pré-rempli par *id Demandeur* 
   - Changer la valeur du *Libellé* en *"Demandeur"*
   - Configurer le champ *Texte* avec les variables : `{{demandeur.firstname}} {{demandeur.lastname}}`
     ![propriétés texte demandeur](images/ex03/ex3_04.png)

1. Changer le widget *Button* *Submit* :
   - Sélectionner le widget de type **Button** pré-rempli par *Submit*
   - Changer son *Libellé* en *"Soumettre"*

1. Vérifier le formulaire :
   - S'assurer que le formulaire ressemble à ceci :
   
   ![Formulaire de validation / refus de la demande de congés](images/ex03/ex3_08.png)

1. Enregistrer le formulaire :
    - Cliquer sur le bouton **Enregistrer** en haut au centre de l'écran pour enregistrer le formulaire

1. Tester l'exécution du processus :
   - De retour dans le studio, lancer l'exécution du processus. Remplir et soumettre le premier formulaire.
   - Dans la User Application, prendre la tâche puis remplir et soumettre le second formulaire
   - En haut à droite de la barre de menu, cliquer l'icon **mosaïque** et choisir **Bonita Administrator Application**
   - Cliquer sur le menu **BPM/Cas**, puis sur l'onglet **Cas archivés**
   - Sur la ligne du cas, cliquer sur **...** pour accéder aux détails. Dans la partie *Monitoring/Liste des tâches pour ce cas*, cliquer sur **En échec (0), En attente (0), Faites (2)**
   - Cliquer sur l'onglet **Tâches faites**
   - Valider que les tâches attendues ont été exécutées

[Exercice suivant : définition des acteurs](05-actors.md)
