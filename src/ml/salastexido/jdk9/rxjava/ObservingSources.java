package ml.salastexido.jdk9.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableObserver;

/**
 * En lugar de usar Subscriber/Observer es posible 
 * usar DisposableSubscriber/DisposableObserver
 * */
public class ObservingSources {

	public static void main(String[] args) {

			Disposable disposable =Observable.just("Hello World").subscribeWith(new DisposableObserver<String>() {
				@Override
				public void onNext(@NonNull String t) {
					System.out.print(t);
				}
				@Override
				public void onError(@NonNull Throwable e) {}
				@Override
				public void onComplete() {
					System.out.println("\nCompleted...");
				}	
			});
			
			disposable.dispose();
		
	}

}
