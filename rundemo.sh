#!/bin/bash

echo -n "building $1"

javac -d bin Src/Demo/$1
