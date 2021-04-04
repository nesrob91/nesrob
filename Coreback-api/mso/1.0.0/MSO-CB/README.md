# Plantilla MSD Version 1.0.0

- Plantilla de estructura para los microservicio orquestador (**MSO**)
- EndPoint: 
 - nombreProyecto/v1
 - MSO-CB/v1



- Agregar en le VM del ide la siguiente linea para poner el  __Profile__  de  **DEV**

```sh
-Dspring.profiles.active=dev
```
- la bandera `jwt.active` es para poder pasar con o sin autentificaci�n 


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


Los ejemplos son todos los que tienen en el prefijo *Test*, es un ejemplo basico de la linea a seguir en el desarrollo 

- Ejecutar test **/MSO-CB/v1/Test**
- Metodo GET
- El test tiene un ejemplo de como consumir otro mso internamente por medio de un masterkey



