package TemplateMethodPattern;

class CSVParser{
    public void parse()
    {
        openFile();
        // CSV specific parsing logic
        System.out.println("CSV Parsed");
        closeFile();
    }
    private void openFile()
    {
        System.out.println("CSV File Opened");
    }
    private void closeFile()
    {
        System.out.println("CSV File Closed");
    }
}


class JSONParser{
    public void parse()
    {
        openFile();
        // CSV specific parsing logic
        System.out.println("JSON Parsed");
        closeFile();
    }
    private void openFile()
    {
        System.out.println("CSV File Opened");
    }
    private void closeFile()
    {
        System.out.println("CSV File Closed");
    }
}


public class WithoutTemplateMethod {
    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();
        csvParser.parse();
        JSONParser jsonParser = new JSONParser();
        jsonParser.parse();
    }
}
