---
title: Ejercicio 4 - Definición de los actores
---

## Objetivo

El objetivo de este ejercicio es aportar una noción de colaboración al proceso existente mediante la distribución de las tareas entre dos actores: el solicitante y el validador.

## Resumen de las instrucciones

Dupliqua el diagrama de proceso del ejercicio anterior para crear una versión *3.0.0*.

Agrega una senda (lane) *Validator* al diagrama y mueve la tarea allí *Validar solicitud*.

Configura un filtro de actor del tipo **Gestor del iniciador de proceso** en la senda *Validator*.

## Instrucciones paso a paso

1. Dupliqua el diagrama de proceso del ejercicio anterior para crear una versión *3.0.0*

1. Agrega una senda (lane) *Validator* al diagrama:
    - Selecciona el elemento de senda de la paleta de elementos BPMN presentes en el lado izquierdo de Bonita Studio:
   
    ![elemento de senda en la paleta BPMN](images/ex04/ex4_01.png)
   
    - Haz clic en el pool de procesos para agregar la senda
    - Selecciona la senda
    - Navega en la pestaña **General / Senda**
    - Cambia el nombre a *Validator*
   
1. Cambia el nombre de la otra senda a *Solicitante*
   
1. Arrastra la tarea *Validar solicitud* en la senda *Validador*

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

1. Verifica que el diagrama se vea así:

    ![diagrama con dos carriles](images/ex04/ex4_02.png)

1. Ejecuta el proceso con los dos actores:
    - Inicia el proceso desde Studio (se usará el usuario Walter Bates)
    - Envía el *Formulario de solicitud de vacaciones*. Si los actores están configurados correctamente, no se debe proponer la tarea *Validar solicitud de vacaciones*
    - Cierra sesión en el portal haciendo clic en el nombre de usuario en la esquina superior derecha y luego **Cerrar sesión**:
    
    ![cierre de sesión del portal](images/ex04/ex4_03.png)
   
 1. Conéctate con el usuario *helen.kelly* y la contraseña *bpm*
 
    - Si el filtro de actor se ejecutó correctamente, la tarea *Validar solicitud de vacaciones* debería estar disponible en la lista de tareas
   
   [Ejercicio siguiente: configuración de un conector](05-connectors.md)
