package DocumentWorkflowStateDesignPattern;

public class Approved implements State{

      private final Document document;

      public Approved(Document document)
      {
          this.document=document;
      }

      @Override
      public void Draft()
      {
          System.out.println("Document is in approved cannot move to draft state");
      }

      @Override
      public void Review()
      {
          System.out.println("Document is in approve state cannot move to review state");
      }

      @Override
    public void Approved()
      {
          System.out.println("Document is already approved");
      }

      @Override
    public void Rejected()
      {
          System.out.println("Document is rejected");
          document.setState(document.getStateForRejection());
      }
}
