---
title: Exercice 7 - Création d'une page d'application puis de son descripteur
---

## Objectif

L'objectif de cet exercice est de fournir aux utilisateurs une application qui permette le suivi et la création de demandes de congés en créant l'IHM principale.

## Instructions simples

 1. Créer une page d'application nommée *"SuiviDesDemandes"* qui permet le suivi des demandes de congés initiées par l'utilisateur connecté.
    Cette page contient un container multiple qui liste les demandes de congés ouvertes. Pour chaque demande, la date de début, le nombre de jours et le statut sont affichés.
 1. Ajouter un nouveau *form container* pour faire une nouvelle demande de congés.
    Ce formulaire contient un widget *Date* et un widget *Input* pour collecter les informations nécessaires et un bouton pour soumettre la nouvelle demande
 1. Créer un descripteur d'application et y ajouter la page *SuiviDesDemandes*.
 1. Déployer l'application et y accéder en utilisant l'URL unique générée.

## Instructions pas-à-pas

### Créer une page d'application nommée *"SuiviDesDemandes"*

 1. Dans le navigateur web, retourner dans le UI Designer
    Si l'onglet a été fermé, revenir au studio. Dans la Cool Bar, cliquer sur le bouton **UI Designer**, et dans la fenêtre d'information, cliquer **OK**
 
 1. Si besoin, cliquer sur **l'icon du UI Designer** en haut à gauche pour revenir sur la page d'accueil 
 
 1. Cliquer sur le bouton **Créer**
 
 1. Dans *Type*, garder la sélection **Page d'application**
 
 1. Dans *Nom*, qui est un nom technique, saisir *"SuiviDesDemandes"*
 
 1. Cliquer sur **Créer**
   
   ![création d'une page d'application](images/ex06/ex6_01.png)
   
   L'éditeur de page s'affiche

 1. Ajouter un titre à votre page :
   - Depuis la palette à gauche, cliquer sur le widget **Title** (A) et le glisser-déposer en haut de la page (B)
   - Dans le panneau de propriétés à droite, dans le champ *Texte*, entrer *"Application de gestion des demandes de congés"*
   - Pour *Alignement*, sélectionner l'option **au centre**
   
   ![ajout widget titre](images/ex06/ex6_02.png)

 1. Créer une variable pour stocker les informations de session :
   - En bas, dans le panneau de variables, cliquer sur **Créer un nouvelle variable**
   - La nommer *"sessionInfo"*
   - Choisir le type **External API**
   - Dans le champ **API URL**, entrer `../API/system/session/unusedId`
   - Cliquer sur **Enregistrer**
   
   ![ajout variable session info](images/ex06/ex6_03.png)

 1. Créer une variable pour lister les demandes de congés :
   - Tout à gauche de la palette, cliquer sur l'icon **Modèle de données** ![icone-datamodel](images/ex06/ex6_00.png)
   - Cliquer sur **DemandeConges** puis glisser-déposer dans la page, sous le titre
   - Conserver le nom par défaut : *"demandeConges"*
   - Dans la section *Requêtes "Find By" sur un attribut**, sélectionner *idDemandeur*
   - Dans la section *Filtrer la requête finByIdDemandeur* saisir la variable suivante : `{{sessionInfo.user_id}}`
   
   ![sessionInfo](images/ex06/ex6_13.png)
   
   - Cliquer sur le bouton **Enregistrer**.  
   
   Un container multiple est automatiquement généré avec un tableau présentant les attributs de l'objet *DemandeConges*.

   ![container suivi des demandes](images/ex06/ex6_14.png)

 1. Modifier les propriétés des widgets du container :
   - Pour le widget *Title*, changer le *Texte* "DemandeConges" en *"Suivi des demandes"*
   - Pour l'*Alignement*, sélectionner l'option **au centre** 
   - Pour le widget *Table*, pour *En-têtes*, supprimer "IdDemandeur"
   - Remplacer "Date Debut" par *"Date de début"*, "Nombre Jours" par *"Nombre de jours"* et "EstApprouvée" par *"Statut"*

 1. Déclarer une nouvelle expression JavaScript pour mettre en forme la colonne "Statut" de la liste :
   - Cliquer sur **Créer un nouvelle variable**
   - La nommer *"ajoutLibelleStatutDemandeConges"*
   - Choisir le type **JavaScript expression**
   - Remplacer la valeur existante par le script suivant :
   ```javascript
   if($data.hasOwnProperty('demandeConges') && $data.demandeConges) {
     for (let demande of $data.demandeConges) {
       if(demande.estApprouvee)  {
         demande.estApprouveeLabel = "Approuvée";
       } else if(demande.estApprouvee === false) {
         demande.estApprouveeLabel = "Rejetée";
       } else {
         demande.estApprouveeLabel = "En cours";
       }
     }
   }

   return $data.demandeConges;
   ```

  1. Afficher l'information dans les colonnes du tableau de façon plus claire :
    - Dans le panneau de droite, dans le champ **Clés des colonnes**, supprimer *idDemandeur*
    - Dans le même champ, remplacer *estApprouvee* par *estApprouveeLabel*, créé dans la variable JavaScript
    - Dans le container en-dessous, supprimer le widget *Input* "IdDemandeur", car cette information n'est pas utile 

  1. Sélectionner le widget *Date picker* "Date Debut" et éditer les propriétés suivantes :
      
      Propriété | Valeur
      --------- | ------
      Libellé | Date de début
      Format technique de la date | dd/MM/yyyy
      Placeholder | jj/mm/aaaa
      Afficher le bouton Aujourd'hui | non
      
  1. Sélectionner le widget *Input* "Nombre Jours" et éditer les propriétés suivantes :

      Propriété | Valeur
      --------- | ------
      Libellé | Nombre de jours
      Placeholder | Nombre de jours de congés
      Valeur minimum | 1
   
  
   La page devrait ressembler à cela :
   
   ![page d'application dans l'UI Designer](images/ex06/ex6_04.png)
   
   Vous pouvez à n'importe quel moment pré-visualiser la page en cliquant sur **Aperçu**

   > Astuce : si vous êtes connecté·e à la Bonita User Application dans le même navigateur, les demandes de congés réelles de l'utilisateur connecté s'affichent.

