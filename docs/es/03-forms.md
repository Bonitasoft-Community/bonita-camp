---
title: Ejercicio 3 - Crear formularios
---

## Objetivo

El objetivo de este ejercicio es proporcionar formas fáciles de usar y adecuadas para la ejecución del proceso.

## Resumen de las instrucciones

Duplique el diagrama de proceso del ejercicio anterior para crear una versión *2.1.0*.

Crea los siguientes formularios:
- Un formulario de creación de instancias de proceso a nivel de pool que permite inicializar los atributos *fechaInicio* y *numeroDias* de la variable empresarial *solicitud*
- Se aprueba un formulario de pasos que permite mostrar la información del solicitante y los datos *fechaInicio* y *numeroDias* en modo de solo lectura y luego alimentar los datos *estaAprobado*

## Instrucciones paso a paso
1. Duplique el diagrama de proceso del ejercicio anterior para crear una versión *2.1.0*
1. Crea un formulario de instanciación:
   - Seleccione el pool de procesos
   - Navegue en la pestaña **Formulario de ejecución / instanciación**
   - Haga clic en el icono **Lápiz** en el campo **Formulario de destino**
   
    ![creación de un formulario](images/ex03/ex3_01.png)
   
   Esto va a abrir el UI Designer en su navegador web con un nuevo formulario generado automáticamente a partir de la definición del contrato de instanciación.
1. Cambie el nombre del formulario:
   - Use el campo de texto en la parte superior de la pantalla para cambiar el nombre del formulario de *newForm* a *ingresarSolicitudVacaciones* (este es un nombre técnico, por lo que debe omitir espacios, acentos y otros caracteres especiales)
   - Haga clic en el botón **Guardar**

1. Cambie el título del formulario:
   - Seleccione el widget *Solicitud* en la parte superior del formulario.
   - En la sección a la derecha de la pantalla, edite las siguientes propiedades:

   Propiedad | Valor
   --------- | ------
   Texto | *Ingrese una solicitud de vacaciones*
   Nivel de título | Nivel 2
   Alineación | centrado

1. Cambie el widget *Fecha Inicio* :
   - Seleccione el widget *Fecha de inicio* y edite las siguientes propiedades:

   Propiedad | Valor
   --------- | ------
   Etiqueta | Fecha de inicio
   Formato de fecha técnica | dd/MM/yyyy
   Placeholder de la fecha | Ingrese una fecha (dd/mm/yyyy)
   Etiqueta del botón Hoy | Hoy

1. Cambie el widget *Numero Dias* :
   - Seleccione el widget *Numero Dias* y edite las siguientes propiedades:

   Propiedad | Valor
   --------- | ------
   Etiqueta | Número de días
   Placeholder | Número de días de vacaciones
   Valor mínimo (no debe confundirse con la propiedad **Longitud mínima**) | 1
      

1. Elimine los valores iniciales de los campos (esto permitirá mostrar los placeholders en la representación final):
   - En la parte inferior de la pantalla, debajo de la pestaña **Variables**, haga clic en el icono **Lápiz** ubicado a la derecha de la línea que contiene la variable *formInput*
   - Reemplace el valor JSON con esto:
   ```json
   {
     "solicitudInput" : {
       "fechaInicio" : null,
       "numeroDias" : null
     }
   }
   ```

1. Cambie el widget *Submit* :
   - Seleccione el widget *Submit*
   - Cambiar su etiqueta por *Enviar*

1. Compruebe el formulario:
   - Compruebe que el formulario se ve así en el editor:
   
    ![formulario en el UI Designer](images/ex03/ex3_05.png)
   
   - Haga clic en el botón **Guardar** en la parte superior de la pantalla
   - Haga clic en el botón **Vista previa** en la parte superior de la pantalla
   - Compruebe que la vista previa se ve así:
    
     ![vista previa de un formulario](images/ex03/ex3_06.png)
   
   Tenga en cuenta los siguientes puntos en la vista previa:
   - El widget con el error no es visible
   - El botón *Enviar* está deshabilitado de forma predeterminada (esto se debe a la validación proporcionada por el contenedor del formulario)
   - El botón *Enviar* se activa cuando el contenido del formulario es válido
 
> **Nota:** no es posible enviar el formulario desde la vista previa, incluso cuando este último es válido.
 
1. Cierre la ventana de vista previa.
 
1. Cree un formulario para el paso *Validar solicitud*:
   - En Bonita Studio, seleccione el paso *Validar solicitud*
   - Navegue en la pestaña **Ejecución / Formulario**
   - Haga clic en el icono **Lápiz** en el campo **Formulario de destino** para abrir un nuevo formulario en el UI Designer 
   - Responda **Sí** a la pregunta sobre cómo agregar widgets de solo lectura
 
1. Cambie el nombre del formulario:
   - Desde el UI Designer, cambie el nombre del formulario a *validarSolicitudVacaciones* y guárdelo
 
1. Recupera información sobre el solicitante
   - Haga clic en el botón **Crear una nueva variable** para definir una variable con las siguientes propiedades:
   
   Propiedad | Valor
   --------- | ------
   Nombre | *solicitante*
   Tipo | **External API**
   URL del API | `../API/identity/user/{% raw %}{{solicitud.solicitanteID}}{% endraw %}`

1. Cambie el título del formulario
    - Seleccione el widget **Título** (Title) ubicado en la parte superior del formulario
    - Configure el widget de la siguiente manera:

   Propiedad | Valor
   --------- | ------
   Texto | Validar una solicitud de vacaciones
   Nivel de título | Nivel 2

1. Borre el widget *Solicitante ID* y coloque un widget para presentar el nombre y apellido del solicitante:
    - Arrastre un widget **Texto**
    - Configure el widget de esta manera:

   Propiedad | Valor
   --------- | ------
   Texto | `<b>Solicitante :</b> {% raw %}{{solicitante.firstname}} {{solicitante.lastname}}{% endraw %}`

1. Agregue un widget para rechazar la solicitud:
    - Arrastre un widget **Botón** y agréguelo al contenedor del formulario (área delimitada por una línea gruesa de puntos)
    - Configure el widget de esta manera:

   Propiedad | Valor
   --------- | ------
   Ancho | 6
   Etiqueta | Rechazar
   Alineación | derecha
   Estilo | danger
   Datos enviados al hacer click  | `{"solicitudInput":{"estaAprobado":false}}`
   Valor de la respuesta fallida  | `formOutput._submitError`
   Dirección URL de destino en éxito | `/bonita`

1. Borre la casilla *Está aprobado* y el botón *Submit*

1. Añade un widget para aprobar la solicitud
    - Arrastre un widget **Botón** al área "6 columnas" a la derecha del botón *Rechazar*
    - Configure el widget de esta manera:

   Propiedad | Valor
   --------- | ------
   Etiqueta | Aprobar
   Estilo | success
   Datos enviados al hacer click | `{"solicitudInput":{"estaAprobado":true}}`
   Valor de la respuesta fallida  | `formOutput._submitError`
   Dirección URL de destino en éxito | `/bonita`


1. Compruebe el formulario :
   - Asegúrese de que el formulario se vea así:
      
       ![Validación / rechazo de la solicitud de licencia](images/ex03/ex3_08.png)

1. Guarde el formulario:
   - Use el botón **Guardar** en el centro superior de la pantalla para guardar el formulario

1. Pruebe la ejecución del proceso:
   - Inicie la ejecución del proceso a través de Bonita Studio
   - Valide, a partir del historial de casos, que se ha seguido el camino correcto hasta el final del proceso

[Ejercicio siguiente: definición de los actores](04-actors.md)
