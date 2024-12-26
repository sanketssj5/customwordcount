#!/bin/bash
JAR_NAME=customwordcount-1.0.jar
PWD=$(pwd)
SCRIPT_DIR=$(dirname "$0")
cd $SCRIPT_DIR
chmod +x ccwc
rm -f /usr/local/bin/ccwc
rm -f /usr/local/bin/$JAR_NAME
cd $PWD
