# Proyecto de springboot👌👍
[![N|Solid](https://www.utn.edu.ar/images/logo-utn.png)](https://www.utn.edu.ar/es/)
## 📚 Ingeniería Electrónica en UTN FRBA

¡Bienvenido a este emocionante proyecto en progreso! Aquí en la UTN FRBA, estamos comprometidos con la excelencia en la Ingeniería Electrónica y este proyecto tiene como finalidades:

- 🎓 Mostrar los conocimientos adquiridos.
- 🌐 Solucionar el problema de la fragmentación de información de las diferentes materias de Ingeniería Electrónica.
- 🧠 Aumentar la solidez de conocimientos a través de una plataforma operativa.

# Version funcional.
En este momento ahi una version del proyecto funcionando en servidor.

Aplicacion corriendo sobre  `Azure Web Aplication`

>  [`Puedes visualizarlo desde aquí`](https://proyectmateriasutnelectronica.azurewebsites.net/)

> `Estamos mejorando progresivamente la aplicacion aun esta en desarrollo`.

Para la etapa de deploy se utilizo `--GitActions`

Este proyecto en progreso tiene como finalidades
- Muestra de los conocimientos adquiridos
- Solucionar el problema de la fragmentacion de informacion de las diferentes materias de ing electronica
- Aumentar la solides de conocimientos atraves de una plataforma operativa.
# Tecnologias implicadas
* Springboot Mail
* Springboot Security
* Thymeleaft
* Markdown
* Java 17
* JavaScript
* Mysql
* GitActions
* Azure Web App
* Whatssapp API Facebook business


 # Diagramas

![image](https://github.com/fabian3117/programaAnaliticoElectronica/assets/34560661/1869d5ea-1cce-4855-b531-b63f24ed086c)

![image](https://github.com/fabian3117/programaAnaliticoElectronica/assets/34560661/fac56158-7653-4d13-ad20-26792e2a51ef)


# Partes Operativas
* Muestra de programa analitico de la carrera.
* Visualizacion del programa analitico de las materias asi como resumenes.
* Envio del material al correo electronico.

#  Próximas Actualizaciones
* Implementacion en un servidor.
* Portal de carga de archivos con metodos de autenticacion de springboot security.
* Mejoras en el sistema de intercambio de archivos.
* Implementacion del envio por whatssapp del material.

# Build

**Obtención del Token para WhatsApp**

Para la funcionalidad de envío a WhatsApp, se requiere la obtención del token y un numero asociado. Puedes obtenerlos a través de la plataforma de Meta Developers.
>  [Puedes obtenerlos a través de la plataforma de Meta Developers](https://developers.facebook.com/docs/whatsapp/cloud-api)

**Introducción del Token en `applications.properties`**

Una vez obtenidos, se debe proceder a introducirlo en el `applications.properties`, como se muestra a continuación:
```
Facebook.Whatssapp.APIKEY=****
Facebook.Whatssapp.numberServer=****
```

Para la visualización local del proyecto, se requiere configurar `applications.properties` con los datos para la conexión MySQL.
Una ves configurados se debe inicializar la base de datos en la direccion:
```
/inicializar
```
> Nota El proyecto corre por default en puerto `--port=8080` .
Direccion principal donde se puede visualizar la informacion:
```sh
localhost:8080/
```
Para el apartado del envío de correos se requiere su configuración en application.properties. En este ejemplo se visualiza la configuración para utilización de Gmail.
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=****@gmail.com
spring.mail.password=****
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.transport.protocol=smtp
spring.mail.properties.mail.smtp.from="${User}"
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
spring.mail.properties.mail.smtp.starttls.required=true
```

En este ejemplo se visualiza la configuracion para utilizacion de gmail.

> Se requiere clave para aplicación de Google. [Cómo obtener una clave para aplicaciones de Google](https://support.google.com/mail/answer/185833?hl=es-419).


## Pantallas 🖥️
🚀 **Pantalla de Inicio:** En este apartado se puede  explorar el programa analítico completo de la carrera. ¡Buena suerte! [Ir a la pantalla de inicio](http://localhost:8080/).


![image](https://github.com/fabian3117/programaAnaliticoElectronica/assets/34560661/b589d884-993e-4fcc-9261-04e921a50565)

> `http://localhost:8080/`

📘 **Información sobre Materia:** En este apartado se visualiza información detallada sobre la materia `Informatica 1`.


![image](https://github.com/fabian3117/programaAnaliticoElectronica/assets/34560661/b2cf0c49-cecb-4f65-9344-cc4cd654679d)


📧 **Ejemplo de Correo:** Visualizacion de ejemplo del correo donde se envia el material de la materia en este caso `Informatica 1`.

![image](https://github.com/fabian3117/programaAnaliticoElectronica/assets/34560661/d636d52d-4d23-475f-bd80-23d2f2e7dc9a).

📧 **Ejemplo de WhatsApp:** Visualización de ejemplo de un mensaje de `WhatsApp`.
![Screenshot_20230910-221818](https://github.com/fabian3117/programaAnaliticoElectronica/assets/34560661/6c4c84db-7e2c-4a0d-813b-3e64916232ca)


### ¡Más Actualizaciones en Camino! 💥

Mantenete al tanto del changelog para conocer las próximas mejoras del sistema. ¡Futuras actualizaciones que te van a sorprender, che! 🛠️🚀



