package BehaviouralDesignPattern.MementoPattern;

// Mementor class -> stores  the internal state of the text editor

public class EditorMemento {
    private  String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    // save the current state of editor
    public EditorMemento save() {

       return new EditorMemento(content);
    }

    public void restore(EditorMemento memento) {
        content=memento.getContent();
    }

    public String getContent() {
        return content;
    }
}
