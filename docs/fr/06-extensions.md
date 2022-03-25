---
title: Exercice 6 - Extensions: filte d'acteur et connecteur email
---

## Objectif

L'objectif de cet exercice est d'ajouter des points d'extensions d'un projet Bonita, avec un filtre d'acteur et un connecteur email. Ces points d'extensions sont disponibles dans le Bonita Marketplace.

Un filtre d'acteur **Manager de l'initiateur du processus** sera configuré dans l'acteur manager de l'initiateur.

Aussi, nous allons traiter une interaction entre le processus et un système externe par le biais d'un connecteur. Nous nous intéresserons ici à la notification du résultat de la demande de congés par le biais d'un connecteur d'envoi d'email.

> ⚠ En fonction de votre configuration réseau, de votre firewall ou de la configuration de sécurité de votre serveur d'email, il est possible que vous ne soyez pas autorisé à envoyer un email depuis Bonita.  
> Afin de s'abstraire de ces contraintes techniques, cet exercice sera effectué avec un logiciel simulant un serveur d'email (FakeSMTP).

## Instructions résumées

Ajouter un filtre d'acteur de type **manager de l'initiateur** sur la tâche *Valider demande*.

Obtenir et démarrer le serveur [FakeSMTP](http://nilhcem.github.io/FakeSMTP/downloads/fakeSMTP-latest.zip).

Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.1.0*.

Ajouter un connecteur d'envoi d'email sur les tâches automatiques *Notifier approbation* et *Notifier refus*. Ceux-ci enverront un email au demandeur avec le statut de validation de sa demande.

Le code ci-dessous sera utilisé pour récupérer l'email du demandeur dans le connecteur :

```groovy
BonitaUsers.getProcessInstanceInitiatorProfessionalContactInfo(apiAccessor,processInstanceId).email
```
## Instructions pas à pas

### 1re extension - filtre d'acteur
1. Sélectionner la lane *Validateur*

2. Configurer un filtre d'acteur de type **Manager de l'initiateur du processus** sur la lane *Validateur* :
   - Sélectionner la lane *Validateur*
   - Naviguer dans l'onglet **Général / Acteurs**
   - Sélectionner l'acteur *Employee actor* à partir du menu déroulant (vous pouvez aussi définir l'acteur *validateur*
   - Cliquer sur le bouton **Définir...** associé au filtre
   - Si aucun filtre n'a été défini, il vous sera suggéré d'en installer un
     ![filtre_extension](images/ex04/ex4_10.png)
   - Sélectionner un filtre de type **Manager de l'initiateur** dans le MarketPlace des extensions
     ![filtre_marketplace](images/ex04/ex4_11.png)
   - Sélectionner la définition du filtre **Manager de l'initiateur du processus**
   - Cliquer sur **Suivant**
   - Nommer le filtre *managerInitiateur*
   - Cliquer sur **Terminer**

3. Lier l'organisation aux acteurs du processus :
   - Cliquer sur l'icône *Configurer* ![configurer](images/ex04/ex4_06.png) qui va permettre d'associer les acteurs aux bons rôles dans l'organisation.
   - Dans l'éditeur, sélectionner **Association acteurs/utilisateurs**. L'employee actor est déjà associé à un groupe, il faut donc faire de même avec l'acteur **validateur**
   - Sélectionner l'acteur **validateur** (A) puis cliquer sur le bouton **Rôles** (B)
   - Dans la fenêtre, sélectionner le rôle **validateur** (C)
     ![mapping acteur](images/ex04/ex4_07.png)

4. Exécuter le processus avec les deux acteurs :
   - Lancer le processus à partir du Studio (l'utilisateur Walter Bates sera utilisé)
   - Soumettre le formulaire de *Saisie demande congés*. Si les acteurs sont correctement configurés, la tâche *Valider demande de congés* ne devrait pas être proposée
   - Se déconnecter de l'application utilisateur en naviguant sur le nom d'utilisateur dans le coin supérieur droit puis **Déconnexion** :

   ![déconnexion du portail](images/ex04/ex4_08.png)

   - Se connecter avec l'utilisateur *helen.kelly* et le mot de passe *bpm*
   - Si le filtre d'acteur s'est bien exécuté, la tâche *Valider demande de congés* devrait être disponible dans la liste des tâches à faire

### 2me extension - connecteur email
1. Mise en place de FakeSMTP :
   - Récupérer le binaire de FakeSMTP depuis cette URL : [http://nilhcem.github.com/FakeSMTP/downloads/fakeSMTP-latest.zip](http://nilhcem.github.com/FakeSMTP/downloads/fakeSMTP-latest.zip)
   - Décompresser l'archive `fakeSMTP-latest.zip`
   - Lancer FakeSMTP en double cliquant sur le fichier JAR ou en lançant la commande suivante : `java -jar fakeSMTP-2.0.jar`
   - Une fois l'interface graphique de FakeSMTP affichée, configurer le port d'écoute sur *2525* et cliquer sur le bouton **Démarrer le serveur**

2. Dupliquer le diagramme de processus de l'exercice précédent pour créer une version *3.1.0*

3. Ajouter un connecteur d'envoi d'email sur la tâche *Notifier approbation* :
   - Sélectionner la tâche *Notifier approbation*
   - Naviguer dans l'onglet **Exécution / Connecteurs en entrée**
   - Cliquer sur **Ajouter\...**
     Un avertissement  indique qu'aucun connecteur n'a été préalablement installé dans le projet et invite à le faire. 
     
     ![avertissement connecteur](images/ex05/ex5_00.png)
     >**Note** : Les extensions peuvent être récupérées depuis le Bonita MarketPlace ou depuis des répertoires distants privés ou publiques. Si vous souhaitez aller plus loing, le développement et la gestion de ces extensions sont abordées dans un prochain exercice.
   - Cliquer sur OK pour accéder au MarketPlace et sélectionner le connecteur **Email** dans la liste.  
     ![MarketPlace](images/ex05/ex5_02.png)
   - Cliquer sur **Installer**  
   - Sélectionner la définition de connecteur de type **Courriel**
   - Cliquer sur le bouton **Suivant**
   - Spécifier *envoiEmailApprobation* comme nom
   - Passer à la page suivante
   - Remplir les paramètres de connexion suivants :

   Propriété | Valeur
   --------- | ------
   Hôte SMTP | *localhost*
   Port SMTP | *2525* (le port spécifié dans FakeSMTP)
   SSL (sous l'onglet **Sécurité**) | décoché 

   - Passer à la page de configuration du destinataire
   - Entrer *rh@acme.com* comme adresse email dans le champ expéditeur **De**
   - Utiliser l'icône **crayon** pour éditer l'expression sur le champ destinataire **A**
   - Nommer le script *recupEmailDemandeur*
   - Dans l'éditeur de script, sélectionner *processInitiatorUser* dans le menu **Modèles de code/Utilisateurs Bonita**
   - Glisser et déposer le modèle dans l'éditeur. Un modèle de script est automatiquement généré.
   
   ![récuperer l'initiateur du processus](images/ex05/ex5_04.png)
   
   - Pour pouvoir retourner l'email de l'initiateur du processus, glisser et déposer *userProfessionalContact* depuis le menu **Modèles de code/Utilisateurs Bonita** entre `.getStartedBy()` et `}catch(UserNotFoundException e){`
   - Remplacer *userId* par `processInitiator.id`
   - Ajouter un "." et sélectionner *email : string* dans la liste déroulante
   - On peut remplacer `def proContactData = ` par `return`
   
   ![récuperer l'email de l'initiateur](images/ex05/ex5_05.png)
   
   - Cliquer sur le bouton **OK** pour fermer l'éditeur de script
   - Passer à la page suivante
   - Spécifier *Demande de congés approuvée* comme sujet
   - Cliquer sur **Terminer**

4. Ajouter un connecteur d'envoi d'email sur la tâche *Notifier refus* :
   - Répéter l'étape précédente en nommant le connecteur *envoiEmailRefus* et en spécifiant *Demande de congés refusée* comme sujet

   Alternativement, vous pouvez utiliser la fonctionnalité qui permet de copier un connecteur configuré sur une tâche vers une autre tâche.

5. Tester le processus :
   - Exécuter deux fois le processus pour tester les différents chemins et s'assurer que les emails sont bien envoyés et interceptés par FakeSMTP

   [Exercice suivant : création d'une application](07-applications.md)
