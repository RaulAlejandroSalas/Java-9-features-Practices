/**
 * 
 */
package ml.salastexido.jdk9features;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author RSAL182
 *
 */

//Mejorada el api para la interaccion con proccesos del SO
public class ProccessApiImproved {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws Exception {

		Process proc = Runtime.getRuntime().exec(new String[] {"/bin/sh","-c","echo $PPID"});
		
		if(proc.waitFor() ==0) {
			InputStream in = proc.getInputStream();
			int available = in.available();
		
			byte[] outputBytes = new byte[available]; //creando un vector de bytes con el tammano de los datos leidos
			in.read(outputBytes); //copia los datos leidos en outputBytes
			
			String pid = new String(outputBytes);
			System.out.println("PID: " + pid);
			
			//java9
			System.out.println("PID: " + ProcessHandle.current().pid());
			
			
		}
	}

}
