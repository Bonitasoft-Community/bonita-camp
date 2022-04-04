---
title: Exercise 8 - Ajout d'un fragment
---

## Objectif

L'objectif de cet exercice est de créer un fragment contenant l'information d'une demande de congés. L'intérêt du fragment est d'être réutilisable dans différentes pages d'une façon simple.

## Instructions simples

Dans le formulaire *remplirDemandeConges*, créer un fragment avec les widgets *Date picker* et *Input* qui collectent les informations de nouvelle demande de congés. 

Utiliser ce fragment dans la page *SuiviDesDemandes* et bien associer ses données.

Redéployer la page de l'application à l'aide du bouton **Déployer** du descripteur de l'application dans Bonita Studio et accéder à l'application à l'aide de l'URL générée.

## Instructions pas-à-pas
   
### Dans le formulaire *remplirDemandeConges*, créer un fragment

1. Ouvrir le formulaire
- Dans le UI Designer, en haut à gauche, cliquer sur l'icon du UI Designer pour revenir à la page d'accueil
- Cliquer sur l'onglet **Formulaires**
- Cliquer sur le formulaire **remplirDemandeConges**

1. Créer un fragment à partir du formulaire *remplirDemandeConges* :
- Sélectionner le container sous le titre
- Dans le panneau de propriétés à droite, à côté de *Container* en haut, cliquer sur **...** puis sélectionner **Enregistrer en tant que fragment ...**.  
 ![fragment selection in UI Designer](images/ex08/ex08_03.png)
- Dans *Nom*, saisir *"nouvelleDemandeFragment"*.
- Cliquer sur **Enregistrer**. 
  Tout à gauche de la palette, un nouvel onglet *fragments* apparaît.  
  ![menu fragment in UI Designer](images/ex08/ex08_04.png)
- **Enregistrer** le formulaire puis revenir à la page d'accueil du UI Designer.  
   
1. Configurer le fragment :
- Sélectionner le fragment et cliquer sur **Modifier...** pour configurer les variables du fragment.  
  ![menu fragment in UI Designer](images/ex08/ex08_05.png)
- Cliquer sur **Créer une nouvelle variable**.
- La nommer *dataExt*.
- A la question de l'exposition de la variable au niveau de la page, choisir **Oui**
- **Enregistrer** la variable. 
- Sélectionner le widget **Date Picker**
- Dans le champ *Valeur*, remplacer "formInput"(...) par *"dataExt"*. 
- Sélectionner le widget **Input**
- Dans le champ *Valeur*, remplacer "formInput" (...) par *"dataExt"* 
- Cliquer sur **Enregistrer**.

### Utiliser ce fragment dans la page *SuiviDesDemandes* et bien associer ses données

1. Ajouter le fragment à la page :
- Retourner à la page *SuiviDesDemandes*
- Supprimer les champs *Date Picker* et *Input*
- Depuis l'onglet "fragment", glisser-déposer le fragment dans la page à la place des widgets supprimés
- Dans le panneau de configuration, dans *Bindable fragment data* ajouter la variable *nouvelleDemandeConges*.
- **Enregistrer** la page.
- Cliquez sur **Aperçu**.
  La page devrait ressembler à ça :
   
   ![Application page in UI Designer including a form](images/ex08/ex08_06.png)
   
### Redéployer la page de l'application et accéder à l'application à l'aide de l'URL générée.   

- De retour dans le studio, cliquer sur le bouton **Déployer**.
- Une fenêtre de déploiement s'ouvre. Sélectionner le descripteur d'application, la page et le formulaire, et cliquer sur **Déployer**. 
   
   ![Deploy the application](images/ex08/ex08_07.png)
   
   - *Application de demande de congés en tant que User* est l'application sélectionnée par défaut. C'est celle qui nous convient.
   - Cliquer sur **Ouvrir**.
   
    ![opening window](images/ex08/ex08_08.png)

L'application devrait ressembler à ceci une fois déployée :
   
   ![application rendering](images/ex06/ex6_08.png)   


Et c'est tout!
