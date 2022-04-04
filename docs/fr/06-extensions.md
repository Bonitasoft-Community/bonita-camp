---
title: Exercice 6 - Ajout d'un filtre d'acteur et d'un connecteur
---

## Objectif

L'objectif de cet exercice est d'ajouter des points d'extensions au projet Bonita, avec un filtre d'acteur et un connecteur email. 

- Le filtre d'acteur *Manager de l'initiateur du processus* sera configuré pour chercher dynamiquement dans l'organisation le manager du demandeur.
- Le connecteur email permettra de notifier le demandeur du résultat de sa demande.

> ⚠ En fonction de votre configuration réseau, de votre firewall ou de la configuration de sécurité de votre serveur d'email, il est possible que vous ne soyez pas autorisé à envoyer un email depuis Bonita.  
> Afin de s'abstraire de ces contraintes techniques, cet exercice sera effectué avec un logiciel simulant un serveur d'email (FakeSMTP).

## Instructions simples

Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.1.0*.

### 1ère extension - filtre d'acteur
Ajouter un filtre d'acteur de type *Manager de l'initiateur* sur la lane *Approbateur*.

## 2ème extension - connecteur email
Télécharger et démarrer le serveur [FakeSMTP](http://nilhcem.github.io/FakeSMTP/downloads/fakeSMTP-latest.zip).

Ajouter un connecteur d'envoi d'email sur les tâches automatiques *Notifier approbation* et *Notifier refus*. 

Le code ci-dessous sera utilisé pour récupérer l'adresse email du demandeur dans le connecteur :

```groovy
BonitaUsers.getProcessInstanceInitiatorProfessionalContactInfo(apiAccessor,processInstanceId).email
```
## Instructions pas-à-pas

Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.1.0*.

### 1ère extension - filtre d'acteur
1. Ajouter un filtre d'acteur de type *Manager de l'initiateur* sur la lane *Approbateur* :
   - Sélectionner la lane *Approbateur*
   - Dans la zone de propriétés, onglet *Général*, cliquer sur le sous-onglet **Acteurs**
   - Dans *Filtre de l'acteur*, cliquer sur le bouton **Définir...**
     Une fenêtre modale propose d'installer un filtre à partir de la Bonita Marketplace
     ![filtre_extension](images/ex04/ex4_10.png)
   - Dans la maketplace, cliquer sur le filtre **Initiator manager** puis sur **Installer**
     ![filtre_marketplace](images/ex04/ex4_11.png)
     La définition du filtre fait désormais partie de votre projet.
   - De retour sur la fenêtre modale de configuration du connecteur dans la lane, sélectionner la définition du filtre **Manager de l'initiateur du processus**
   - Cliquer sur **Suivant**
   - Dans *Nom*, saisir *"managerInitiateur"*
   - Cliquer sur **Terminer**

3. Exécuter le processus avec les deux acteurs :
   - Lancer le processus à partir du studio (l'utilisateur *Walter Bates* sera utilisé)
   - Soumettre le formulaire de *Saisie demande congés*. Les acteurs étant correctement configurés, la tâche *Valider demande de congés* n'est pas proposée à Walter Bates.
   - Dans la barre de menu en haut à gauche, cliquer sur **Walter Bates**, puis sur **Déconnexion** :

   ![déconnexion du portail](images/ex04/ex4_08.png)

   - Se connecter avec l'utilisateur *"helen.kelly"* et le mot de passe *"bpm"*
   - Le filtre d'acteur s'est bien exécuté, la tâche *Valider demande de congés* est disponible dans la liste des tâches à faire

### 2ème extension - connecteur email
1. Télécharger et démarrer le serveur [FakeSMTP](http://nilhcem.github.io/FakeSMTP/downloads/fakeSMTP-latest.zip).
   - Décompresser l'archive `fakeSMTP-latest.zip`
   - Lancer FakeSMTP en double cliquant sur le fichier JAR ou en lançant la commande suivante : `java -jar fakeSMTP-2.0.jar`
   - Une fois l'interface graphique de FakeSMTP affichée, configurer le port d'écoute sur *2525* et cliquer sur le bouton **Démarrer le serveur**

2. Ajouter un connecteur d'envoi d'email sur la tâche *Notifier approbation* :
   - Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.1.0*
   - Sélectionner la tâche *Notifier approbation*
   - Dans la zone de propriétés, cliquer sur l'onglet **Exécution**. Le sous-onglet **Connecteurs en entrée** est sélectionné.
   - Cliquer sur **Ajouter...**
     Une fenêtre modale propose d'installer un connecteur à partir de la Bonita Marketplace
     
     ![avertissement connecteur](images/ex05/ex5_00.png)
     >**Note** : Les extensions peuvent être récupérées depuis la Bonita MarketPlace ou depuis des répertoires distants, privés ou publics. Si vous souhaitez aller plus loin, le développement et la gestion de ces extensions sont abordés dans un prochain exercice.
     >
   - Cliquer sur **OK** pour accéder à la MarketPlace et cliquer sur le connecteur **Email** dans la liste.  
     ![MarketPlace](images/ex05/ex5_02.png)
   - Cliquer sur **Installer**  
   - Dans la fenêtre de configuration du connecteur pour la tâche *Notifier approbation*, sélectionner la définition de connecteur de type **Courriel**
   - Cliquer sur le bouton **Suivant**
   - Dans *Nom*, spécifier *"envoiEmailApprobation"* 
   - Cliquer sur **Suivant**
   - Remplir les paramètres de connexion suivants :

   Propriété | Valeur
   --------- | ------
   Hôte SMTP | *"localhost"*
   Port SMTP | *"2525"* (le port spécifié dans FakeSMTP)
   SSL (dans la section *Sécurité*) | décoché 

   - Cliquer sur **Suivant**
   - Dans le champ expéditeur **De**, entrer *"rh@acme.com"* comme adresse email
   - Dans le champ destinataire **A**, utiliser l'icon **crayon** pour éditer l'expression 
   - Dans *Nom*, saisir *"recupEmailDemandeur()"*
   - Dans l'éditeur de script, menu **Modèles de code/Utilisateurs Bonita**, cliquer sur **processInitiatorUser** 
   - Glisser et déposer le modèle dans l'éditeur. Un modèle de script est automatiquement généré.
   
   ![récuperer l'initiateur du processus](images/ex05/ex5_04.png)
   
   - Pour pouvoir retourner l'email de l'initiateur du processus, depuis le menu **Modèles de code/Utilisateurs Bonita**, glisser et déposer **userProfessionalContact** entre `.getStartedBy()` et `}catch(UserNotFoundException e){`
   - Remplacer *userId* par `processInitiator.id`
   - Ajouter un "." et sélectionner *email : string* dans la liste déroulante
   - On peut remplacer `def proContactData = ` par `return`
   
   ![récuperer l'email de l'initiateur](images/ex05/ex5_05.png)
   
   - Cliquer sur le bouton **OK** pour fermer l'éditeur de script
   - Cliquer sur **Suivant**
   - Dans *Sujet*, spécifier *"Demande de congés approuvée"* 
   - Cliquer sur **Terminer**

4. Ajouter un connecteur d'envoi d'email sur la tâche *Notifier refus* :
   - Répéter l'étape précédente en nommant le connecteur *"envoiEmailRefus"* et en spécifiant *"Demande de congés refusée"* comme sujet

   Alternativement, vous pouvez utiliser la fonctionnalité qui permet de copier un connecteur configuré sur une tâche vers une autre tâche.

5. Tester le processus :
   - Exécuter deux fois le processus pour tester les différents chemins et s'assurer que les emails sont bien envoyés et interceptés par FakeSMTP

   [Exercice suivant : création d'une application](07-applications.md)
