package Demo;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *Callable thread that Sleeps for 7 seconds before printing Hello World.
 *Returns the string "I'm Done" to the caller.
 */

public class SleepyHelloWorldCall implements Callable<String>, Serializable {

	private static final long serialVersionUID = 1L;



	@Override
	public String call() throws Exception {
		System.out.println("Feeling Sleepy...");
		TimeUnit.SECONDS.sleep(7);
		System.out.println("Hello World!");
		
		
		return "I'm Done!";
	}		

}

