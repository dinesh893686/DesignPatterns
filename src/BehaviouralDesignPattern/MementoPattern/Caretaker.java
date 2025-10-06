package BehaviouralDesignPattern.MementoPattern;

import java.util.Stack;

// caretaker class: Manage mementos(Snapshot of the text editor state)
public class Caretaker {

    private final Stack<EditorMemento> history = new Stack<>();

    public void saveState(TextEditor editor)
    {
        history.push(editor.save());
    }

    public void undo(TextEditor editor)
    {
        if(!history.isEmpty())
        {
            history.pop();
           editor.restore(history.peek());
        }
    }
}
