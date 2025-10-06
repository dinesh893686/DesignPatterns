package IteratorPattern;

public class ClientV1 {

    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(new Book("Book1"));
        bookCollection.addBook(new Book("Book2"));
        bookCollection.addBook(new Book("Book3"));
        bookCollection.addBook(new Book("Book4"));
        bookCollection.addBook(new Book("Book5"));
        bookCollection.addBook(new Book("Book6"));

        for(int i=0; i<bookCollection.getBooks().size(); i++)
        {
            System.out.println(bookCollection.getBooks().get(i).getTitle());
        }
    }
    }
