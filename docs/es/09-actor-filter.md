---
title: Exercise 9 - Configuring actor filters
---

## Goal

The goal of this exercise is to add collaboration to the existing process by dispatching the tasks between two actors: a requestor and a validator.

## Instructions overview

Dupliqua el diagrama de proceso del ejercicio anterior para crear una versión *9.0.0*.

Replace the current **validator** actor with an actor filter of type **Initiator manager** on the *Validator* lane.

## Step by step instructions

1. Duplicate the process diagram from the previous exercise to create a *5.0.0* version

1. Add an **Initiator manager** actor filter on the *Validator* lane:
   - Select the *Validator* lane
   - Navigate to the **General / Actors** tab
   - Select the *Employee actor* from the drop-down menu to replace *validator* actor
   - Click on the **Set...** button of the actor filter  
     A message will inform you that an actor filter needs to be installed first. Click **OK**. The Bonita MarketPlace will automatically open
   ![actor filter marketplace](images/ex09/ex9_01.png)   
   - Select the *Initiator manager* filter
   - Click on **Install**
   - Select the *Initiator manager* definition and click on **Next**
   - Name the filter *requestorManager*
   - Click on **Finish**

1. Configura un filtro de actor del tipo **Gestor iniciador** en la senda *Validador*:
    - Selecciona la senda *Validador*
    - Navega en la pestaña **General / Actores**
    - Selecciona el actor *Empleado actor* del menú desplegable
    - Haz clic en el botón **Definir ...** asociado con el filtro de actor
    - Selecciona un tipo de filtro **Gestor iniciador**
    - Haz clic en **Siguiente**
    - Nombra el filtro *responsableIniciador*
    - Haz clic en **Finalizar**
    
    ![gerente_iniciador](images/ex04/ex4_10.png)   



   ![Process diagram with two lanes](images/ex04/ex4_02.png)

   - Run the process from the Studio to test it. Initiate a new case with the use Walter Bates.
   - Connect as user *helen.kelly* with *bpm* as password
   - If the actor filter ran correctly, the *Validate request* tasks should now be available in the inbox

[Last exercise: enrich an application with a fragment](10-fragment.md)
