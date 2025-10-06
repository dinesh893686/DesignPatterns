package TemplateMethodPattern;

abstract class DataParser{
     public final void parse()
     {
         openFile();
         parseData();
         closeFile();
     }
     protected  void openFile(){
         System.out.println("File Opened");
     };
     protected  void closeFile(){
         System.out.println("File Closed");
     };
     protected abstract void parseData();

}

//CSV Parser
class CSVParser2 extends DataParser{
    @Override
    protected void openFile() {
        System.out.println("CSV File Opened");
    }

    @Override
    protected void closeFile() {
        System.out.println("CSV File Closed");
    }

    @Override
    protected void parseData() {
        System.out.println("CSV Parsed");
    }
}

class JSONParser2 extends DataParser{
    @Override
    protected void openFile() {
        System.out.println("JSON File Opened");
    }

    @Override
    protected void closeFile() {
        System.out.println("JSON File Closed");
    }

    @Override
    protected void parseData() {
        System.out.println("JSON Parsed");
    }
}

public class WithTemplateMethod {

    public static void main(String[] args) {
        CSVParser2 csvParser = new CSVParser2();
        csvParser.parse();
        JSONParser2 jsonParser = new JSONParser2();
        jsonParser.parse();
    }
}
