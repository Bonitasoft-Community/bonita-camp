---
title: Exercice 5 - Gestion d'acteurs
---

## Objectif

L'objectif de cet exercice est d'apporter une notion de collaboration au processus existant en distribuant les tâches entre deux acteurs : le demandeur et l'approbateur.

## Instructions résumées

Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.0.0*.

Ajouter une lane *Validateur* au diagramme et y déplacer la tâche *Valider demande*.

Définir un rôle *validateur* dans l'organisation et l'associer à l'acteur de la lane *Approbateur*.

Ajouter un filtre d'acteur de type **manager de l'initiateur** sur la tâche *Valider demande*.

## Instructions pas à pas

1. Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.0.0*

1. Ajouter une lane *Validateur* au diagramme :
   - Sélectionner l'élément lane à partir de la palette d'éléments BPMN présente sur le côté gauche du Studio :
   
   ![élément lane dans la palette BPMN](images/ex04/ex4_01.png)
   
   - Cliquer dans le pool du processus pour ajouter la lane
   - Sélectionner la lane
   - Naviguer dans l'onglet **Général / Lane**
   - Modifier le nom en *Validateur*

1. Renommer l'autre lane en *Demandeur*

1. Faire glisser la tâche *Valider demande* et la tâche associée au timer dans la lane *Validateur*

1. Vérifier que le diagramme ressemble à ceci :

   ![diagramme avec deux lanes](images/ex04/ex4_02.png)
   
1. Définir les acteurs du processus
   - sélectionner la lane *validateur*
   - Naviguer dans l'onglet **Général / Acteur**
   - Cliquer sur le bouton **Ajouter**
   ![ajouter un acteur](images/ex04/ex4_05.png)
   - Dans le champ **Nom** indiquer *validateur*. Ne pas cocher la case **Initiateur** car l'initiateur est le demandeur.
   - Cliquer sur **Terminer**
   - Vérifier que l'acteur défini dans la lane *Demandeur* est bien l'acteur par défaut *Employee actor*

### Option 1 - définir un rôle
1. Créer un rôle *validateur* dans l'organisation :
   - Dans l'explorateur du projet, cliquer sur **Organisation** et sélectionner l'organisation de test *ACME.organisation*.   
     L'éditeur d'organisation s'ouvre, avec la vue d'ensemble sur les groupes, les rôles et les utilisateurs.
     ![éditeur organisation](images/ex04/ex4_03.png)
   - Cliquer sur le crayon pour éditer les rôles. 
   - Cliquer sur **Ajouter un rôle** (A) puis éditer (B) le nom technique du rôle (en cliquant sur le crayon) pour indiquer *validateur*.
   - Nommer le rôle *Validateur*.
   ![ajouter un rôle](images/ex04/ex4_04.png)
     Associer ce nouveau rôle à l'utilisateur *Helen Kelly* qui est en charge de la validation des congés de notre utilisateur par défaut *Walter Bates*.
   - Aller dans l'onglet **Utlisateur** et sélectionner *Helen Kelly*.
   - Dans la section **Adhésion**, modifier le rôle de *member* à *validateur*
     ![ajouter une adhésion](images/ex04/ex4_09.png)
   - Déployer l'organisation pour prendre en compte les changements en cliquant sur l'icône **Déployer**.  
   >**Note** Pour aller plus loin, il est aussi possible de définir un filtre d'acteur. Cette méthode est décrite dans un prochain exercice.


[Exercice suivant : extensions](06-extensions.md)
