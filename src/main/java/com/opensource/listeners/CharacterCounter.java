package com.opensource.listeners;

public class CharacterCounter implements CharacterEventListener {

    int count = 0;
    int sortRank = 3;

    public CharacterCounter() {

    }

    @Override
    public void updated(int codePoint) {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }

    public int getSortRank() {
        return sortRank;
    }
}
