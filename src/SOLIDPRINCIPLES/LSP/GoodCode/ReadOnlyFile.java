package SOLIDPRINCIPLES.LSP.GoodCode;

public class ReadOnlyFile extends Readable{

    @Override
    public void read()
    {
        System.out.println("Read from ReadOnlyFile");
    }

}
