---
title: Exercice 6 - Créer une application de gestion de congés
---

## Objectif

L'objectif de cet exercice est de fournir aux utilisateurs une application qui permette le suivi et la création de demandes de congés.

## Instructions résumées

Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *4.0.0*.

Ouvrir l'UI Designer et créer une nouvelle **Page d'application** nommée *SuiviDesDemandes* qui permet le suivi des demandes de congés initiés par l'utilisateur connecté.

Cette page contient un container multiple qui liste les demandes de congés ouvertes. Pour chaque demande, la date de début, le nombre de jours et le statut sont affichés.
Elle contient également un bouton qui permet de réaliser une nouvelle demande en renvoyant vers le formulaire d'instanciation du processus.

Créer une nouvelle application et y ajouter la page *SuiviDesDemandes*.

Déployer l'application en utilisant le bouton **Déployer** du Studio.

Accéder à l'application nouvellement créer en utilisant l'URL unique générée.


## Instructions pas à pas

1.Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *4.0.0*.

1. Créer une page d'application :
   - Dans le Studio, cliquer sur le bouton **UI Designer**
   - Cliquer sur le bouton **Créer**
   - Sélectionner **Page d'application**
   - Saisir le nom *SuiviDesDemandes*
   - Cliquer sur **Créer**
   
   ![création d'une page d'application](images/ex06/ex6_01.png)
   
   - La vue de conception devrait maintenant être affichée

1. Ajouter un titre à votre page :
   - Glisser le widget **Title** (A) depuis la palette et placer le en haut de la page (B)
   - Sélectionner le widget
   - Dans le panneau de droite entrer *Application de gestion des demandes de congés* dans le champ **Texte**
   - Sélectionner l'option **au centre** pour le paramètre **Alignement**
   
   ![ajout widget titre](images/ex06/ex6_02.png)

1. Créer une variable pour stocker les informations de session :
   - Cliquer sur **Créer un nouvelle variable**
   - Nommer la *sessionInfo*
   - Choisir le type **External API**
   - Entrer dans le champ **API URL** : `../API/system/session/unusedId`
   
   ![ajout variable session info](images/ex06/ex6_03.png)

1. Créer une variable pour lister les demandes de congés :
   - Cliquer sur l'icône **Data model** ![icone-datamodel](images/ex06/ex6_00.png)
   - Glisser-déposser *DemandeConges* sur la page sous le titre
   - Conserver le nom par défaut : *demandeConges*
   - Dans la section **"Find By" queries on an attribute**, sélectionner *idDemandeur*
   - Dans la section **"Filtrer la requête finByIdDemandeur"** saisir la variable suivante :
   
   ![sessionInfo](images/ex06/ex6_13.png)
   
   - Cliquer sur le bouton **Enregistrer**.  
   
   Un container multiple est automatiquement généré avec un tableau présentant les attributs de l'objet DemandeConges.

   ![container suivi des demandes](images/ex06/ex6_14.png)

1. Remplacer le sous-titre *"DemandeConges"* du container et les libellés : 
   - Le nommer *Suivi des demandes*
   - Sélectionner l'option **Niveau 4** pour le paramètre **Niveau du titre**
   - Sélectionner l'option **au centre** pour le paramètre **Alignement** 
   - Sélectionner le widget Table
   - Dans le panneau de droite, dans le champ **En-têtes**, supprimer *IdDemandeur*
   - Remplacer *Date Debut* par *Date de début*, *Nombre Jours* par *Nombre de jours* et *EstApprouvée* par *Statut*
   

1. Afficher l'information dans les colonnes du tableau de façon plus claire :
    - Dans le panneau de droite, dans le champ **Clés des colonnes**, supprimer *idDemandeur*
    - Supprimer le widget Input *IdDemandeur* dans le container de détails car cette information n'est pas utile 

1. Sélectionner le widget *Date Debut* et éditer les propriétés suivantes :
   
      Propriété | Valeur
      --------- | ------
      Libellé | Date de début
      Format technique de la date | dd/MM/yyyy
      Placeholder | jj/mm/aaaa
      Afficher le bouton Aujourd'hui | non
      
1. Sélectionner le widget *Nombre Jours* et éditer les propriétés suivantes :

      Propriété | Valeur
      --------- | ------
      Libellé | Nombre de jours
      Placeholder | Nombre de jours de congés
      Valeur minimum | 1

   

1. Ajouter un widget **Link**:
   - Retourner dans l'UI designer pour éditer la page de gestion des demandes de congés
   - Glisser un widget **Link** depuis la palette et le placer entre les deux titres
   - Editer les propriétés suivantes :

      Propriété | Valeur
      --------- | ------
      Texte | Nouvelle demande
      Type | Formulaire d'instanciation de processus
      Nom du processus | demandeConges
      Version du processus | 4.0.0
      Alignement | Au centre
      Style | primary
   
   La page devrait ressembler à cela :
   
   ![page d'application dans l'UI Designer](images/ex06/ex6_04.png)
   - Vous pouvez à n'importe quel moment pré-visualiser la page en cliquant sur **Aperçu**

   > Astuce : si vous êtes connectés à l'application utilisateur Bonita dans le même navigateur, les demandes de congés réelles seront affichés.

   Nous allons maintenant déployer l'application dans le portail depuis le Studio.

1. Ajouter un descripteur d'application :
   - Dans le Studio, dans le menu **Développement/Descripteur d'application** sélectionner **Nouveau**. Un fichier .xml est automatiquement initialisé.
   - Cliquer sur *Ajouter un descripteur d'application*
   - Saisir *demande-conges* dans le champ **Token URL de l'application**
   - Saisir *Application de demande de congés* dans le champ **Nom affiché**
   - Cliquer sur le bouton **Ajouter**
   
   ![création d'une application](images/ex06/ex6_15.png)
   
1. Créer une nouvelle application :
   - Dans le menu Navigation, cliquer sur *Ajouter une page à menu unique* (A)
   - Saisir *Suivi des demandes* dans le champ **Menu**
   - Sélectionner la page *custompage_SuiviDesDemandes* dans le champ **Page d'application** (B)
   - Saisir *suivi-demandes* dans le champ **Token** (C)  
   
   ![création d'une application](images/ex06/ex6_07.png)
   
1. Définir la page *SuiviDesDemandes* en tant que page d'accueil de l'application :
   - Sélectionner le token *suivi-demandes* dans le Menu **Page d'accueil**
   
   ![page d'accueil](images/ex06/ex6_16.png)
   
   - Enregistrer
   - Vérifier que la page de configuration ressemble à ceci :
   
   ![page de configuration](images/ex06/ex6_17.png)
   
1. Déployer l'application dans le portail
   - Cliquer sur le lien *http://localhost:8080/bonita/apps/demand`e-conges* pour accéder à l'application. (A)
   - Une fenêtre de déploiement s'ouvre. Cliquer sur *Déployer* (B) 
   
   ![Déployer l'application](images/ex06/ex6_09.png)
   
   - Pour ouvrir l'application, sélectionner *Application de demande de congés en tant que User*.
   - Cliquer sur *Ouvrir*
   
    ![fenetre d'ouverture](images/ex06/ex6_18.png)

Et voilà ! Vous avez terminé votre première itération, avec une application simple et fonctionnelle. Pour aller plus loin, suivez la [deuxième partie](08.contract-deep.md) des exercices.
