package DocumentWorkflowStateDesignPattern;

public class Rejected implements State{

    private final Document document;

    public Rejected(Document document)
    {
        this.document=document;
    }
    @Override
    public void Draft()
    {
        System.out.println("Document is rejected cannot move to draft state");
    }
    @Override
    public void Review()
    {
        System.out.println("Document is rejected cannot move to review state");
    }

    @Override
    public void Approved()
    {
        System.out.println("Document is rejected cannot move to approved state");
    }

    @Override
    public void Rejected()
    {
        System.out.println("Document is already rejected");
    }
}
