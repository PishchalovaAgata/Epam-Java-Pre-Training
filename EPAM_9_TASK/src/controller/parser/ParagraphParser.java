package controller.parser;

import model.entities.Text;

public class ParagraphParser implements Parser {
    private Text text;

    public void setText(Text text) {
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    @Override
    public void parseData(String string) {
        SentenceParser parser = new SentenceParser();
        String stringText = text.toString();
        String[] arrayParagraphs = stringText.split("(\\n)");
        for (int i = 0; i < arrayParagraphs.length; i++) {
            parser.parseData(arrayParagraphs[i].trim());
            text.addParagraph(parser.getParagraph());
        }
    }
}