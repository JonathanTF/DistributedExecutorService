#!/bin/bash

cd bin

echo -n -e "RMI registry started, hit Ctrl-C to terminate\n\n"

./../Oracle/Unix/rmiregistry $1

echo -n -e "RMI exited\n"

