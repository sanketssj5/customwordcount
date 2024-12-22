package com.opensource;

import com.beust.jcommander.Parameter;

public class Arguments {
    @Parameter(names={"-l", "--lines"}, description = "Count Lines")
    Boolean countLines = false;
}
