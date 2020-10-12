package ml.salastexido.jdk9features.flowapi;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Future;

public class AnimalPublisherSubscription implements Subscription{

	private final Subscriber<? super String> subscriber;
	private final ExecutorService executorService;
	
	private Future<?> future; //para la cancelacion
	
	private List<Animal> animals = Arrays.asList(new Animal("A",12), new Animal("B",15), new Animal("C",8),new Animal("A",3),new Animal("A",11),new Animal("B",4));
	private int animalSent;
	
	public AnimalPublisherSubscription(Subscriber<? super String> subscriber, ExecutorService service) {
		this.subscriber = subscriber;
		this.executorService = service;
		this.animalSent = 0;
	}
	
	@Override
	public  synchronized  void request(long n) {
		 long animalsToSend = n;
		 if(animalsToSend+ animalSent > animals.size()) {
			 animalsToSend = animals.size() - animalSent; // si la cantidad de datos que se quieren enviar es mayor que lo hay disponible entonces
			 																				//actualizado la cantidad de datos que puedo enviar al Subscriber
		 }
		 
		 long finalAnimalsToSend = animalsToSend;
		 this.future = executorService.submit(()->{
			 this.animals.stream().map(Animal::getName).filter(name->name.startsWith("A"))
			 						.skip(animalSent)
			 						.limit(finalAnimalsToSend)
			 						.forEach(subscriber::onNext);
		    animalSent+=finalAnimalsToSend; //actualizo animalSent
			
			 if(animalSent == animals.size()) { // se enviaron todos los datos por lo tanto la requeste debe ser completada
				 													  // notificar al subscriber con signal onComplete
				 subscriber.onComplete();
			 }
		 });
		
	}

	@Override
	public synchronized  void cancel() {
		if(this.future==null) future.cancel(false);
		
	}

}
