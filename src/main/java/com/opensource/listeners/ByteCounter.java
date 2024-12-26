package com.opensource.listeners;

import java.nio.charset.Charset;

public class ByteCounter implements CharacterEventListener {

    int count = 0;
    int sortRank = 4;
    Charset charset;
    public ByteCounter(Charset charset) {
        this.charset =charset;
    }

    @Override
    public void updated(int codePoint) {
        count += new String(Character.toChars(codePoint)).getBytes(charset).length;
    }

    @Override
    public int getCount() {
        return count;
    }

    public int getSortRank() {
        return sortRank;
    }
}
