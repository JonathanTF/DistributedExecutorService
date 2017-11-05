#!/bin/bash

if [ ! -d "bin" ]
then
	mkdir bin
fi

echo -n -e "building $1\n"

./javac -d bin/ src/distributedES/RemoteMethods.java src/distributedES/DistributedFutureTask.java src/distributedES/Node.java src/distributedES/DistributedExecutorService.java src/worknode/WorkNode.java

exitValue=$?

if [ $exitValue != 0 ]
then
echo -n -e "build failed: distrubtedES error\n"
exit $exitValue
fi

./javac -d bin/ src/Demo/SleepyHelloWorld.java src/Demo/SleepyHelloWorldCall.java src/Demo/SleepyHelloWorldCall2.java src/Demo/RandomNumber.java src/Demo/RandomNumberRun.java 

exitValue=$?

if [ $exitValue != 0 ]
then
echo -n -e "build failed: Runnable/Callable demo error\n"
exit $exitValue
fi

./javac -d bin/ -classpath bin/ src/Demo/$1.java

exitValue=$?

if [ $exitValue != 0 ]
then
echo -n -e "failed to build $1\n"
exit $exitValue
fi

echo -n -e "Running $1 with parameters $2:$3...\n"
cd bin/
java Demo.$1 $2 $3 $4

