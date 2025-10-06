package SOLIDPRINCIPLES.LSP.BadCode;

public class ReadOnlyFile extends File {
    public void write()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
