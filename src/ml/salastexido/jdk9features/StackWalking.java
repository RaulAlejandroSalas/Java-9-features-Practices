/**
 * 
 */
package ml.salastexido.jdk9features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author RSAL182
 *
 */

/**
 * Permite el facil accesso para filtrado de la informacion generada por los Stacks traces
 * 
 * The walk method opens a sequential streamof StackFrames for the current thread and then appliesthe given function to walk the StackFrame stream.
 * The stream reports stack frame elements in order, from the top most frame that represents the execution point at which the stack was generated to the bottom most frame.
 * The StackFrame stream is closed when the walk method returns.If an attempt is made to reuse the closed stream, IllegalStateException will be thrown. 
 * */
public class StackWalking {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception{
			walkFilterAndGetTenStackFrame().forEach(System.out::println);
	}
	
	private static List<String> walkFilterAndGetTenStackFrame(){
		return StackWalker.getInstance().walk(s-> 
						s.map(frame-> frame.getClassName() + "/" +frame.getMethodName())
						.filter(name->name.startsWith("package.name")).limit(10).collect(Collectors.toList()));
				
	}

}
