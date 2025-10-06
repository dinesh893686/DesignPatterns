package CommandPattern;

class TextEditor {
   public void boldText()
   {
    System.out.println("Bold Text");
   }
   public void italicText()
   {
    System.out.println("Italic Text");
   }
   public void underlineText()
   {
   System.out.println("Underline Text");
   }
}

class BoldButton{
    private final TextEditor textEditor;

    public BoldButton(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void onClick()
    {

        textEditor.boldText();
    }
}

class ItalicButton{
    private final TextEditor textEditor;

    public ItalicButton(TextEditor textEditor) {
        this.textEditor = textEditor;
    }
    public void onClick()
    {
        textEditor.italicText();
    }
}

class UnderlineButton{
    private final TextEditor textEditor;
    public UnderlineButton(TextEditor textEditor) {
        this.textEditor = textEditor;
    }
    public void onClick()
    {
        textEditor.underlineText();
    }
}

public class WithoutCommandPattern {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        BoldButton boldButton = new BoldButton(textEditor);
        boldButton.onClick();

        ItalicButton italicButton = new ItalicButton(textEditor);
        italicButton.onClick();

        UnderlineButton underlineButton = new UnderlineButton(textEditor);
        underlineButton.onClick();
    }
}
