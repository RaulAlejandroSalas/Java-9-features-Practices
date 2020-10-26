## Reactive Programming Java Version 9

The Reactive Programming is oriented to the data flows work and the propagation of changes, so that we can to have a sequency of events sorted of the time. In the imperative paradigm the programs using the pulls operations and the datas are processing using sincronous programming, hawever with the Reactive Paradigm we have Sources Infomations where datas has been published by a Publisher and the programms or consumers can listen this data flow through Subscriptions of that.

## Repository Structure:
* Creation and observability of Sources Information with RxJava
* Operators(filter,map,flatMap,reduce,etc)
* Unit testing
* Akka streams with Reactive Environment
* Build a simple Reactive Application

### Availables implementations for Java:
* **RxJava 2.x**: Implemented by Netflix.
* **Akka**: Is a Set of Tools to build high concurrence applications,  distributed with high fault tolerance.
* **Reactive Stream**: JDK 8+ Standard.
* **Reactor**: Is a Java Framework implemented by Pivotal with that can be Reactive Data Flows.
* **Spring Framework 5.0**: Has features for build and handler Reative Data Flows (Netty Server).
* **Ratpack**: Set of libraries on Netty Server that allow the creations of Applications with high availability on HTTP Protocol.
* **Akka**: Can be used in the construction of the applications applying the Actor Pattern either for Java or Scala, bringing the possibility of the interoperability of Akka Streams.
  

Basically the data travels on a flow, this flow is known as Source Information. this entity has the resposibility to emit the data. The entities used for processing the flow are called Consumers. If we want to keep the correct comunication between Consumers and Publisher we have to create a Subscription, inmediatly the Consumers can be received the data flows.
    
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
       

#### Subscriber Interface:

```java
     public interface Subscriber<T>{
        public void onSubscribe(Subscription s);
        public void onNext(T t);
        public void onError(Throwable t);
        public void onComplete();
     }
```
  

#### Subscription Interface:

```java
     public interface Subscription{
        public void request(long l);
       	 public void cancel();
     }
```


#### Consumer Interface:
   
```java
     public interface Processor<T,R> extends Subscriber<T>,Consumer<R>{}
```
   
### Reglas que debe cumplir un Publisher:
* Si el Publisher falla este debe enviar una signal de onError
* Si el Publisher termina correctamente en el caso de que el flujo sea finito debe enviar una signal de onComplete
* Si una Subscription es cancelada eventualmente el Publisher debe parar de enviar signals
* Publisher.subscribe() puede ser llamado en cualquier momento pero desde diferentes subscriber
* Un Subscriber debe pedir una nueva signal a traves de Subscription.request(long n) .

## Functional Reactive Programming in Java
Se combina la programacion funcional y la programacion reactiva para escribir codigo rapido claro y facil de entender
usando lambdas y funciones puras.

## Introduction to RxJava2.x (https://github.com/ReactiveX/RxJava/wiki/Getting-Started)
Imaginamos que tenemos un flujo de touch events en el tiempo, la biblioteca RxJava provee tres estategias para realizar el consumo de estos datos:

* **Drop**:  En este caso el flujo de datos que no se consume es eliminado inmediatamente o sea si tenemos un flujo de datos de 1,2,3,4,5... y el consumer en la primera request pide 3 elementos, entonces recibira 1,2,3. Pero si este se demora en volver a solicitar los datos entonces estos datos que se habian generado anteriormente se perderan. 
* **Lastet**: Este caso funciona como un caching de los ultimos elementos en cada momento generados por el Publisher dando asi la posibilidad al Consumer de siempre tener los ultimos elemetos generados disponibles
* **Buffer**:  En este caso el Consumer recibira los datos desde un buffer creado por el Publisher dando la posibilidad de no perder datos.

RxJava2.x implementa Reactive Stream Specifications donde se pueden encontrar las siguientes analogias en cuanto a las interfaces respecto a la implementacion disponible para Java 9:

* **Publisher<T> => Flowable<T>** (Es una implementation de Publisher<T>)
* **Subscriber<T> => Subscriber<T>**
* **Subscription  => Subscription**
* **Processor<T,R> => FlowableProcessor<T>**

**RxJava** provee interfaces adicionales como es el caso de **SingleSubscriber<T>** que se emplea para subscribirse a un solo elemento:
 
```java
 interface SingleObserver<T>
 {
     	void onSubscribe(Disposable d);
     	void onSuccess(T value);
     	void onError(Throwable error)
  }
```
** CompletableSubscriber** : completa o dispara un error:
 
 ``` java
 interface CompletableObserver<T>
 {
     	void onSubscribe(Disposable d);
     	void onComplete();
     	void onError(Throwable error)
  }
   ```
### RxJava Wrapping Para comportamiento no Reactivo
* Flowable.fromCallable() => Retorna Flowable que cuando un subscriber se subscribe a el, este emite el valor retornado por la funcion que implememta call()
* Observable.fromCallable()
* Single.fromCallable()
* Completable.fromCallable()
* Maybe.fromCallable()
* Flowable.fromRunnable() => Esta funcion ejecuta un objeto Runnable en cada uno de los Subscribers que se subscriben a el.

## RxJava Observing Sources

* Observable<T>:

 ```java
 interface Observer<T>
 {
     	void onSubscribe(Disposable d);
     	void onNext(T Value)
     	void onComplete();
     	void onError(Throwable error)
  }
  ```
     
 ``` java
 interface Disposable
 {
		 void dispose();
 }
 ```
* Flowable<T>:

 ```java
public interface Subscriber<T>
 {
     public void onSubscribe(Subscription s);
     public void onNext(T t);
     public void onError(Throwable t);
     public void onComplete();
 }
```

* Subscription: 

 ```java
public interface Subscription
{
    public void request(long l);
    public void cancel();
}
```

## Operators
Los operadores en general realizan los siguientes comportamentos
* Transformar la salida de un Publisher
* Retornar un Publisher luego de una modificacion

## Final Project
Se creara una un servicio web FOREX empleando el framework opensource Jersey para ello se desarrollaron los siguientes endpoints, se empleo como api de terceros fixer.io
* GET /rates/EUR/USD
* GET /stronger/EUR/USD

El projecto fue dividido en varias fases descritas a continuacion:

* V0-Project-Setup
* V1-Spring-Jersey-Integration
* V2-Rates-Endopoint
* V3-Stronger-Endpoint
* V4-Error-Handling
* V5-Unit-Testing