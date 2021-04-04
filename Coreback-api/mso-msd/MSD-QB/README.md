# Plantilla MSD Version 1.0.0

- Plantilla de estructura para los microservicio de datos (**MSD**)
- EndPoint: 
 - nombreProyecto/v1
 - MSD-QB/v1
 - para su correcto funcionamiento, los paquetes deben iniciar con mx.grupoelektra



- Agregar en le VM del ide la siguiente linea para poner el  __Profile__  de  **DEV**

```sh
-Dspring.profiles.active=dev
```


Identificar la secci�n de RUN en la parte superior derecha del IDE 
- El input de opci�n Open Edit Run/Debug configuration dialog 
- Abre una ventana emergente, identificar en esta pantalla la aplicacion 
- Identificar la pesta�a de Configuration > Enviroment 
- Identificar la opci�n de VM Options 
- Ingresar en el imput la siguiente linea  `-Dspring.profiles.active=dev`
- Dar click en Apply
- Dar click en Ok


Identificar el proyecto a agregar la configuracion de desarrollo 
- Click derecho al proyecto 
- Run As > Run Configurations� 
- Abre una ventana emergente, identificar en esta pantalla Spring Boot App 
- Seleccionar el proyecto 
- Identificar la pesta�a de Arguments 
- Identificar la opci�n de VM arguments 
- Ingresar en el imput la siguiente linea  `-Dspring.profiles.active=dev`
- Dar click en Apply
- Dar click en Close


- Definicion de estructura

```
|- MSD-QB/			# Carpeta principal.
|- src/main/java			# Carpetas donde se encuentra el codigo Java
|- src/main/resources			# Carpeta de documentos de configuracion.
|- MSD-QB/pom.xml		# Gestor de dependencias.
```
- **Nota:** El archivo  _Pom_  no tiene que ser modificado

- Definicion de codigo

```
|- common     		# Clases de utileria, que son reutilizables en el flujo, Sufijo: Common.
|- controller       	# Capa de comunicacion con terceros, Sufijo: Controller.
|- configuration  	# Capa de configuracion, Sufijo: Configuracion.
|- dao			# Gapa de persistencia de datos, Sufijo: Dao.
|- service		# Capa de logica de negocio, Sufijo: Service.
|- model		# Modelos de datos, Sufijo: Model.
```
- [x] **configuration**: Configuracion realizada ya no modificar
- [x] **.properties**: Cambiar la configuracion de la base de datos
- [x] **dao**: Capa solo tener consultas y regresar a la capa de servicios el cursor y realizar la logica es esta
- [ ] **model**: agregar modelos necesarios


Los ejemplos son todos los que tienen en el prefijo *Test*, es un ejemplo basico de la linea a seguir en el desarrollo 

- Ejecutar test **/MSD-QB/v1/Test**
- Metodo GET

- **Nota:** Eliminar todo lo que tenga el prefijo **Test**

