package com.opensource.argumentsprocessor;

import com.beust.jcommander.JCommander;

public class ArgumentParser {
    public static Arguments parseArguments(String[] args) {
        Arguments arguments = new Arguments();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);
        return arguments;
    }
}
