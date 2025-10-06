package SOLIDPRINCIPLES.LSP.BadCode;

public class Main {

    public static void main(String[] args) {
           File fs =new ReadOnlyFile();
           fs.read();
           fs.write(); // this will throw an exception


    }
}
