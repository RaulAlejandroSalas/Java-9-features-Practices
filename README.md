## Reactive Programming Java Version 9

La programacion reactiva esta orientada a el trabajo con flujos de datos y la propagacion de cambios, por lo que podemos tener
una secuencia de eventos ordenados en el tiempo. Con el paradigma imperativo se realizan pulls y se procesan los elementos de
las estructuras de datos de manera sincrona sin embargo con el paradigma reactivo se crean cosas y se hacen push a flujos de datos.

## Estructura del Repositorio:
* Creacion y observacion de recurso con  RxJava
* Operadores
* Unit testing
* Akka streams en ambiente reactivo
* Constriuir una simple applicacion reactiva

### Existen implementaciones disponibles para java:
* RxJava 2.x: Implementada por Netflix.
* Akka: Es un conjunto de herramientas para construir aplicaciones de alta concurrencia, distribuidas y con alta tolerancia a
    		fallos.
 * Reactive Stream: Standard.
 * Reactor: Es un Framework de Java implementado por Pivotal y construye directamente Flujos Reactivos.
 * Spring Framework 5.0: Posee caracteristicas para construir y manipular Flujos Reactivos (Netty Server).
 *  Ratpack: Conjunto de librerias sobre Netty para crear aplicaciones de alta disponibilidad sobre protocolo HTTP.
 * Akka: Es una herramienta para construir aplicaciones usando el Patron actor para Java o Scala, con la interoperabilidad de
    				 Akka Streams.
    
Basicamente los datos viajan a traves de un flujo, este flujo es conocido como source of infomation(Recurso de informacion) es 
la entidad encargada de emitir los datos. La entidad encargada de procesar los datos en el flujo son los Consumers, es importante 
aclarar que los Consumers no hacen pull de los datos si no los datos son pushed a los Consumers.
 
Para que los consumers puedan recibir datos desde la entidad Recurso de Informacion esta debe subscribirse y a partir de ese instate
comenzara a recibir los datos desde el flujo. 
 
    
### Las aplicaciones reactivas definen 4 principios principales:
 * Responsive.
 * Elastic.
 * Resilient(Scalable).
 * Message Driven.
  
### Reactive JVM - Reactive Elements:
* Source Information: Publisher<T>
* Consumer: Subscriber<T>
* Subscription: Subscription
* Source Information both Consumer: Processor<T,R>

#### Publisher Interface:
   ```java
     public interface Publisher<T>{
         public void subscribe(Subscriber<? super T> s);
     }
   ```
       

#### Subscriber Interface.
   ```java
     public interface Subscriber<T>{
        public void onSubscribe(Subscription s);
        public void onNext(T t);
        public void onError(Throwlable t);
        public void onComplete();
     }
   ```
  

#### Subscription Interface.
   ```java
     public interface Subscription{
        public void request(long l);
       	 public void cancel();
     }
   ```


#### Consumer Interface.
   ```java
     public interface Processor<T,R> extends Subscriber<T>,Consumer<R>{}
   ```
   
### Reglas que debe cumplir un Publisher:
* Si el Publisher falla este debe enviar una signal de onError
* Si el Publisher termina correctamente en el caso de que el flujo sea finito debe enviar una signal de onComplete
* Si una Subscription es cancelada eventualmente el Publisher debe parar de enviar signals
* Publisher.subscribe() puede ser llamado en cualquier momento pero desde diferentes subscriber
* Un Subscriber debe pedir una nueva signal a traves de Subscription.request(long n) .

