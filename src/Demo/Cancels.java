package Demo;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import distributedES.DistributedExecutorService;

/**
 *Cancels
 *submits one SleepyHelloWorldCall thread and calls cancel on its future immediately.
 *Will print "Future Cancelled" when get() is called.
 */

public class Cancels {
	static ExecutorService e;
	
	
	public static void main(String[] args) {
		//assuming args are hostname,port number, and number of callables
		String hostname = args[0];
		Integer port = Integer.parseInt(args[1]);
				
		ExecutorService e = new DistributedExecutorService(hostname,port);
	
		Callable<String> t1 = new SleepyHelloWorldCall();

		Future<String> f1 = e.submit(t1);
		
		f1.cancel(true);
		
		System.out.println("On return we got ");
		
		try {
			 System.out.println(f1.get());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		} catch (CancellationException e1){
			
			System.out.println("Future Cancelled");
			
		}
		
		
		
		System.out.println("\nDone!");

	}

}


