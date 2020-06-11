---
title: Ejercicio 5 - Notificación a través de un conector
---

## Objetivo

El objetivo de este ejercicio es tratar una interacción entre el proceso y un sistema externo a través de un conector. Aquí estamos interesados en la notificación del resultado de la solicitud de licencia a través de un conector de correo electrónico.

> ⚠ Dependiendo de la configuración de su red, su firewall o la configuración de seguridad de su servidor de correo electrónico, es posible que no esté autorizado para enviar un correo electrónico desde Bonita.
> Para evitar estas limitaciones técnicas, este ejercicio se realizará con un software que simule un servidor de correo electrónico (FakeSMTP).

## Resumen de las instrucciones

Obtenga y inicie el servidor [FakeSMTP](http://nilhcem.github.com/FakeSMTP/downloads/fakeSMTP-latest.zip).

Duplique el diagrama de proceso del ejercicio anterior para crear una versión *3.1.0*.

Agregue un conector para enviar correos electrónicos en tareas automáticas *Notificar aprobación* y *Notificar rechazo*. Estos enviarán un correo electrónico al solicitante con el estado de validación de su solicitud.

El siguiente código se usará para recuperar el correo electrónico del solicitante en el conector:

``` groovy
BonitaUsers.getProcessInstanceInitiatorProfessionalContactInfo
(apiAccessor,processInstanceId).email
```
## Instrucciones paso a paso

1. Implementación de FakeSMTP:
    - Obtenga el binario de FakeSMTP de esta URL: [http://nilhcem.github.com/FakeSMTP/downloads/fakeSMTP-latest.zip](http://nilhcem.github.com/FakeSMTP/downloads/fakeSMTP-latest.zip)
    - Abre el archivo `fakeSMTP-latest.zip`
    - Inicie FakeSMTP haciendo doble clic en el archivo JAR o ejecutando el siguiente comando: `java -jar fakeSMTP-2.0.jar`
    - Una vez que se muestra la interfaz gráfica de FakeSMTP, configure el puerto de escucha en *2525* y haga clic en el botón **Iniciar el servidor**

1. Duplique el diagrama de proceso del ejercicio anterior para crear una versión *3.1.0*

1. Pruebe el conector de envío de correo electrónico para obtener la configuración SMTP correcta:
    - Navegue en el menú **Desarrollo / Conectores / Probar conector ...** en la barra superior de Bonita Studio
    - Seleccione un conector **Correo electrónico (SMTP)** del filtro o de la categoría **Mensajeria**
    - Haga clic en el botón **Siguiente**
    - Complete los siguientes parámetros de conexión:
   
    Propiedad | Valor
    --------- | ------
    Host SMTP | *localhost*
    Puerto SMTP | *2525* (el puerto especificado en FakeSMTP)
    SSL (en la pestaña **Seguridad**) | desmarcado
   
    - Haga clic en el botón **Siguiente**
    - Ingrese correos electrónicos (no necesariamente existentes) como destinatario y remitente
    - Haga clic en el botón **Siguiente**
    - Ingrese *Bonita test* como asunto
    - Haga clic en el botón **Prueba**
    - Aceptar sin verificar dependencia
    - Debería aparecer un mensaje similar al siguiente, haga clic en el botón **Aceptar**:
   
   ![mensaje de advertencia de salida no serializable](images/ex05/ex5_00.png)
   
    - Asegúrese de que FakeSMTP reciba el correo electrónico como se ilustra abajo:
   
   ![Fake SMTP con un mensaje recibido](images/ex05/ex5_01.png)
   
    - Una vez que se valida la configuración, haga clic en ![botón guardar](images/ex05/ex5_02.png)
    - Nombre la configuración *configEmail* y guárdela
    - Cerre la interfaz de prueba del conector
   
1. Agregue un conector para enviar un correo electrónico en la tarea *Notificar aprobación*:
    - Seleccione la tarea *Notificar aprobación*
    - Navegue en la pestaña **Ejecución / Conectores entrada**
    - Haga clic en **Agregar \ ...**
    - Seleccione un conector de tipo **Correo electrónico**
    - Haga clic en el botón **Siguiente**
    - Especifique *enviarCorreoAprobacion* como nombre
    - Ir a la página siguiente
    - No hay que rellenar los parámetros de la página
    - Haga clic en ![botón cargar](images/ex05/ex5_03.png)
    - Seleccione la configuración *configEmail*
    - Ir a la página de configuración del destinatario
    - Ingrese *rh@acme.com* como dirección de correo electrónico en el campo del remitente **De**
    - Use el ícono **lápiz** para editar la expresión en el campo del destinatario **A**
    - Cambie el **Tipo de expresión** a **Script**
    - Nombre el script *recupEmailSolicitante*
    - Pegue el código siguiente en el área de edición del script:
   
   ```
   groovy
   BonitaUsers.getProcessInstanceInitiatorProfessionalContactInfo (apiAccessor, processInstanceId).email
   ```
    - Haga clic en el botón **Aceptar** para cerrar el editor de scripts
    - Ir a la página siguiente
    - Especifique *Solicitud de vacaciones aprobada* como asunto
    - Haga clic en **Finalizar**
   
1. Agregue un conector para enviar correo electrónico a la tarea *Notificar rechazo*:
    - Repita el paso anterior nombrando el conector *enviarCorreoRechazo* y especificando *Solicitud de vacaciones rechazada* como asunto
   
   Alternativamente, puede usar la funcionalidad que le permite copiar un conector configurado en una tarea a otra tarea.
   
1. Probar el proceso:
    - Ejecute el proceso dos veces para probar las diferentes rutas y asegurarse de que FakeSMTP envíe e intercepte los correos electrónicos

[Ejercicio siguiente: creación de aplicaciones](06-applications.md)
