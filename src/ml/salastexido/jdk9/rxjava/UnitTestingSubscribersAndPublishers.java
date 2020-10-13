package ml.salastexido.jdk9.rxjava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import ml.salastexido.jdk9.rxjava.models.User;

//Testing Subscribers
//Testing Publishers

public class UnitTestingSubscribersAndPublishers {

		private User expectedUser=new User();
		private User resultUser;
	
	
		public Observable<User> loadUserFromDataBase(){
			return Observable.fromCallable(()->new User()); //Cualquier Subscribtor que se subscriba recibira un objeto User;
		}
		
		@Test
		public void testloadUserFromDataBase() {
			loadUserFromDataBase().subscribe(new Consumer<User>() {

				@Override
				public void accept(@NonNull User user) throws Throwable {
					resultUser = user;
					expectedUser =user;
				}
				
			});
			
			assertEquals(expectedUser, resultUser);
		}	
	
}
