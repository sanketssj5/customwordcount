package com.opensource.charactereventsource;

import com.opensource.observers.CharacterEventListener;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CharacterEventSource {
    List<CharacterEventListener> CharacterEventListeners = new ArrayList<>();
    Reader reader;

    public CharacterEventSource(Reader reader) {
        this.reader = reader;
    }

    public void process() throws IOException {
        int c;
        while( (c= reader.read()) != -1) {
            for(CharacterEventListener CharacterEventListener : CharacterEventListeners) {
                CharacterEventListener.updated(c);
            }
        }
    }


    public void attach(CharacterEventListener CharacterEventListener) {
        CharacterEventListeners.add(CharacterEventListener);
    }

    public void detach(CharacterEventListener CharacterEventListener) {
        CharacterEventListeners.remove(CharacterEventListener);
    }

    public List<CharacterEventListener> getObservers() {
        return CharacterEventListeners;
    }

    public void sortListeners() {
        Collections.sort(CharacterEventListeners, Comparator.comparingInt(CharacterEventListener::getSortRank));
    }
}
