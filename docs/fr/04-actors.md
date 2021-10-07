---
title: Exercice 4 - Gestion d'acteurs
---

## Objectif

L'objectif de cet exercice est d'apporter une notion de collaboration au processus existant en distribuant les tâches entre deux acteurs : le demandeur et l'approbateur.

## Instructions résumées

Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.0.0*.

Ajouter une lane *Approbateur* au diagramme et y déplacer la tâche *Valider demande*.

Définir un rôle *approbateur* dans l'organisation et l'associer à l'acteur de la lane *Approbateur*.

## Instructions pas à pas

1. Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.0.0*

1. Ajouter une lane *Approbateur* au diagramme :
   - Sélectionner l'élément lane à partir de la palette d'éléments BPMN présente sur le côté gauche du Studio :
   
   ![élément lane dans la palette BPMN](images/ex04/ex4_01.png)
   
   - Cliquer dans le pool du processus pour ajouter la lane
   - Sélectionner la lane
   - Naviguer dans l'onglet **Général / Lane**
   - Modifier le nom en *Approbateur*

1. Renommer l'autre lane en *Demandeur*

1. Faire glisser la tâche *Valider demande* dans la lane *Approbateur*

1. Vérifier que le diagramme ressemble à ceci :

   ![diagramme avec deux lanes](images/ex04/ex4_02.png)

1. Créer un rôle *approbateur* dans l'organisation :
   - Dans l'explorateur du projet, cliquer sur **Organisation** et sélectionner l'organisation de test *ACME.organisation*.   
     L'éditeur d'organisation s'ouvre, avec la vue d'ensemble sur les groupes, les rôles et les utilisateurs.
     ![éditeur organisation](images/ex04/ex4_03.png)
   - Cliquer sur le crayon pour éditer les rôles. 
   - Cliquer sur **Ajouter un rôle** (A) puis éditer (B) le nom technique du rôle (en cliquant sur le crayon) pour indiquer *approbateur*.
   - Nommer le rôle *Approbateur*.
   ![ajouter un rôle](images/ex04/ex4_04.png)
     Associer ce nouveau rôle à l'utilisateur *Helen Kelly* qui est en charge de la validation des congés de notre utilisateur par défaut *Walter Bates*.
   - Aller dans l'onglet **Utlisateur** et sélectionner *Helen Kelly*.
   - Dans la section **Adhésion**, modifier le rôle de *member* à *approbateur*
     ![ajouter une adhésion](images/ex04/ex4_09.png)
   - Déployer l'organisation pour prendre en compte les changements en cliquant sur l'icône **Déployer**.  
   >**Note** Pour aller plus loin, il est aussi possible de définir un filtre d'acteur. Cette méthode est décrite dans un prochain exercice.
   
1. Définir les acteurs du processus
   - Revenir sur le diagramme et sélectionner la lane *Approbateur*
   - Naviguer dans l'onglet **Général / Acteur**
   - Cliquer sur le bouton **Ajouter**
   ![ajouter un acteur](images/ex04/ex4_05.png)
   - Dans le champ **Nom** indiquer *approbateur*. Ne pas cocher la case **Initiateur** car l'initiateur est le demandeur.
   - Cliquer sur **Terminer**
   - Vérifier que l'acteur défini dans la lane *Demandeur* est bien l'acteur par défaut *Employee actor*

1. Lier l'organisation aux acteurs du processus :
   - Cliquer sur l'icône *Configurer* ![configurer](images/ex04/ex4_06.png) qui va permettre d'associer les acteurs aux bons rôles dans l'organisation.
   - Dans l'éditeur, sélectionner **Association acteurs/utilisateurs**. L'employee actor est déjà associé à un groupe, il faut donc faire de même avec l'acteur **approbateur**
   - Sélectionner l'acteur **approbateur** (A) puis cliquer sur le bouton **Rôles** (B)
   - Dans la fenêtre, sélectionner le rôle **approbateur** (C)
    ![mapping acteur](images/ex04/ex4_07.png)

1. Exécuter le processus avec les deux acteurs :
   - Lancer le processus à partir du Studio (l'utilisateur Walter Bates sera utilisé)
   - Soumettre le formulaire de *Saisie demande congés*. Si les acteurs sont correctement configurés, la tâche *Valider demande de congés* ne devrait pas être proposée
   - Se déconnecter de l'application utilisateur en naviguant sur le nom d'utilisateur dans le coin supérieur droit puis **Déconnexion** :

   ![déconnexion du portail](images/ex04/ex4_08.png)
   
   - Se connecter avec l'utilisateur *helen.kelly* et le mot de passe *bpm*
   - Si le filtre d'acteur s'est bien exécuté, la tâche *Valider demande de congés* devrait être disponible dans la liste des tâches à faire

[Exercice suivant : configuration d'un connecteur](05-connectors.md)
