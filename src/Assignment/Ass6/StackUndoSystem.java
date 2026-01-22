package Assignment.Ass6;

import java.util.ArrayList;
import java.util.List;

public class StackUndoSystem {

    private List<String> stk;
    private String currentWord;

    // Default constructor
    public StackUndoSystem() {
        currentWord = "";
        stk = new ArrayList<>();
        stk.add(currentWord); // initial state
    }

    // PUSH / TYPE operation
    public void push(String word) {
        currentWord = currentWord + word + " ";
        stk.add(currentWord);
    }

    // UNDO / POP operation
    public void undo() {
        if (stk.size() > 1) {
            stk.remove(stk.size() - 1);
            currentWord = stk.get(stk.size() - 1);
        }
        else currentWord = "";
    }

    public String getCurrentWord() {
        return currentWord.trim();
    }

    /**
     * Demonstrates push/undo operations; prints final word
     */
    public static void main(String[] args) {

        StackUndoSystem editor = new StackUndoSystem();

        editor.push("Hello");
        editor.push("World");
        editor.undo();
        editor.push("CS221");

        System.out.println("Current Text: " + editor.getCurrentWord());
    }
}
