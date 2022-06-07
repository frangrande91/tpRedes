# Crear un modelo Cliente Servidor utilizando TCP / IP Sockets a partir de los siguientes puntos:

## 1) Servidor:

a) Utilizar el puerto 3000.

b) Utilizar Telnet para emular un cliente, probar conexiones y enviar / recibir datos.

c) Los datos enviados deben ser texto y se deben mostrar tanto en la consola del
cliente como del servidor.

d) Testear el servidor desde una aplicación Telnet para celular o desde una máquina
de otra red.

e) Utilizar un nombre de host en lugar de la IP para enviar información.

f) El servidor debe poder responderle al cliente.

g) Si el usuario presiona la ‘x’ se debe cerrar la conexión. Esto debe hacerse en el
cliente y en el servidor.

## 2) Cliente:

a) Debe poder conectarse al servidor por medio de la IP y el puerto. Estos datos se deben ingresar por consola (configurables). Puede haber más de un cliente corriendo.

b) Manejar los errores si el usuario ingresa mal la IP y el puerto y mostrar un mensaje.

c) Mostrar el estado de la conexión paso a paso.

d) El cliente debe poder enviar y recibir datos.

## Preguntas:

1) ¿Qué es un Puerto?
2) ¿Cómo están formados los Endpoints?
3) ¿Qué es un Socket?
4) ¿A qué capa del modelo TCP / IP pertenecen los Sockets? ¿Por qué?
5) ¿Cómo funciona el modelo Cliente Servidor con TCP / IP Sockets?
6) ¿Cuáles son las causas por las cuales la conexión puede fallar?
7) ¿Cuáles son las diferencias entre Sockets TCP y UDP?
8) ¿Cuál es la diferencia entre Sync y Async Sockets?


## 1. ¿Qué es un puerto?
Un puerto es una interfaz a través de la cual se pueden enviar y recibir los diferentes tipos de datos. Los números de puerto se indican mediante una palabra de un procesador de 16 bits, o sea, de 2 bytes (16 bits) y su valor varía entre 0 y 65535. Nos permite comunicar uno o varios dispositivos informáticos para poder enviar o recibir información y establecer comunicaciones entre dichos dispositivos.

## 2. ¿Cómo están formados los endpoints?
Un endpoint es cualquier dispositivo que proporciona un punto de entrada a los activos y aplicaciones de la empresa y representa una posible vulnerabilidad de ciberseguridad. 
Para mantener a la empresa protegida de cualquier amenaza que atente contra sus datos, ya no es suficiente con el uso del antivirus tradicional y deben añadirse las soluciones Endpoint formados por diversos elementos como sistemas operativos, licencias anti-virus o cliente VPN, todos ellos actualizados, donde los dispositivos que no cumplan con las reglas establecidas son controlados por el sistema de seguridad y puestos en cuarentena.
 
## 3) ¿Qué es un Socket? 
Un socket es un puerto lógico y constituye el mecanismo para la entrega de paquetes de datos provenientes de la tarjeta de red a los procesos o hilos apropiados. Un socket queda definido por un par de direcciones IP local y remota, un protocolo de transporte y un par de números de puerto local y remoto. Es un proceso o hilo existente en la máquina cliente y en la máquina servidora, que sirve en última instancia para que el programa servidor y el cliente lean y escriban la información que será transmitida por las diferentes capas de red.

## 4) ¿A qué capa del modelo TCP / IP pertenecen los Sockets? ¿Por qué? 
Los sockets pertenecen a la capa de transporte (nivel 4), ya que en esta capa son formados por la dirección IP (del host), el protocolo de transporte utilizado (TCP o UDP) y el puerto por el que se va a comunicar, identificando cada comunicación independiente formada por cada aplicación. 

## 5) ¿Cómo funciona el modelo Cliente Servidor con TCP / IP Sockets?
En el modelo Cliente Servidor, el host comunica mediante los sockets su IP como identificación, el protocolo utilizado para comunicarse, y el puerto que va a utilizar; y como cada aplicación, se va a comunicar por un puerto diferente todos se pueden comunicar al mismo tiempo permitiendo la multiplexación mediante la cual una aplicación puede enviar información al servidor y esperar directamente una respuesta por el puerto que está utilizando, identificación que realiza el sistema operativo para determinar para qué aplicación llega cada respuesta. Para ésto, java nos provee dos clases: Socket para implementar la conexión desde el lado del cliente y ServerSocket para manipular la conexión desde el lado del servidor.

## 6) ¿Cuáles son las causas por las cuales la conexión puede fallar? 
La conexión puede fallar por diferentes motivos como:
- El puerto especificado ya está siendo utilizado.
- El servidor no se ha iniciado o está caído.
- El cliente no puede acceder al servidor. Puede estar detrás de un cortafuegos que impida la conexión.
- El usuario no tiene permisos o privilegios para realizar una operación.


## 7) ¿Cuáles son las diferencias entre Sockets TCP y UDP? 
- Los Sockets TCP o Stream son los más utilizados, hacen uso del protocolo TCP, el cual nos provee un flujo de datos bidireccional, secuenciado, sin duplicación de paquetes y libre de errores.
- Los Sockets UDP o Datagram hacen uso del protocolo UDP, el cual nos provee un flujo de datos bidireccional, pero los paquetes pueden llegar fuera de secuencia, pueden no llegar o contener errores. Se llaman también sockets sin conexión, porque no hay que mantener una conexión activa, como en el caso de sockets stream. Son utilizados para transferencia de información paquete por paquete.
- UDP necesita que le entreguemos paquetes de datos que el usuario debe construir, mientras el TCP admite bloques de datos (cuyo tamaño puede ir desde 1 bytes hasta muchos K bytes, dependiendo de la implementación) que serán empaquetados de forma transparente antes de ser transmitidos.
- Tanto los paquetes de datos UDP como los segmentos TCP (este es el nombre que reciben los paquetes TCP) pueden perderse (muy rara vez llegan al destino correcto con errores). Si un paquete se pierde el UDP no hace nada. Por el contrario, si un segmento se pierde el TCP lo retransmitirá, y este proceso durará hasta que el segmento ha sido correctamente entregado al host receptor, o se produzca un número máximo de retransmisiones.
- En aplicaciones en tiempo real, en el UDP controlamos qué datos viajan en cada paquete. En el TCP esto no es posible porque el empaquetamiento es automático. De hecho, el TCP espera un tiempo prudencial a tener bastantes datos que transmitir antes de enviar un segmento ya que esto ahorra ancho de banda. Si es importante que los datos tarden el mínimo tiempo posible en llegar al receptor el UDP es la mejor opción. En este sentido se dice que el UDP tiene una menor latencia que el TCP.

## 8) ¿Cuál es la diferencia entre Sync y Async Sockets?
Los Sockets Sync o Sincrónicos se abren de forma única para cada conexión en un solo hilo de ejecución, se escribe la solicitud y se imprime el resultado.
Los Sockers Async o Asíncronos se abren en una cantidad igual a la de los hilos que se ejecutan (siempre hay N sockets para N hilos) y los maneja un bucle de control principal.
