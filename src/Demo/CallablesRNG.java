package Demo;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import distributedES.DistributedExecutorService;

/**
 *CallablesRNG
 *Creates a given number RandomNumber callable threads and submits them to the executor service in the order they were submitted.
 *calls get() on the futures in the order they were submitted, and prints the returned random numbers as they are generated.
 */

public class CallablesRNG {
	static ExecutorService e;
	
	public static void main(String[] args) {
		//assuming args are hostname,port number, and number of callables
				String hostname = args[0];
				Integer port = Integer.parseInt(args[1]);
				Integer numcalls = Integer.parseInt(args[2]);
				
				ExecutorService es = new DistributedExecutorService(hostname,port);
				
				ArrayList<Future<Integer>> futures = new ArrayList<Future<Integer>>();
				
				for(int i=0; i<numcalls; i++){
					Callable<Integer> c = new RandomNumber();
					futures.add(es.submit(c));
				}
				
				System.out.println("Results: ");
				
				for(Future<Integer> f : futures){
					try {
						System.out.print(" " + f.get());
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					} 
				}
				
				es.shutdown();
		
		System.out.println("\nDone!");

	}
	

}


