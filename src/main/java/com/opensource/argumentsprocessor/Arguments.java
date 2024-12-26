package com.opensource.argumentsprocessor;


import com.beust.jcommander.Parameter;
import com.beust.jcommander.converters.FileConverter;

import java.io.File;


public class Arguments {
    @Parameter(names={"-l", "--lines"}, description = "Count Lines")
    private boolean countLines = false;

    @Parameter(converter =  FileConverter.class)
    private File file = null;

    @Parameter(names="-c")
    private boolean showBytes = false;

    @Parameter(names="-w")
    private boolean countWords = false;

    @Parameter(names="-m")
    private boolean countChars = false;

    public Boolean getCountLines() {
        return countLines;
    }

    public File getFile() {
        return file;
    }

    public boolean isShowBytes() {
        return showBytes;
    }

    public boolean countWords() {
        return countWords;
    }

    public boolean countCharacters() {
        return countChars;
    }

}
