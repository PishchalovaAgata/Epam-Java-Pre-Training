package model;

import model.entities.Sentence;
import model.entities.Text;
import model.entities.Word;

import java.util.Collections;
import java.util.List;


public class SortingTasks {

    public StringBuffer sortByWordsAmountInSentences(Text text) {
        StringBuffer stringBuffer = new StringBuffer();
        List<Sentence> sentences = text.getSentences();
        Collections.sort(sentences);
        for (Sentence s : sentences)
            stringBuffer.append(s.buildSentence()).append("\n");
        return stringBuffer;
    }


    public StringBuffer sortWordsByAlphabet(Text text) {
        StringBuffer stringBuffer = new StringBuffer();
        List<Word> words = text.getWords();
        Collections.sort(words);
        String letter = words.get(0).build().substring(0, 1).toLowerCase();
        boolean redline = false;
        String tabulation = "";
        for (Word word : words) {
            if (!word.build().substring(0, 1).toLowerCase().equals(letter)) {
                redline = true;
                letter = word.build().toLowerCase().substring(0, 1);
            }
            if (redline) {
                tabulation += "\t";
                stringBuffer.append(tabulation + word.build()).append("\n");
            } else {
                stringBuffer.append(tabulation + word.build()).append("\n");
            }
            redline = false;
        }
        return stringBuffer;
    }
}
