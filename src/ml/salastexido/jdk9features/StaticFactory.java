/**
 * 
 */
package ml.salastexido.jdk9features;

/**
 * @author RSAL182
 *
 */
import java.util.*;
import java.util.Map.Entry;

//Java 9 provee factorias estaticas en una colleccion de interfaces
public class StaticFactory {
	public static void main(String[] args) {
		 //List.of("one").add("two"); //Runtime Exception, Exception in thread "main" java.lang.UnsupportedOperationException
		
		List<String> list  = List.of("one","two","three");
		System.out.println(list);
		
		
		Map<String,Integer> mapIntermediate = Map.of("one",1,"two",2,"three",3);
		System.out.println(mapIntermediate);
		
		
		Map<String,Integer> mapEntries = Map.ofEntries(Map.entry("one",1),Map.entry("two",2));
		System.out.println(mapEntries);
		
		
	}
}
