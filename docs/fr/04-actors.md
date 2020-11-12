---
title: Exercice 4 - Gestion d'acteurs
---

## Objectif

L'objectif de cet exercice est d'apporter une notion de collaboration au processus existant en distribuant les tâches entre deux acteurs : le demandeur et le validateur.

## Instructions résumées

Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.0.0*.

Ajouter une lane *Validateur* au diagramme et y déplacer la tâche *Valider demande*.

Configurer un filtre d'acteur de type **Manager de l'initiateur du processus** sur la lane *Validateur*.

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

1. Faire glisser la tâche *Valider demande* dans la lane *Validateur*

1. Configurer un filtre d'acteur de type **Manager de l'initiateur du processus** sur la lane *Validateur* :
   - Sélectionner la lane *Validateur*
   - Naviguer dans l'onglet **Général / Acteurs**
   - Sélectionner l'acteur *Employee actor* à partir du menu déroulant
   - Cliquer sur le bouton **Définir...** associé au filtre
   - Sélectionner un filtre de type **Manager de l'initiateur du processus**
   - Cliquer sur **Suivant**
   - Nommer le filtre *managerInitiateur*
   - Cliquer sur **Terminer**

1. Vérifier que le diagramme ressemble à ceci :

   ![diagramme avec deux lanes](images/ex04/ex4_02.png)

1. Exécuter le processus avec les deux acteurs :
   - Lancer le processus à partir du Studio (l'utilisateur Walter Bates sera utilisé)
   - Soumettre le formulaire de *Saisie demande congés*. Si les acteurs sont correctement configurés, la tâche *Valider demande de congés* ne devrait pas être proposée
   - Se déconnecter du portail en naviguant sur le nom d'utilisateur dans le coin supérieur droit puis **Déconnexion** :

   ![déconnexion du portail](images/ex04/ex4_03.png)
   
   - Se connecter avec l'utilisateur *helen.kelly* et le mot de passe *bpm*
   - Si le filtre d'acteur s'est bien exécuté, la tâche *Valider demande de congés* devrait être disponible dans la liste des tâches à faire

[Exercice suivant : configuration d'un connecteur](05-connectors.md)
