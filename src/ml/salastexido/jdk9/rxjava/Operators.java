package ml.salastexido.jdk9.rxjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Observable;
import ml.salastexido.jdk9.rxjava.models.PostCode;
import ml.salastexido.jdk9features.flowapi.Animal;
import ml.salastexido.jdk9.rxjava.models.*;
/*
 * Operadores de para realizar transformaciones a flujos de datos
 * Map
 * flatMap
 * Cast
 * **/

/**
 *  
 * */
public class Operators {

	//Map
	private static Observable<String> createAnimalsNameObservable(List<String> animalsName){
		return Observable.fromIterable(animalsName).map(name->"Animal " + name);
	}
	
	//flatMap -> Transforma los elementos emitidos por un Publisher en Publishers, 
	//entonces aplana los datos en un solo publisher
	@SuppressWarnings("unused")
	private static Observable<PostCode> createPostCodesInCountryObservable(Country country){
			return Observable.fromIterable(country.getCities())
											.flatMap(city->Observable.fromIterable(city.getPostCodes()));
		
	}
	
	//Cast-> Hace casting de todos los elementos del Publisher en un tipo particular antes de emitirlos de nuevo
	@SuppressWarnings("unused")
	private static Observable<String> createAnimalsNameObservableCast(List<Object> animalsName){
		return Observable.fromIterable(animalsName).cast(String.class);
	}
	

	/**
	 * Operadores Utilitarios
	 * doOnSubscribe
	 * doOnTerminate
	 * doOnEach
	 * */
	@SuppressWarnings("unused")
	private static Observable<String> createAnimalsNameObservableOperatorsUtils(List<String> animasName){
		return Observable.fromIterable(animasName)
										.doOnSubscribe(disposable-> System.out.print("Publisher starting emiting items"))
										.doOnTerminate(()-> System.out.print("Publisher finished emmiting items or with an error") )
										.doOnEach(name-> System.out.print("Publisher  emitted item " + name));
	}

	
	//Merge -> Combina multiples Observables en uno final 
	
	//Zip->Combina multiples Observables en uno final , basado en la aplicacion de una funcion y emite valores basados en la aplicacion de la funcion.
	
	public static void main(String[] args) {
		List<String> animalsName = Arrays.asList(new Animal("A",12),
																	new Animal("B",15), 
																	new Animal("C",8),
																	new Animal("A",3),
																	new Animal("A",11),
																	new Animal("B",4)).stream().map(Animal::getName).collect(Collectors.toList());
		
		//createAnimalsNameObservable(animalsName).subscribe(System.out::println);
		createAnimalsNameObservableOperatorsUtils(animalsName).subscribe(System.out::println);
		
		
		
	}

}
