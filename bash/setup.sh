#!/bin/bash
JAR_NAME=customwordcount-1.0.jar
PWD=$(pwd)
SCRIPT_DIR=$(dirname "$(readlink -f "$0")")
cd $SCRIPT_DIR/../
mvn clean install
cd $SCRIPT_DIR
chmod +x ccwc
cp ccwc /usr/local/bin/
cp $JAR_NAME /usr/local/bin/
cd $PWD