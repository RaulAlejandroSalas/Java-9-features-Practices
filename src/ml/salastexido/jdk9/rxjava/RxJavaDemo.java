package ml.salastexido.jdk9.rxjava;

import java.util.concurrent.Callable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

public class RxJavaDemo {

	public static void main(String[] args) {
			
		   /**
		    * Emiting Scalar Values
		    * 
				Flowable.fromArray(array)
				Flowable.fromIterable(list)
				
				Observable.just(Object)
		    	Observable.fromArray(array)
				Observable.fromIterable(list)
		    * */
           //Wrapping Non-Reactive Behaviors
		
		/*
		 * Returns a Flowable that, when a Subscriber subscribes to it, 
		 * invokes a function you specify and then emits the value returned from that function. 
		 * **/
			Flowable.fromCallable(new Callable<String>() {
				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					return null;
				}
			});
			/**
			 * Returns a Flowable instance that runs the given Runnable for each subscriber and emits either its exception or simply completes. 
			 * */
			Flowable.fromRunnable(new Runnable() {
				
				@Override
				public void run() {
					System.out.print("Hello World!!");
					
				}
			});
			
			/*
			 * Flow Creation
			 * Flowable.create()
			 * Observable.create()
			 * Single.create()
			 * Completable.create()
			 * Maybe.create()
			 * **/
			
			Observable.create(new ObservableOnSubscribe<String>() {
				@Override
				public void subscribe(@NonNull ObservableEmitter<@NonNull String> emitter) throws Throwable {
						emitter.onNext("Hello World!!");
						emitter.onComplete();
					
				}
			});
	}

}
