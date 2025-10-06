package CommandPattern;

//Receiver: TextEditor Class
interface Command {
    void execute();
}

class TextEditorII {
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

//Concrete classes for commands
class BoldCommand implements Command{
    private final TextEditorII textEditor;

    public BoldCommand(TextEditorII textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.boldText();
    }
}

class ItalicCommand implements Command {
    private final TextEditorII textEditor;

    public ItalicCommand(TextEditorII textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        textEditor.italicText();
    }
}

class Button {
    private Command command;

    public Button(Command command) {
        this.command = command;
    }
    public void setCommand(Command command) {
        this.command = command;
    }

    public void onClick()
    {
        command.execute();
    }
}

public class WithCommandPattern {
        public static void main(String[] args) {
        TextEditorII textEditor = new TextEditorII();
        BoldCommand boldCommand = new BoldCommand(textEditor);
        Button boldButton = new Button(boldCommand);
        boldButton.onClick();
        //        boldCommand.execute();
        //        ItalicCommand italicCommand = new ItalicCommand(textEditor);
       //        italicCommand.execute();

    }
}

