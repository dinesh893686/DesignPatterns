package DocumentWorkflowStateDesignPattern;

public interface State {
       void Draft();
       void Review();
       void Approved();
       void Rejected();
}


