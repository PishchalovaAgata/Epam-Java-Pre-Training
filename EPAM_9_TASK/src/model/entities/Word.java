package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Word extends PiecesSentence implements Comparable<Word> {
    List<Letter> letters;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Word() {
        letters = new ArrayList<>();
    }


    public void addLetter(Letter letter) {
        letters.add(letter);
    }

    @Override
    public String build() {
        StringBuffer stringBuffer = new StringBuffer();
        letters.forEach(stringBuffer::append);
        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return letters.toString();
    }

    @Override
    public int compareTo(Word o) {
        return letters.toString().toLowerCase().compareTo(o.toString().toLowerCase());
    }
}