/**
 * 
 */
package ml.salastexido.jdk9features.flowapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.ForkJoinPool;

/**
 * @author RSAL182
 *
 */
public class AnimalPublisher implements Publisher<String> {

	private final ExecutorService executor = ForkJoinPool.commonPool();
	private boolean subscribed;
	@Override
	public void subscribe(Subscriber<? super String> subscriber) {
		if(subscribed) {
			subscriber.onError(new IllegalStateException());
		}else {
			subscribed = true;
			subscriber.onSubscribe(new AnimalPublisherSubscription(subscriber,executor));
		}
	}

}
