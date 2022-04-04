---
title: Exercice 5 - Gestion des acteurs
---

## Objectif

L'objectif de cet exercice est d'apporter une notion de contribution partagée au processus existant, en distribuant les tâches entre deux acteurs : le demandeur et l'approbateur.

## Instructions simples

Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.0.0*.

Ajouter une lane *Approbateur* au diagramme et y déplacer la tâche *Valider demande*.

Définir un rôle *Approbateur* dans l'organisation, y associer Helen Kelly, manager de Walter Bates.

Associer le rôle *Approbateur* à l'acteur de la lane *Approbateur*.

## Instructions pas-à-pas

1. Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.0.0*

1. Ajouter une lane *Approbateur* au diagramme :
   - Entre l'explorateur de projet et le diagramme, dans la *Palette* d'éléments BPMN, cliquer sur **lane** puis faire un glisser-déposer dans le pool.
   
   ![élément lane dans la palette BPMN](images/ex04/ex4_01.png)
   
   - Dans la zone de propriétés, l'onglet *Général* est déjà sélectionné. Cliquer sur le sous-onglet **Lane**.
   - Dans *Nom*, modifier le nom par défaut en *"Approbateur"*

1. Renommer la première lane en *Demandeur*

1. Faire glisser la tâche *Valider demande* et la tâche associée au timer dans la lane *Approbateur*

1. Vérifier que le diagramme ressemble à ceci :

   ![diagramme avec deux lanes](images/ex04/ex4_02.png)
   
1. Définir les acteurs du processus
   - Cliquer dans la lane **Approbateur**
   - Dans la zone de propriétés, sélectionner le sous-onglet **Acteurs**
   - Tout au bout du champ *Choisissez un acteur*, cliquer sur le bouton **Ajouter ...**
   ![ajouter un acteur](images/ex04/ex4_05.png)
   - Dans le champ **Nom** indiquer *"Approbateur"*. Ne pas cocher la case **Marquer "initiateur"** car l'initiateur de chaque nouvelle instance du processus sera le demandeur.
   - Cliquer sur **Terminer**
   - Vérifier que l'acteur défini dans la lane *Demandeur* est bien l'acteur par défaut *Employee actor*

1. Créer un rôle *Approbateur* dans l'organisation :
   - A gauche du studio, dans l'explorateur du projet, double-cliquer sur **Organisations** et puis sur l'organisation de test **ACME.organisation**.   
     L'éditeur d'organisation s'ouvre, avec la vue d'ensemble sur les groupes, les rôles et les utilisateurs.
     ![éditeur organisation](images/ex04/ex4_03.png)
   - Dans la partie *Rôles de l'organisation*, cliquer sur le **crayon**, à droite
   - Cliquer sur **Ajouter un rôle** (A) puis à droite du champ *Nom*, sur l'icon **crayon** (B).
   - Modifier le nom métier par défaut en *"Approbateur"*.
   ![ajouter un rôle](images/ex04/ex4_04.png)
     
1. Associer ce nouveau rôle à l'utilisateur *Helen Kelly* qui est manager, en charge de la validation des congés de notre utilisateur par défaut *Walter Bates*.
   - En haut de l'éditeur de l'organisation, cliquer sur l'onglet **Utilisateurs** et sélectionner **Helen Kelly**.
   - Dans la section *Adhésion*, modifier le rôle, de *member* à *Approbateur*
     ![ajouter une adhésion](images/ex04/ex4_09.png)
   - En haut de l'éditeur de l'organisation, cliquer sur l'icon **Déployer** pour propager les changements dans le moteur BPM de Bonita
   - Dans les différentes fenêtres modales, cliquer sur le bouton **Enregistrer et déployer**, puis **Déployer** et enfin sur **OK**.

1. Associer le rôle *Approbateur* à l'acteur de la lane *Approbateur*.
   - Dans la Cool Bar, cliquer sur l'icon *Configurer* ![configurer](images/ex04/ex4_06.png) qui va permettre d'associer les acteurs aux entités de l'organisation
   - Dans la fenêtre modale, section **Association acteurs/utilisateurs**, *Employee actor* est déjà associé à un groupe (*/acme*).
   - Cliquer sur l'acteur **Approbateur** (A) puis sur le bouton **Rôles ...** (B)
   - Dans la fenêtre, sélectionner le rôle **Approbateur** (C), cliquer sur le bouton **Terminer**, puis sur **Terminer** dans la modale principale.
     ![mapping acteur](images/ex04/ex4_07.png)
   
   >**Note** Pour aller plus loin, il est aussi possible de définir un *filtre d'acteur*. Cette méthode est décrite dans un prochain exercice.


[Exercice suivant : extensions](06-extensions.md)
