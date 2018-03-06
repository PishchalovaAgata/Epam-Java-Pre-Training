package model.entities;

public class Letter {
    private String value;

    public Letter(String value) {
        this.value = value;
    }

    public void setLetter(String value) {
        this.value = value;
    }

    public String getLetter() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}