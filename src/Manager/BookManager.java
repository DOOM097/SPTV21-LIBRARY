package Manager;

import Entity.Author;
import Entity.Book;

import java.util.Scanner;

public class BookManager {
    private Scanner scanner;

    public BookManager() {
        scanner = new Scanner(System.in);
    }

    public Book createBookWithAuthot() {
        System.out.print("Введите название книги: ");
        String bookName = scanner.nextLine();
        System.out.print("Введите год издания книги: ");
        String publishedYear = scanner.nextLine();
        System.out.print("Введите количество экземпляров книги: ");
        String quantity = scanner.nextLine();

        Book book = createBook(bookName, new Integer(quantity), Integer.parseInt(publishedYear));
        System.out.print("Введите количество авторов книги:");
        int countAuthorsInBook = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < countAuthorsInBook; i++) {
            System.out.print("Введите имя автора " + (i + 1) + ": ");
            String firstname = scanner.nextLine();
            System.out.print("Введите фамилию автора " + (i + 1) + ": ");
            String lastname = scanner.nextLine();
            System.out.print("Введите год рождения автора " + (i + 1) + ": ");
            String birthday = scanner.nextLine();
            book.addAuthor(createAuthor(firstname, lastname, new Integer(birthday)));
        }
        return book;
    }

    public void printListBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.print(i + 1 + ". " + books[i].getBookName() + ". ");
            for (Author author : books[i].getAuthors()) {
                System.out.printf("%s %s %d. ", author.getFirstname(), author.getLastname(), author.getBirthday());
            }
            System.out.println();
        }
    }

    public Book[] changeBook(Book[] books) {
        System.out.println("Список книг: ");
        for (int i = 0; i < books.length; i++) {
            System.out.print(i + 1 + ". " + books[i].getBookName() + ". ");
            for (Author author : books[i].getAuthors()) {
                System.out.printf("%s %s %d", author.getFirstname(), author.getLastname(), author.getBirthday());
            }
            System.out.println();
        }
        System.out.print("Выберите номер книги для редактирования: ");
        int numBookForEdit = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Название книги: ");
        System.out.println(books[numBookForEdit - 1].getBookName());
        System.out.print("Изменить название книги? (y/n)");
        String edit = scanner.nextLine();
        if (edit.equals("y")) {
            System.out.print("Введите новое название книги: ");
            books[numBookForEdit - 1].setBookName(scanner.nextLine());
        }
        System.out.print("Год издания книги: ");
        System.out.println(books[numBookForEdit - 1].getPublishedYear());
        System.out.print("Изменить год издания книги? (y/n)");
        edit = scanner.nextLine();
        if (edit.equals("y")) {
            System.out.print("Введите новое название книги: ");
            books[numBookForEdit - 1].setPublishedYear(scanner.nextInt());
            scanner.nextLine();
        }
        System.out.print("Количество экземпляров книги: ");
        System.out.println(books[numBookForEdit - 1].getQuantity());
        System.out.print("Изменить количество экземпляров книги? (y/n)");
        edit = scanner.nextLine();
        if (edit.equals("y")) {
            System.out.print("Введите другое количество книги: ");
            books[numBookForEdit - 1].setQuantity(scanner.nextInt());
            scanner.nextLine();
        }
        System.out.println("Авторов у книги " + books[numBookForEdit - 1].getAuthors().length);
        System.out.println("Изменить количество авторов? (y/n)");
        edit = scanner.nextLine();
        if (edit.equals("y")) {
            System.out.print("Введите новое количество авторов: ");
            int newCountAuthorsInBook = scanner.nextInt();
            scanner.nextLine();
            if (newCountAuthorsInBook < books[numBookForEdit - 1].getAuthors().length) {
                int deltaAuthors = books[numBookForEdit - 1].getAuthors().length - newCountAuthorsInBook;
                for (int n = 0; n < deltaAuthors; n++) {
                    books[numBookForEdit - 1] = deleteAuthorBook(books[numBookForEdit - 1]);
                }
            } else {
                for (int i = 0; i < newCountAuthorsInBook; i++) {
                    if (i >= books[numBookForEdit - 1].getAuthors().length) {
                        Author newAuthor = new Author();
                        System.out.print("Введите имя автора " + (i + 1) + ": ");
                        newAuthor.setFirstname(scanner.nextLine());
                        System.out.print("Введите фамилию автора " + (i + 1) + ": ");
                        newAuthor.setLastname(scanner.nextLine());
                        System.out.print("Введите год рождения автора " + (i + 1) + ": ");
                        newAuthor.setBirthday(scanner.nextInt());
                        scanner.nextLine();
                        books[numBookForEdit - 1].addAuthor(newAuthor);
                    } else if (i < books[numBookForEdit - 1].getAuthors().length) {
                        System.out.println(i + 1 + "-й автор: "
                                + books[numBookForEdit - 1].getAuthors()[i].getFirstname() + " " +
                                books[numBookForEdit - 1].getAuthors()[i].getLastname());
                        System.out.print("Изменить имя автора? (y/n)");
                        edit = scanner.nextLine();
                        if (edit.equals("y")) {
                            System.out.print("Введите другое имя автора: ");
                            books[numBookForEdit - 1].getAuthors()[i].setFirstname(scanner.nextLine());
                        }
                        System.out.print("Изменить фамилию автора? (y/n)");
                        edit = scanner.nextLine();
                        if (edit.equals("y")) {
                            System.out.print("Введите другую фамилию автора: ");
                            books[numBookForEdit - 1].getAuthors()[i].setLastname(scanner.nextLine());
                        }
                        System.out.print("Изменить год рождения автора? (y/n)");
                        edit = scanner.nextLine();
                        if (edit.equals("y")) {
                            System.out.print("Введите другой год рождения автора: ");
                            books[numBookForEdit - 1].getAuthors()[i].setBirthday(scanner.nextInt());
                            scanner.nextLine();
                        }
                    }
                }
            }
        }
        return books;
    }

    public Book createBook(String bookName, int quantity, int publishedYear) {
        Book book = new Book();
        book.setBookName(bookName);
        book.setPublishedYear(publishedYear);
        book.setQuantity(quantity);
        return book;

    }

    public Author createAuthor(String firstname, String lastname, int birthday) {
        Author author = new Author();
        author.setBirthday(birthday);
        author.setFirstname(firstname);
        author.setLastname(lastname);
        return author;
    }

    private Book deleteAuthorBook(Book book) {
        for (int i = 0; i < book.getAuthors().length; i++) {
            System.out.println(
                    i+1+". "+book.getAuthors()[i].getFirstname()+" "+
                            book.getAuthors()[i].getLastname());
        }
        System.out.println("Какого автора удалить? ");
        int numDeleteAuthor = scanner.nextInt();
        scanner.nextLine();
        book.removeAuthor(numDeleteAuthor);
        return book;
    }
}