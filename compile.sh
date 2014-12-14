#!/bin/bash
#
# @author David Soler <aensoler@gmail.com>
#
# Compiles the project in the "bin" folder from the "src" resources.
#
mkdir -p bin

javac -d bin -sourcepath src -cp src:lib/* src/Launcher.java
