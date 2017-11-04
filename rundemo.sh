#!/bin/bash

rm -r bin

mkdir bin

echo -n "building $1"

javac -d bin/ src/distributedES/RemoteMethods.java src/distributedES/DistributedFutureTask.java src/distributedES/Node.java src/distributedES/DistributedExecutorService.java

exitValue=$?

if [ $exitValue != 0 ]
then
echo -n "build failed"
exit $exitValue
fi

javac -d bin/ src/Demo/SleepyHelloWorld.java src/Demo/SleepyHelloWorldCall.java src/Demo/SleepyHelloWorldCall2.java

exitValue=$?

if [ $exitValue != 0 ]
then
echo -n "build failed"
exit $exitValue
fi

javac -d bin/ -classpath bin/ src/Demo/$1.java

exitValue=$?

if [ $exitValue != 0 ]
then
echo -n "failed to build $1"
exit $exitValue
fi

echo -n "Running $1..."
cd bin/
java Demo.$1

