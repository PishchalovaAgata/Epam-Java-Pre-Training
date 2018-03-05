package model.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Text {
    private List<Paragraph> paragraphs;
    private StringBuffer text;

    public Text() {
        paragraphs = new ArrayList<>();
    }

    public Text(String string) {
        paragraphs = new ArrayList<>();
        text = new StringBuffer(string);
    }

    public Text(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }

    @Override
    public String toString() {
        return text.toString();
    }

    public String buildText() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Paragraph paragraph : paragraphs) {
            stringBuffer.append(paragraph.buildParagraph() + "\n");
        }
        return stringBuffer.toString();
    }


    public List<Sentence> getSentences() {
        List<Sentence> sentences = new ArrayList<>();
        for (Paragraph paragraph : paragraphs) {
            sentences.addAll(paragraph.getSentences());
        }
        return sentences;
    }

    public List<Word> getWords() {
        List<Sentence> sentences = getSentences();
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : sentences) {
            words.addAll(sentence.getWords());
        }
        return words;
    }


}