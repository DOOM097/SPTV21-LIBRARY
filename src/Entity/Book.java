package Entity;
import java.util.Arrays;
public class Book {
    private String bookName;
    private Author[] authors;
    private int publishedYear;
    private int quantity;
    private String title;

    public Book() {
        authors = new Author[0];
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author){
        Author[] newAuthors = Arrays.copyOf(authors, authors.length+1);
        newAuthors[newAuthors.length - 1] = author;
        authors = newAuthors;
    }

    public int getPublishedYear() {
        return publishedYear;
    }
    public void removeAuthor(int numberOfAuthor){
        this.getAuthors()[numberOfAuthor-1]=null;
        Author[] newAuthors = new Author[this.getAuthors().length-1];
        int j = 0;
        for (Author author : this.getAuthors()) {
            if (author != null) {
                newAuthors[j] = author;
                j++;
            }
        }
        this.setAuthors(newAuthors);
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
                + ", authors=" + Arrays.toString(authors)
                + ", publishedYear=" + publishedYear
                + ", quantity=" + quantity
                + '}';
    }


}