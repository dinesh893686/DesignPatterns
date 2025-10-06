package StockTickerLLD;

public class client implements Observer{
    @Override
    public void update(float price, String Symbol) {
        System.out.println("Price of " + Symbol + " is " + price);
    }
}
