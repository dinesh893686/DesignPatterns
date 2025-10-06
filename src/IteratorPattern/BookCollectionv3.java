package IteratorPattern;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BookCollectionv3 implements Iterable<Book> {
    private Set<Book> books = new TreeSet<>();

    public void addBook(Book book)
    {
        books.add(book);
    }

    public Iterator<Book> iterator()
    {
        return books.iterator();
    }
}
