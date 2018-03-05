package controller.parser;

import model.entities.Paragraph;

public class SentenceParser implements Parser {
    private Paragraph paragraph;

    public void setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
    }

    public Paragraph getParagraph() {
        return paragraph;
    }

    @Override
    public void parseData(String s) {
        PiecesSentenceParser sentencePartParser = new PiecesSentenceParser();
        paragraph = new Paragraph();
        String[] arraySentences = s.split("(?<=[.?!])\\s");
        for (int i = 0; i < arraySentences.length; i++) {
            sentencePartParser.parseData(arraySentences[i].trim());
            paragraph.addSentence(sentencePartParser.getSentence());
        }
    }
}