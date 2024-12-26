package com.opensource.charactereventsource;

import com.opensource.listeners.CharacterEventListener;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CharacterEventSource {
    List<CharacterEventListener> eventListeners = new ArrayList<>();
    Reader reader;

    public CharacterEventSource(Reader reader) {
        this.reader = reader;
    }

    public void process() throws IOException {
        int c;
        while ((c = reader.read()) != -1) {
            for (CharacterEventListener listener : eventListeners) {
                listener.updated(c);
            }
        }
    }


    public void attach(CharacterEventListener listener) {
        eventListeners.add(listener);
    }

    public void detach(CharacterEventListener listener) {
        eventListeners.remove(listener);
    }

    public List<CharacterEventListener> getListeners() {
        return eventListeners;
    }

    public void sortListeners() {
        Collections.sort(eventListeners, Comparator.comparingInt(CharacterEventListener::getSortRank));
    }
}
