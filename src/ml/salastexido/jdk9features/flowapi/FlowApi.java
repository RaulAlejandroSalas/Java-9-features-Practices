/**
 * 
 */
package ml.salastexido.jdk9features.flowapi;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

/**
 * @author RSAL182
 *
 */

public class FlowApi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//			Integer sum=	Arrays.asList(new Animal("A",12), new Animal("B",15), new Animal("C",8),new Animal("A",3),new Animal("A",11),new Animal("B",4))
//						   .stream()
//						   .filter(animal->animal.getName().startsWith("A"))
//						   .map(Animal::getAge)
//						   .collect(Collectors.summingInt(Integer::intValue));
//		 System.out.println("Total Age: " + sum);		
		 
		 
		 //Instanciando un subscriber
		 new AnimalPublisher()
		 					 .subscribe(new AnimalSubscriber(100));
	}

}
