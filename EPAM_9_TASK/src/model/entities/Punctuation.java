package model.entities;

public class Punctuation extends PiecesSentence {
    private String value;

    public Punctuation(String string) {
        this.value = string;
    }

    public void setSymbol(String string) {
        this.value = string;
    }

    public String getSymbol() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public String build() {
        return value;
    }
}