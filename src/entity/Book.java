

package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("serial")
public class Book implements Serializable{
    private String bookName;
    private List<Author> authors;
    private int publishedYear;
    private int quantity;

    public Book() {
        authors = new ArrayList<>();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    
    public void addAuthor(Author author){
        authors.add(author);
    }
    
    public int getPublishedYear() {
        return publishedYear;
    }
    public void removeAuthor(int numberOfAuthor){
        authors.remove(numberOfAuthor);
    }
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" 
                + "bookName=" + bookName 
                + ", authors=" + Arrays.toString(authors.toArray())
                + ", publishedYear=" + publishedYear 
                + ", quantity=" + quantity 
                + '}';
    }
    
}