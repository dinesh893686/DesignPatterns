package BehaviouralDesignPattern.MementoPattern;

public class TextEditor {
     private String content;

     public void write(String text)
     {
         this.content=text;
     }

     // save the current state of editor
    public EditorMemento save()
    {
        return new EditorMemento(content);
    }

     public String getContent()
     {
         return content;
     }

    public void restore(EditorMemento editor) {
        content=editor.getContent();
    }

}
