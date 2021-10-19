---
title: Ejercicio 6 - Crear una aplicación de gestión de vacaciones
---

## Objetivo

El objetivo de este ejercicio es proporcionar a los usuarios una aplicación que permita rastrear y crear solicitudes de vacaciones.

## Resumen de las instrucciones

Dupliqua el diagrama de proceso del ejercicio anterior para crear una versión *6.O.0*.

Abre el UI Designer y crea una nueva **Página de aplicación** llamada *SeguimientoDeSolicitud* que permite el seguimiento de las solicitudes de vacaciones iniciadas por el usuario conectado.

Esta página contiene un contenedor múltiple que enumera las solicitudes de vacaciones abiertas. Para cada solicitud, se muestran la fecha de inicio, el número de días y el estado de aprobación.

Agrega un enlace al formulario de instanciación para iniciar una nueva solicitud de vacaciones.

Cree una nueva aplicación y agregue la página *SeguimientoDeSolicitud*.

Acceda a la aplicación recién creada utilizando la URL única generada.

## Instrucciones paso a paso

1. Dupliqua el diagrama de proceso del ejercicio anterior para crear una versión *5.O.0*.

1. Crea una página de aplicación:
    - En el Studio, haz clic en el botón **UI Designer**
    - Haz clic en el botón **Crear**
    - Selecciona **Página de aplicación**
    - Ingresa el nombre *SeguimientoDeSolicitudes*
    - Haz clic en **Crear**
   
   ![crear una página de aplicación](images/ex06/ex6_01.png)
   
    - La vista del diseñador ahora debería mostrarse  

1. Agrega un título a tu página:
    - Arrastra el widget **Título** (A) desde la paleta y colócalo en la parte superior de la página (B)
    - Selecciona el widget
    - En el panel derecho, ingresa *Aplicación de gestión de solicitudes de vacaciones* en el campo **Texto**
    - Selecciona la opción **centrado** para el parámetro **Alineación**  
   
   ![agregar widget título](images/ex06/ex6_02.png)

1. Crea una variable para listar las solicitudes de vacaciones:
    - Haz clic en el ícono **Modelo de datos** ![icone-datamodel](images/ex06/ex6_00.png)
    - Arrastra y suelta *SolicitudVacaciones* en la página
    - Mantenga el nombre predeterminado: *solicitudVacaciones*
    - En la sección **Consultas de "Buscar (Find)" en un atributo**, selecciona *solicitanteId*
    - Haz clic en el botón **Guardar**
    
    Se genera automáticamente un contenedor múltiple con una tabla que contiene los atributos del objeto SolicitudVacaciones.

    ![contenedor multiple](images/ex06/ex6_13.png)

1. Sustituir el subtítulo *SolicitudVacaciones* del contenedor y las etiquetas : 
   - Nómbralo *Seguimientio de solicitudes*
   - Selecciona la opción **Nivel 4** para el parámetro **Nivel del título**.
   - Selecciona la opción **centrado** para el parámetro **alineación**. 
   - Selecciona el widget Tabla
   - En el panel de la derecha, en el campo **Cabeceras**, borra *Solicitante Id*.
   - Sustituye *Fecha Inicio* por *Fecha de inicio* y *Número Dias* por *Número de días*.
   
1. Muestra la información en las columnas de la tabla de una manera más clara:
    - En el panel de la derecha, en el campo **Claves de columna**, elimina *solicitanteId*
    - Borra el widget Input *SolicitanteId* en el contenedor de detalles porque esta información no es útil.

1. Selecciona el widget *Fecha Inicio* y cambia las siguientes propiedades:
   
      Propiedad | Valor
      --------- | ------
      Etiqueta | Fecha de inicio
      Formato técnico de la fecha | dd/MM/yyyy
      Placeholder | dd/mm/aaaa
      Mostrar el botón de hoy | no
      
1. Selecciona el widget *Número de días* y cambia las siguientes propiedades :

      Propiedad | Valor
      --------- | ------
      Etiqueta | Número de días
      Placeholder | Número de días de vacaciones
      Valor mínimo | 1

   - Guarda la página
   - La página debería verse así:
   
   ![página de aplicación en el UI Designer](images/ex06/ex6_04.png)
   
   - Puedes obtener una vista previa de la página en cualquier momento haciendo clic en **Vista previa**
   
   > Consejo: si está conectado al portal en el mismo navegador, se mostrarán las solicitudes de vacaciones reales.

1. Agrega un nuevo widget de tipo **Link**:
   - Arrastra un widget de tipo **Link** desde la paleta y colócalo entre los dos títulos
   - En el campo **Texto** introduce *Crear una nueva solicitud*.
   - En el campo **Tipo**, selecciona **Formulario de instanciación del proceso**
   - En el campo **Nombre del proceso** agrega *SolicitudVacaciones*.
   - En el campo **Versión del proceso** agrega el número de la versión *6.0.0*
   - En el campo **Alineación** selecciona **centrado**
   - En el campo **Estilo** selecciona **Primario**
   - Guarda la página
    
   Ahora vamos a desplegar la aplicación en el portal desde Bonita Studio.

1. Agrega un nuevo descriptor de aplicación:
    - En Bonita Studio, en el **Explorador de proyectos** a la izquierda de la ventana, despliega **Páginas/Formularios/Layouts** para verificar la presencia de todas las páginas y formularios
    - En el menú ![Nuevo](images/ex06/ex6_16.png) selecciona **Descriptor de aplicación**, haz clic en **Nueva**. Un fichero .xml se crea automaticamente.
    - Haz clic en ![Añadir descriptor app](images/ex06/ex6_14.png)
    - Ingresa *solicitud-vacaciones* en el campo **Token de la aplicación**
    - Ingresa *Aplicación de solicitudes de vacaciones* en el campo **Título dinámico**
    - Haz clic en **Añadir**
    
    ![titulo aplicacion](images/ex06/ex6_15.png)
    
1. Crea una nueva aplicación
    - En el menú de navegación, haz clic en **Añadir menú de una página** (A)
    - Ingresa *Seguimiento de las solicitudes de vacaciones* en el campo **Menú**
    - Selecciona la página *custompage_SeguimientoDeSolicitud* en el campo **Página de aplicación** (B)
    - Ingresa *solicitud-vacaciones* en el campo **Token** (C).
    
      ![creación de una aplicación](images/ex06/ex6_07.png) 
    
1. Define la página *Aplicación de solicitudes de vacaciones* como página de inicio de la aplicación: 
    - Selecciona el token *solicitud-vacaciones* en el menú **Página de inicio**
    - Haz clic en el enlace para probar la aplicación (A)
    - Una ventana se abre para confirmar el despliegue. Haz clic en el botón **Desplegar**
   
 Vas a poder acceder a la aplicación en el navegador directamente

   
   ![vista previa de la aplicación](images/ex06/ex6_08.png)


**¡Ya esta!**

¿Quieres ir más allá? Sigue la siguiente iteración del proyecto.
Próximo ejercicio: [agregar un temporizador al proceso](07-timer.md)

