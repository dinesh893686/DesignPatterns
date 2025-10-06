package DocumentWorkflowStateDesignPattern;

public class Document {
    private State state;
    State draftState;
    State reviewState;
    State approvedState;
    State rejectedState;

   public Document()
   {
       draftState =new Draft(this);
       reviewState=new Review(this);
       approvedState=new Approved(this);
       rejectedState= new Rejected(this);
       state=draftState;
   }

   public void draft()
   {
       state.Draft();
   }

   public void review()
   {
       state.Review();
   }

   public void approved()
   {
       state.Approved();
   }

   public void rejected()
   {
       state.Rejected();

   }

   public void setState(State state)
   {
       this.state=state;
   }

   public State getStateForDraft()
   {
       return draftState;
   }

   public State getStateForReview()
   {
       return reviewState;
   }

   public State getStateForApproval()
   {
       return approvedState;
   }

   public State getStateForRejection()
   {
       return rejectedState;
   }


}
