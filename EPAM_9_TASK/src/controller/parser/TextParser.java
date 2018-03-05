package controller.parser;

import model.entities.Text;

public class TextParser implements Parser {
    private Text text;

    @Override
    public void parseData(String string) {
        ParagraphParser paragraphParser = new ParagraphParser();
        text = new Text(string);
        paragraphParser.setText(text);
        paragraphParser.parseData(string);
    }


    public Text getText() {
        return text;
    }
}