package OrderManagementSystem;

public interface State {
     void created();
     void paid();
     void shipped();
     void delivered();
     void cancelled();
}
