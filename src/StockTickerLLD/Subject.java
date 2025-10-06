package StockTickerLLD;

public interface Subject {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(float price, String Symbol);

}
