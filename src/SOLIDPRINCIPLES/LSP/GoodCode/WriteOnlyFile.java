package SOLIDPRINCIPLES.LSP.GoodCode;

public class WriteOnlyFile extends Writeable{
    
    @Override
    public void write() {
        System.out.println("Write Only File");
    }
}
