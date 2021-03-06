package Demo;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 *Runnable class that slleps for 4 seconds before printing Hello World
 */

public class SleepyHelloWorld implements Runnable, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void run() {
		System.out.println("Going to Sleep...");
		try {
		
			TimeUnit.SECONDS.sleep(4);
	
		} catch (InterruptedException e) {
			System.out.println("I've been interrupted! :(");
		}
		System.out.println("... Hello World!");
	}		

}

