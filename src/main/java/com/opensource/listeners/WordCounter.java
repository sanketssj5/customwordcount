package com.opensource.listeners;

public class WordCounter implements CharacterEventListener {
    State currentState = State.START;
    int wordCount = 0;
    int sortRank = 2;
    public WordCounter() {

    }

    @Override
    public void updated(int codePoint) {
        switch (currentState) {
            case START, SPACE: {
                if (!Character.isWhitespace(codePoint)) {
                    wordCount++;
                    currentState = State.FIRSTCHAR;
                }
            }
            case FIRSTCHAR: {
                if (Character.isWhitespace(codePoint)) {
                    currentState = State.SPACE;
                } else {
                    currentState = State.REPEATEDCHAR;
                }
            }
            case REPEATEDCHAR: {
                if (Character.isWhitespace(codePoint)) {
                    currentState = State.SPACE;
                }
            }
        }

    }

    @Override
    public int getCount() {
        return wordCount;
    }

    public int getSortRank() {
        return sortRank;
    }

    enum State {
        START, SPACE, FIRSTCHAR, REPEATEDCHAR;
    }
}
