
package sptv21library;

import entity.Author;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class App {
    private Book[] books;
    private Reader[] readers;
    private History[] histories;

    public App() {
        books = new Book[0];
        readers = new Reader[0];
        histories = new History[0];
    }
    
    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        
        History history = null;
        do{
            System.out.println("Задачи: ");
            System.out.println("0. Закончить программу");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Выдать книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("5. Список выданных книг");
            System.out.println("6. Вывод всех книг");
            System.out.println("7. Вывод всех читателей");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.println("1. Добавить книгу");
                    System.out.print("Введите название книги: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Введите год издания книги: ");
                    String publishedYear = scanner.nextLine();
                    System.out.print("Введите количество экземпляров книги: ");
                    String quantity = scanner.nextLine();
                    
                    Book book = createBook(bookName, new Integer(quantity), Integer.parseInt(publishedYear));
                    System.out.print("Введите количество авторов книги:");
                    int countAuthorsInBook = scanner.nextInt(); scanner.nextLine();
                    for (int i = 0; i < countAuthorsInBook; i++) {
                        System.out.print("Введите имя автора "+(i+1)+": ");
                        String firstname = scanner.nextLine();
                        System.out.print("Введите фамилию автора "+(i+1)+": ");
                        String lastname = scanner.nextLine();
                        System.out.print("Введите год рождения автора "+(i+1)+": ");
                        String birthday = scanner.nextLine();
                        book.addAuthor(createAuthor(firstname, lastname, new Integer(birthday)));
                    }
                    Book[] newBooks = new Book[this.books.length+1];
                    newBooks[newBooks.length-1] = book;
                    this.books = newBooks;
                    break;
                case 2:
                    System.out.println("2. Добавить читателя");
                    Reader reader = new Reader();
                    System.out.print("Введите имя читателя: ");
                    reader.setFirstname(scanner.nextLine());
                    System.out.print("Введите фамилию читателя: ");
                    reader.setLastname(scanner.nextLine());
                    System.out.print("Введите телефон читателя: ");
                    reader.setPhone(scanner.nextLine());
                    Reader[] newReader = new Reader[this.readers.length + 1];
                    newReader[newReader.length-1] = reader;
                    this.readers = newReader;
                    break;
                case 3:
                    System.out.println("3. Выдать книгу");
                    System.out.println("Список читателей: ");
                    for (int i = 0; i < readers.length; i++) {
                        System.out.println(i+1+". "+readers[i].getFirstname()+" "+readers[i].getLastname());
                    }
                    System.out.print("Выбери читателя: ");
                    int numberReader = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Список книг: ");
                    for (int i = 0; i < books.length; i++) {
                        System.out.print(i+1+". "+books[i].getBookName()+". ");
                for (Author author : books[i].getAuthors()) {
                    System.out.printf("%s %s %d", author.getFirstname(), author.getLastname(), author.getBirthday());
                }
                        System.out.println();
                    }
                    System.out.print("Выбери номер книги: ");
                    int numberBook = scanner.nextInt();scanner.nextLine();
                    history = new History();
                    history.setBook(books[numberBook - 1]);
                    history.setReader(readers[numberReader-1]);
                    history.setTakeOnBook(new GregorianCalendar().getTime());
                    History[] newHistories = new History[this.histories.length+1];
                    newHistories[newHistories.length-1] = history;
                    this.histories = newHistories;
                    System.out.println(history);
                    break;
                case 4: 
                    System.out.println("4. Вернуть книгу");
                    history.setReturnBook(new GregorianCalendar().getTime());
                    System.out.println(history);
                    break;
                case 5: 
                    System.out.println("5. Список выданных книг");
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i].getReturnBook() == null){
                            System.out.print(i+1+". "+histories[i].getBook().getBookName()+". ");
                            for (Author author : histories[i].getBook().getAuthors()) {
                                System.out.printf("%s %s %d", author.getFirstname(), author.getLastname(), author.getBirthday());
                            }
                            System.out.println();
                        }
                    }
                    break;
                    
                case 6:
                    System.out.println("6. Список всех книги");
                    for (int i=0; i<books.length; i++){
                        System.out.println(i+1+". "+books[i]);
                    break;    
                    }
                case 7:
                    System.out.println("7. Список всех читателей");
                    for (int i=0; i<readers.length; i++){
                        System.out.println(i+1+". "+readers[i]);
                    }
                default:
                    System.out.println("Выберите задачу из списка!");;
            }
            
        }while(repeat);
        System.out.println("Закрытие программы, досвидания!");
    }
    public Book createBook(String bookName,int quantity, int publishedYear){
        Book book = new Book();
        book.setBookName(bookName);
        book.setPublishedYear(publishedYear);
        book.setQuantity(quantity);
        return book;
    }
    public Author createAuthor(String firstname, String lastname, int birthday){
        Author author = new Author();
        author.setBirthday(birthday);
        author.setFirstname(firstname);
        author.setLastname(lastname);
        return author;
    }
}