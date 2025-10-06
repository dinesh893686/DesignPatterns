package DocumentWorkflowStateDesignPattern;

public class Draft implements State{

    private final Document document;

    public Draft(Document document)
    {
        this.document = document;
    }

    @Override
    public void Draft(){
          System.out.println("Document is already in draft state");

    }

    @Override
    public void Review()
    {
        System.out.println("Sending document for review");
        document.setState(document.getStateForReview());
    }

    @Override
    public void Approved()
    {
        System.out.println("Draftt is in not yet reviewed");

    }

    @Override
    public void Rejected()
    {
        System.out.println("Draft is not yet reviewed");
    }
}
