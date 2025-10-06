package StockTickerLLD;

public class Main {
    public static void main(String[] args)
    {
        Stock stock =new Stock("A", 5);
        Stock stock2=new Stock("B", 10);
        client cl= new client();
        stock2.attach(cl);
        stock.attach(cl);
        stock.publish(10, "A");
        stock2.publish(20, "B");
    }
}
