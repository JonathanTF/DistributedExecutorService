# DistributedExecutorService
Prototype Distributed Executor Service made as part of a final project for EE360P Concurrent and Distributed Systems by Jonathan Friesen and Rob Golshan

The goal of this project is to create an Executor Service that sends threads to multiple computers to perform work while keeping the same ease of use from 
  the programmer's side of using an Executor Service.
The source files are separated into Demos, the distributed executor service, the tests used to check features of the program, and the work node code.
 
This project uses java Remote Method Invocation or RMI that provides an interface for classes to call methods on remote classes that may not be on the 
  same machine. This is done by starting up an RMIregistry that all the work nodes will register with. An executor service identifies a Registry
  when it is initalized and uses the nodes registered to it to perform work. These work nodes are a separate program that could be run on any machine,
  but for this prototype only localhost has been tested. Use the WorkNode.jar, which takes the host and port as arguments and connects to the registry on startup.

Using the Executor Service:
  Right now the executor service is used by including the distributedES package in your project and using it like any other executor service. 
  To initalize you must start an RMIregistry in the bin directory on a port.
  When you initialize the distributed executor service in your code you pass in the host name and port the RMIregistry is on.
  Before running your code you must start up all the work nodes you need.
  You can look at the Demos to see examples of how to use the executor service.
  An in depth pdf guide on how to get the Callables Demo working is also avialable in the main directory.
  
More on java RMI: https://docs.oracle.com/javase/tutorial/rmi/overview.html