### Ajouter un nouveau *form container* pour faire une nouvelle demande de congés

 1. Ajouter un *Form container*
   - Tout à gauche de la palette, cliquer sur l'onglet **Widgets**
   - Depuis la palette, cliquer sur **Form container** et le glisser-déposer sous le premier titre, hors de tout container existant

 1. Créer une nouvelle variable pour stocker les informations liées à la demande de congés :
   - Cliquer sur **Créer sur une nouvelle variable**
   - Nommer la variable *"nouvelleDemandeConges"*
   - Choisir le type **Javascript expression**
   - Dans le champ texte *Valeur*, taper le script suivant :
   ```
   var demande = {
     demandeInput : {
       dateDebut : null,
       nombreJours : null,
       idDemandeur : $data.sessionInfo.user_id
     }
   };
   return demande;
   ```
   - Cliquer sur **Enregistrer**

 1. Créer une nouvelle variable pour stocker les informations liées au processus :
   - Cliquer sur **Créer une nouvelle variable**
   - Nommer la variable *"informationDefinitionProcessus"*
   - Choisir le type **External API**
   - Dans le champ *URL d'API*, taper : `../API/bpm/process?p=0&c=100&o=version%20DESC&f=name=DemandeConges`
   - Cliquer sur **Enregistrer**

 1. Ajouter deux widgets dans le form container :
   - Un widget **Date picker** avec les options :
     - Largeur : *"6"*
     - Libellé : *"Date de début"*
     - Valeur : `nouvelleDemandeConges.demandeInput.dateDebut`
     - Afficher le bouton Aujourd'hui : **non**

   - Un widget **Input** à droite du widget *Date picker* avec les options :
     - Libellé : *"Nombre de jours"*
     - Valeur : `nouvelleDemandeConges.demandeInput.nombreJours`
     - Type : **number**
     - Valeur minimum : *"1"*

 1. Ajouter un bouton pour soumettre le formulaire :
   - Glisser le widget **Button** depuis la palette jusqu'en dessous des deux widgets, dans le form container
   - Pour le champ *Libellé*, entrer *"Créer une nouvelle demande"*
   - Pour *Alignement*, choisir **au centre**
   - Pour *Style*, choisir **Primary**
   - Dans la list déroulante *Action*, sélectionner **POST**
   - Dans le champ *URL à appeler*, taper : `../API/bpm/process/{% raw %}{{informationDefinitionProcessus[0].id}}{% endraw %}/instantiation`
   - Pour le champ *Données envoyés au clic*, cliquer d'abord sur **fx** pour changer le mode du champ et taper *"nouvelleDemandeConges"*
   - Dans le champ *URL cible en cas de succès*, taper : `/bonita/apps/demande-conges`
   - Enregistrer
   - La page devrait maintenant ressembler à ceci :
   
   ![page d'application dans l'UI Designer avec formulaire](images/ex06/ex6_05.png)
   
   - Pré-visualiser la page (bouton **Aperçu**) pour vérifier qu'elle fonctionne correctement

