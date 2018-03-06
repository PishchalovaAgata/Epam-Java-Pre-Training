package model.entities;

import java.util.*;

public class Sentence implements Comparable<Sentence> {
    public List<PiecesSentence> partsOfSentence;

    public Sentence() {
        partsOfSentence = new ArrayList<>();
    }

    public void addWord(Word word) {
        partsOfSentence.add(word);
    }

    public void addPunctuation(Punctuation punctuation) {
        partsOfSentence.add(punctuation);
    }

    @Override
    public String toString() {
        return partsOfSentence.toString();
    }

    public String buildSentence() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < partsOfSentence.size(); i++) {
            stringBuffer.append((i == partsOfSentence.size() - 1 || partsOfSentence.get(i + 1) instanceof Word) ?
                    (partsOfSentence.get(i).build() + " ") : (partsOfSentence.get(i).build()));
        }
        return stringBuffer.toString();
    }


    public List<Word> getWords() {
        List<Word> words = new ArrayList<Word>();
        for (PiecesSentence p : partsOfSentence) {
            if (p instanceof Word) {
                words.add((Word) p);
            }
        }
        return words;
    }

    @Override
    public int compareTo(Sentence s) {
        return getWords().size() - s.getWords().size();
    }


}