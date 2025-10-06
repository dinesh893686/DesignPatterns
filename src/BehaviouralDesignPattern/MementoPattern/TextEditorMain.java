package BehaviouralDesignPattern.MementoPattern;

public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
       Caretaker ct =new Caretaker();
        textEditor.write("Hello World");
        ct.saveState(textEditor);
        textEditor.write("World");
        ct.saveState(textEditor);

        ct.undo(textEditor);
        //problem -> undo the last write
        System.out.println(textEditor.getContent());
    }
}
