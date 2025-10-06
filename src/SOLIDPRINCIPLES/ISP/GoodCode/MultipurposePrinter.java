package SOLIDPRINCIPLES.ISP.GoodCode;

import SOLIDPRINCIPLES.ISP.BadCode.Document;

public class MultipurposePrinter implements Copier, Printer, Scanner{
    @Override
    public void copy(Document doc) {

    }

    @Override
    public void print(Document doc)
    {

    }

    @Override
    public void scan(Document doc) {

    }
}
