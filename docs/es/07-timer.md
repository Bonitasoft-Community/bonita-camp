---
title: Ejercicio 7 - Agregar un evento de tiempo al proceso
---

## Objetivo

El objetivo de este ejercicio es enriquecer la primera versión del diagrama del proceso de solicitud de vacaciones con un **evento de tiempo** en la tarea de validación.

Este evento de tiempo enviará automáticamente un recordatorio al validador si no realiza la tarea a tiempo, sin interrumpir el proceso.

## Resumen de las instrucciones

Duplica el diagrama de proceso del ejercicio anterior para crear una versión 7.0.0.

Agrega un evento límite de tiempo no interruptor en la tarea *Validar solicitud*.
La duración del temporizador es de **5 segundos**.

Agrega una tarea de servicio llamada *Enviar recordatorio de validación* y un evento de fin llamado *Fin - Recordatorio enviado*.

Añade un conector de correo electrónico en la tarea de servicio *Enviar recordatorio de validación*. Enviará un correo electrónico de recordatorio al validador.


## Instrucciones paso a paso

1. Agrega un evento límite de tiempo no interruptor a la tarea *Validar solicitud*:
   - Haz clic en la tarea *Validar solicitud*.
   - En la caja de herramientas, agrega un evento límite  
  ![Caja de herramientas de eventos límite](images/ex07/ex7_01.png)
   - Selecciona el **evento de tiempo no interruptor** en la lista. Se agregara automáticamente a la tarea.
  ![evento de temporizador que no interrumpe](images/ex07/ex7_02.png)

1. Crea una tarea de servicio llamada *Enviar recordatorio de validación* después del evento de límite arrastrando y soltando la tarea del evento al carril.
1. Agrega un evento de fin llamado *Fin - recordatorio enviado* junto a la tarea de servicio recién añadida.
   
1. Configura el evento de tiempo:
   - Selecciona el evento de tiempo de límite
   - Vete a la pestaña **General / General**.
   - Agrega el nombre del evento de tiempo *Enviar recordatorio después de 5s*.
   - Establezca la condición del evento haciendo clic en **Editar**.
   - En el editor, selecciona **Duración** para establecer la condición del temporizador y pon *5* en el campo **Segundos** (A)
   - Haz clic en **Generar expresión de duración** (B)
   - Haz clic en **Finalizar**
     ![condición del temporizador](images/ex07/ex7_03.png)
     La condición del temporizador se genera automáticamente y debe aparecer en la pestaña **General**

1. Agrega un conector de correo electrónico en la tarea *Enviar recordatorio de validación*:
   - Selecciona la tarea *Notificar solicitud aprobada*.
   - Vete a la pestaña **Ejecución / Conectores entrada**.
   - Selecciona el conector de correo electrónico existente *enviarRequestApprovedEmail*.
   - Haz clic en **Mover/Copiar...**
   - En el editor, selecciona la acción a realizar **Copiar** y la tarea de servicio *Enviar Recordatorio de Validación*
   - Haz clic en **Finalizar**.  
      ![Conector de copia](images/ex07/ex7_04.png)
     
1. Configura el conector de correo electrónico en la tarea *Enviar recordatorio de validación*:
   - Selecciona la tarea *Enviar recordatorio de validación*.
   - Vete a la pestaña **Ejecución / Conectores entrada**.
   - Selecciona el conector de correo electrónico y haz clic en **Editar**.
   - Actualiza el nombre a *enviarRecordatorioEmail*.
   - Haz clic en **Siguiente**.
   - No hay que cambiar los parámetros
   - Pasa a la página de configuración de *Destinatario del correo electrónico*.
   - Mantene *hr@acme.com* en el campo **De**.
   - Utiliza el icono del **lápiz** para editar la expresión del campo **Para**.
   - Nombre el script *getValidatorEmail*.
   - En el editor de scripts, introduce el siguiente script:
   
   <pre>
   def processApi = apiAccessor.getProcessAPI();
   def identityApi = apiAccessor.getIdentityAPI();

   //Get the TaskInstance
   def humanTaskInstance = processApi.getHumanTaskInstances(processInstanceId, "Validate request", 0, 1).get(0);

   //Get the user id assigned to the task review request
   def reviewRequestAssignedId = humanTaskInstance.getAssigneeId();

   //Get the review request email
   String reviewRequestAssignedEmail = "";
   
   if(reviewRequestAssignedId >0){
	  reviewRequestAssignedEmail = identityApi.getUserContactData(reviewRequestAssignedId, false).getEmail();
   }
   
   else{
	  reviewRequestAssignedEmail = "william.jobs@acme.com"
   }
   
   return reviewRequestAssignedEmail;</pre>

   - Pasa a la página siguiente
   - Pon como asunto *Una solicitud pendiente de aprobación*.
   - Haz clic en **Finalizar**.

1. Ejecuta el proceso para probarlo:
   - Asegúrate de que el servidor FakeSMTP sigue funcionando.
   - Haz clic en **Run** y crea un nuevo caso
   - Después de 5 segundos, verifica FakeSMTP. Se ha enviado un correo electrónico.

[Siguiente ejercicio: agregar restricciones a un contrato](08-data-contract-constraints.md)
