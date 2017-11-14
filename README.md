# DistributedExecutorService

Prototype Distributed Executor Service made as part of a final project for EE360P Concurrent and Distributed Systems by Jonathan Friesen and Rob Golshan

The goal of this project is to create an Executor Service that sends threads to multiple computers to perform work while keeping the same ease-of-use on the programmer's side. The source files are separated into Demos, the distributed executor service, the tests used to check features of the program, and the work node code. There are several demos to get a quick look at what this project is all about. Demo_Outputs.pdf has pictures of what the output of these demos should look like. Demo_Callables_Detailed_guide.pdf will show you how to run to run the Callables Demo from a to z, starting with installing JDK. This project uses java Remote Method Invocation or RMI that provides an interface for classes to call methods on remote classes that may not be on the same machine. This is done by starting up an RMIregistry that all the work nodes will register with. An executor service identifies a Registry when it is initialized and uses the nodes registered to it to perform work. These work nodes are a separate program that could be run on any machine, but for this prototype only localhost has been tested. The WorkNodes can be started using:

java -jar WorkNode.java [host] [port]

Where host and port are the location of your RMI registry.

Using the Executor Service: 
Right now, the executor service is used by including the distributedES package in your project and using it like any other executor service. 
The Distributed Executor Service returns a Distributed Future when submitting which can be used just like any other future. 
To initialize you must start an RMIregistry in the bin directory on a port. When you initialize the distributed executor service in your code you pass in the host name and port the RMIregistry is on. 
Before running your code, you must start up all the work nodes you need. 
You can look at the Demos or the PDFs to see examples of how to use the executor service.

More on java RMI: https://docs.oracle.com/javase/tutorial/rmi/overview.html
