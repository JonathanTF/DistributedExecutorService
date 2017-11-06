#!/bin/bash

if [ ! -d "bin" ]
then
	echo -n -e "Binaries missing. Exiting...\n"
	exit 0
fi

echo -n -e "Running $1 with parameters $2:$3...\n"
cd bin/
java Demo.$1 $2 $3 $4

exitValue=$?

if [ $exitValue != 0 ]
then
echo -n -e "failed to run $1\n"
exit $exitValue
fi


