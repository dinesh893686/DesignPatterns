package IteratorPattern;

public class ClientV2 {

    public static void main(String[] args) {
        BookCollectionV2 bookCollection = new BookCollectionV2();
        bookCollection.addBook(new Book("Book1"));
        bookCollection.addBook(new Book("Book2"));
        bookCollection.addBook(new Book("Book3"));
        bookCollection.addBook(new Book("Book4"));
        bookCollection.addBook(new Book("Book5"));
        bookCollection.addBook(new Book("Book6"));

        Iterator<Book> iterator = bookCollection.getIterator();
        while (iterator.hasNext())
        {
            Book book = iterator.next();
            System.out.println(iterator.next().getTitle());
        }
    }
}
