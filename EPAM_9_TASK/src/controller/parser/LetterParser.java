package controller.parser;

import model.entities.Letter;
import model.entities.Word;

public class LetterParser implements Parser {
    private Word word;

    public Word getWord() {
        return word;
    }

    @Override
    public void parseData(String wordString) {
        word = new Word();
        for (int i = 0; i < wordString.length(); i++) {
            word.addLetter(new Letter(String.valueOf(wordString.charAt(i))));
        }
    }
}