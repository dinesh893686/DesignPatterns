package DocumentWorkflowStateDesignPattern;

public class Main {
    public static void main(String [] args)
    {
        Document document =new Document();
        document.review();
        document.approved();
        document.rejected();
    }
}
