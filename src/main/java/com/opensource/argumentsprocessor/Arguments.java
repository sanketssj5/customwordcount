package com.opensource.argumentsprocessor;


import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;

import java.io.File;


public class Arguments {
    @Parameter(names={"-l", "--lines"}, description = "Count Lines")
    Boolean countLines = false;

    @Parameter(converter =  FileConverter.class)
    File file = null;

    @Parameter(names="-c")
    boolean showBytes = false;

    @Parameter(names="-w")
    boolean countWords = false;

    @Parameter(names="-m")
    boolean countChars = false;

    public Boolean getCountLines() {
        return countLines;
    }

    public File getFile() {
        return file;
    }

    public boolean isShowBytes() {
        return showBytes;
    }

    public boolean isCountWords() {
        return countWords;
    }

    public boolean isCountChars() {
        return countChars;
    }


}