### Créer un descripteur d'application et y ajouter la page *SuiviDesDemandes*

 1. De retour dans le studio, dans l'explorateur de projet, faire un clic droit sur **DemandeConges**, puis **Nouveau/Descripteur d'application**. 
 
 1. Dans la fenêtre d'explication, faire **OK**.
     Un fichier .xml est automatiquement initialisé. Il peut contenir plusieurs descripteurs d'applications, un par profil par exemple.
 
 1. Cliquer sur **Ajouter un descripteur d'application**
 
 1. Dans le champ *Token URL de l'application*, saisir *"demande-conges"* 
 
 1. Dans le champ *Nom affiché*, saisir *"Application de demandes de congés"*
 
 1. Cliquer sur le bouton **Ajouter**
   
   ![création d'une application](images/ex06/ex6_15.png)
   
 1. Dans l'éditeur de descripteur d'application, section *Navigation* à droite, cliquer sur **Ajouter menu à page unique** (A)
 
 1. Dans le champ *Menu*, saisir *"Suivi des demandes"* 
 
 1. Dans le champ *Page d'application*, double-cliquer sur **SuiviDesDemandes** (B)
 
 1. Dans le champ **Token**, saisir *"suivi-demandes"* (C)  
 
 1. Cliquer hors du champ de saisie pour valider 
   
   ![création d'une application](images/ex06/ex6_07.png)
   
 1. Définir la page *SuiviDesDemandes* en tant que page d'accueil de l'application :
   - Dans la section *Page d'accueil*, double-cliquer sur le token *suivi-demandes* 
   
   ![page d'accueil](images/ex06/ex6_16.png)
   
   - Enregistrer avec *Ctrl+S*
   - Vérifier que la page de configuration ressemble à ceci :
   
   ![page de configuration](images/ex06/ex6_17.png)
   
### Déployer l'application et y accéder en utilisant l'URL unique générée

 1. Cliquer sur le lien *http://localhost:8080/bonita/apps/demande-conges* pour accéder à l'application. (A)
    Une fenêtre de déploiement s'ouvre. Cliquer sur *Déployer* (B) 
   
   ![Déployer l'application](images/ex06/ex6_09.png)
   
   La proposition par défaut *Application de demande de congés en tant que User* est celle qui convient pour notre cas
 
 1. Cliquer sur *Ouvrir*

    ![fenetre d'ouverture](images/ex06/ex6_18.png)
    
 1. L'application doit ressembler à ça une fois déployée :
    
   ![rendu de l'application](images/ex06/ex6_08.png)
   

[Exercice suivant : création d'un fragment](08-fragment.md)
