package com.opensource.observers;

public interface CharacterEventListener {
    void updated(int codePoint);
    int getCount();
    int getSortRank();
}
