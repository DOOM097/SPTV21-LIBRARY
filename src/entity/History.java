
package entity;

import java.util.Date;


public class History {
    private Reader reader;
    private Book book;
    private Date takeOnBook;
    private Date returnBook;

    public History() {
    }

    public History(Reader reader, Book book, Date takeOnBook, Date returnBook) {
        this.reader = reader;
        this.book = book;
        this.takeOnBook = takeOnBook;
        this.returnBook = returnBook;
    }

    public Date getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Date returnBook) {
        this.returnBook = returnBook;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getTakeOnBook() {
        return takeOnBook;
    }

    public void setTakeOnBook(Date takeOnBook) {
        this.takeOnBook = takeOnBook;
    }

    @Override
    public String toString() {
        return "History{" 
                + "reader=" + reader 
                + ", book=" + book 
                + ", takeOnBook=" + takeOnBook 
                + ", returnBook=" + returnBook 
                + '}';
    }
    
    
}