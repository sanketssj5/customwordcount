package com.opensource;

import com.opensource.argumentsprocessor.Arguments;
import com.opensource.observers.*;
import com.opensource.charactereventsource.CharacterEventSource;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.opensource.argumentsprocessor.ArgumentParser.parseArguments;

class AppStarter {

    public static final Charset UTF_8 = StandardCharsets.UTF_8;

    public static void main(String args[]) throws IOException {
        Arguments arguments = parseArguments(args);

        BufferedReader bufferedReader = getInputStreamReader(arguments);
        CharacterEventSource charEventEmitter = new CharacterEventSource(bufferedReader);
        addLisentersBasedOnArguments(arguments, charEventEmitter);
        charEventEmitter.process();

        charEventEmitter.sortListeners();
        List<String> ouputItems = getOutputItemsForDisplay(arguments, charEventEmitter);

        String output = String.join(" ", ouputItems);
        System.out.println(output);

    }

    private static BufferedReader getInputStreamReader(Arguments arguments) throws IOException {
        BufferedReader reader;
        if (arguments.getFile() == null) {
            reader = new BufferedReader(new InputStreamReader(System.in, UTF_8));
        } else {
            reader = new BufferedReader(new FileReader(arguments.getFile(), UTF_8));
        }
        if (!reader.ready()) {
            System.out.println("Unable to read input!");
            System.exit(0);
        }
        return reader;
    }

    private static List<String> getOutputItemsForDisplay(Arguments arguments, CharacterEventSource stream) {
        List<String> ouputItems = new ArrayList<>();
        for (CharacterEventListener CharacterEventListener : stream.getObservers()) {
            ouputItems.add(String.valueOf(CharacterEventListener.getCount()));
        }

        if (arguments.getFile() != null) {
            ouputItems.add(arguments.getFile().getName());
        }
        return ouputItems;
    }

    private static void addLisentersBasedOnArguments(Arguments arguments, CharacterEventSource charEventEmitter) {
        boolean noArgumentProvided = true;
        if (arguments.isCountWords()) {
            noArgumentProvided = false;
            charEventEmitter.attach(new WordCounter());
        }
        if (arguments.isCountChars()) {
            noArgumentProvided = false;
            charEventEmitter.attach(new CharacterCounter());
        }
        if (arguments.isShowBytes()) {
            noArgumentProvided = false;
            charEventEmitter.attach(new ByteCounter(UTF_8));
        }
        if (arguments.getCountLines()) {
            noArgumentProvided = false;
            charEventEmitter.attach(new LineCounter());
        }
        if (noArgumentProvided) {
            charEventEmitter.attach(new LineCounter());
            charEventEmitter.attach(new WordCounter());
            charEventEmitter.attach(new ByteCounter(UTF_8));
        }
    }
}