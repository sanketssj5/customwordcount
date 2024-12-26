package com.opensource.observers;

public class LineCounter implements CharacterEventListener {

    int count = 0;
    private static final int newlineCodePoint = "\n".codePointAt(0);
    int sortRank = 1;
    public LineCounter() {

    }
    @Override
    public void updated(int codePoint) {
        if(newlineCodePoint == codePoint) count++;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int getSortRank() {
        return sortRank;
    }
}
