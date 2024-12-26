# customwordcount

## Introduction
This project implements certain functionalities of ```wc``` in java. ```wc``` is a linux command line tool,
it is used to count no. of lines, bytes, characters or words in a file or from standard input.

## How to run?

### Prerequisites
1. Java 17 or later
2. maven installed
3. root permission for installation

### Installation
```
$ root bash/setup.sh
```

### Run
```
$ ccwc test.txt 
7145 58164 342190 test.txt

$ echo "Hi there" | ccwc
1 2 9
```

## Implementation
* Used Jcommandar to parse input arguments
* Used maven-assembly-plugin plugin to generate an uber jar.
* Used Observer design pattern to structure the code.


## Links
* [Challenge URL](https://codingchallenges.substack.com/p/coding-challenge-1)