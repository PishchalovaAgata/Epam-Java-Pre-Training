package controller;

import controller.parser.TextParser;

import model.entities.Text;
import model.SortingTasks;
import view.View;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Controller {
    private static final String PATH = "C:\\untitled4\\files\\test.txt";


    public static void main(String[] args) {
        TextParser parser = new TextParser();
        String string = "";
        try {
            string = new String(Files.readAllBytes(Paths.get(PATH)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        View.print("Text:\n" + string);
        parser.parseData(string);
        Text text = parser.getText();
        View.print("\nDissected and assembled text:\n" + text.buildText());
        SortingTasks sortingTasks = new SortingTasks();
        View.print("\nSorting sentences by Amount of words: \n" + sortingTasks.sortByWordsAmountInSentences(text));
        View.print("\nSorting words by Alphabet: \n" + sortingTasks.sortWordsByAlphabet(text));


    }
}