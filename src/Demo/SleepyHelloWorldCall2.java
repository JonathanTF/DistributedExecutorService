package Demo;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *Callable thread that Sleeps for 3 seconds before printing Hello World.
 *Returns the string "I'm Already Done" to the caller.
 */


public class SleepyHelloWorldCall2 implements Callable<String>, Serializable {

	private static final long serialVersionUID = 1L;



	@Override
	public String call() throws Exception {
		System.out.println("Feeling Sleepy...");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Hello World!");
		
		
		return "I'm Already Done!";
	}		

}

