package controller.parser;

import model.entities.Punctuation;
import model.entities.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PiecesSentenceParser implements Parser {
    private Sentence sentence;

    public void setSentence(Sentence sentence) {
        this.sentence = sentence;
    }

    public Sentence getSentence() {
        return sentence;
    }

    @Override
    public void parseData(String string) {
        sentence = new Sentence();
        LetterParser letterParser = new LetterParser();
        List<String> listMatcher = new ArrayList<>();
        Matcher m = Pattern.compile("[^\\w\\s]+|[\\w-']+").matcher(string);
        while (m.find()) {
            listMatcher.add(m.group().trim());
        }
        for (int i = 0; i < listMatcher.size(); i++) {
            if (listMatcher.get(i).matches("\\w(?<!\\d)[\\w'-]*")) {
                letterParser.parseData(listMatcher.get(i).trim());
                sentence.addWord(letterParser.getWord());
            } else {
                sentence.addPunctuation(new Punctuation(listMatcher.get(i)));
            }
        }
    }
}