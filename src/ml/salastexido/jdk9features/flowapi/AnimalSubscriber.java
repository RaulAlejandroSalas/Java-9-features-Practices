package ml.salastexido.jdk9features.flowapi;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class AnimalSubscriber implements Subscriber<String> {

	private Subscription subscription;
	final long bufferSize;
	long count;
	
	
	public AnimalSubscriber(long bufferSize) {
		this.bufferSize = bufferSize;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
			long initialRequestSize = bufferSize;
			count = bufferSize - bufferSize/2; //en cada momento consumir solo la mitad de los datos es solo para simulacion
			(this.subscription = subscription ).request(initialRequestSize);
	}

	@Override
	public void onNext(String item) {
		if(--count<=0) {
			subscription.request(count = bufferSize - bufferSize/2); 
		}	
		System.out.println("Subscriber Element Receiver : " +item);
	}

	@Override
	public void onError(Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.print("Subscriber has been Completed...");
	}

}
