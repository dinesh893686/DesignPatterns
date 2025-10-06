package DocumentWorkflowStateDesignPattern;

public class Review implements State{

    private final Document document;

    public Review(Document document)
    {
        this.document=document;

    }

    @Override
    public void Draft()
    {
        System.out.println("Document is in the review state.Cannot go back to draft state.");
    }

    @Override
    public void Review()
    {
        System.out.println("Document is already in review state");
    }

    @Override
    public void Approved()
    {
       System.out.println("Document is approved");
       document.setState(document.getStateForApproval());
    }

    @Override
    public void Rejected()
    {
        System.out.println("Document is rejected");
        document.setState(document.getStateForRejection());

    }

}
