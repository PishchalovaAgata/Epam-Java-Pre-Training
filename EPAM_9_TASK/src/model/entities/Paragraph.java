package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    List<Sentence> sentences;

    public Paragraph() {
        sentences = new ArrayList<>();
    }


    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    @Override
    public String toString() {
        return sentences.toString();
    }

    public String buildParagraph() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Sentence sentence : sentences) {
            stringBuffer.append(sentence.buildSentence());
        }
        return stringBuffer.toString();
    }

    public List<Sentence> getSentences() {
        List<Sentence> sentences1 = new ArrayList<Sentence>();
        for (Sentence p : sentences) {
            if (p instanceof Sentence) {
                sentences1.add((Sentence) p);
            }
        }
        return sentences1;
    }
}
