package com.opensource.listeners;

public interface CharacterEventListener {
    void updated(int codePoint);

    int getCount();

    int getSortRank();
}
